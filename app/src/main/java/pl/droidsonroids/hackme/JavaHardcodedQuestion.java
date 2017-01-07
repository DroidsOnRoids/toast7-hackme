package pl.droidsonroids.hackme;

class JavaHardcodedQuestion implements Question {

	@Override
	public boolean isAnswerCorrect(String answer) {
		return "lollipop".equals(answer);
	}
}
