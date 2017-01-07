#include <jni.h>
#include <string.h>

#define correctAnswer "donut"

JNIEXPORT jboolean JNICALL
Java_pl_droidsonroids_hackme_Utils_isAnswerCorrect(JNIEnv *env, jclass type, jstring answer_) {
	const char *answer = (*env)->GetStringUTFChars(env, answer_, NULL);

	const int difference = strncmp(answer, correctAnswer, sizeof(correctAnswer));

	(*env)->ReleaseStringUTFChars(env, answer_, answer);

	if (difference == 0) {
		return JNI_TRUE;
	} else {
		return JNI_FALSE;
	}
}