package pl.droidsonroids.hackme;

final class Utils {
	static {
		System.loadLibrary("native-lib");
	}

	private Utils() {
	}

	public static native boolean isAnswerCorrect(String answer);

}
