package pl.droidsonroids.hackme;

class NativeHardcodedQuestion implements Question {
	@Override
	public boolean isAnswerCorrect(String answer) {
		return Utils.isAnswerCorrect(answer);
	}
}
