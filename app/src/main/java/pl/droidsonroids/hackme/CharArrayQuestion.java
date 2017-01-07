package pl.droidsonroids.hackme;

import java.util.Arrays;

public class CharArrayQuestion implements Question {

	private static final char[] CORRECT_ANSWER = new char[]{'c', 'u', 'p', 'c', 'a', 'k', 'e'};

	@Override
	public boolean isAnswerCorrect(String answer) {
		return Arrays.equals(CORRECT_ANSWER, answer.toCharArray());
	}
}
