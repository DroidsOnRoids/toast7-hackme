package pl.droidsonroids.hackme;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;

public class MainActivity extends Activity {

	@BindView(R.id.text_view_question_number)
	TextView textViewQuestionNumber;

	private int currentQuestionIndex;
	private Question[] questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		questions = new Question[]{
				new JavaHardcodedQuestion(),
				new AssetQuestion(this),
				new HashedQuestion(),
				new NativeHardcodedQuestion(),};
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		updateQuestionIndicator();
	}

	@OnEditorAction(R.id.edit_text_answer)
	public boolean onAnswerAction(int actionId, TextView answerView) {
		if (actionId == EditorInfo.IME_ACTION_NEXT) {
			final String answer = answerView.getText().toString().toLowerCase(Locale.ROOT);
			final Question question = questions[currentQuestionIndex];

			if (question.isAnswerCorrect(answer)) {
				onAnswerCorrect();
			} else {
				Toast.makeText(this, R.string.wrong_answer, Toast.LENGTH_SHORT).show();
			}
		}
		return true;
	}

	private void onAnswerCorrect() {
		if (currentQuestionIndex == questions.length - 1) {
			Toast.makeText(this, R.string.finish, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, R.string.correct_answer, Toast.LENGTH_SHORT).show();
			currentQuestionIndex++;
			updateQuestionIndicator();
		}
	}

	private void updateQuestionIndicator() {
		final String text = getResources().getString(R.string.question, currentQuestionIndex + 1);
		textViewQuestionNumber.setText(text);
	}
}
