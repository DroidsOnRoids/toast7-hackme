package pl.droidsonroids.hackme;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;

class HashedQuestion implements Question {
	private static final String CORRECT_ANSWER_HASH = "e9b433698a78182927b563cd6aa522fa9a912b59421ba4aff4da39517459b097";

	@Override
	public boolean isAnswerCorrect(String answer) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			answer += ' ';
			md.update(answer.getBytes(UTF_8));
			return CORRECT_ANSWER_HASH.equals(String.format("%064x", new BigInteger(1, md.digest())));
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
	}

}
