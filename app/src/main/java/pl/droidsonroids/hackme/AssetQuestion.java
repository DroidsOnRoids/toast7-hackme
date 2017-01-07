package pl.droidsonroids.hackme;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import io.reactivex.Observable;

public class AssetQuestion implements Question {
	private final AssetManager assetManager;

	public AssetQuestion(Context context) {
		assetManager = context.getAssets();
	}

	@Override
	public boolean isAnswerCorrect(final String answer) {
		return Observable.fromCallable(this::getString)
				.map(s -> s.equals(answer))
				.blockingFirst();
	}

	@NonNull
	private String getString() throws IOException {
		try (InputStream stream = assetManager.open("secret.txt")) {
			final byte[] buffer = new byte[11];
			if (stream.read(buffer) != buffer.length) {
				throw new IOException("invalid data");
			}
			return new String(buffer, StandardCharsets.UTF_8);
		}
	}
}
