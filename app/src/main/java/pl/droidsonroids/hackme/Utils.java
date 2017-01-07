package pl.droidsonroids.hackme;

public final class Utils {
	static {
		System.loadLibrary("native-lib");
	}

	private Utils() {
	}

	public static native boolean isAnswerCorrect(String answer);

}
