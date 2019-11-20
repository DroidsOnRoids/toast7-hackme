#include <jni.h>
#include <string.h>

#define CORRECT_ANSWER "donut"

JNIEXPORT jboolean JNICALL
Java_pl_droidsonroids_hackme_Utils_isAnswerCorrect(JNIEnv *env, jclass type, jstring answer_) {
	jsize answerLength = (*env)->GetStringUTFLength(env, answer_);
	char answer[answerLength + 1];
	(*env)->GetStringUTFRegion(env, answer_, 0, answerLength, answer);
	answer[answerLength] = '\0';

	if (strcmp(answer, CORRECT_ANSWER) == 0) {
		return JNI_TRUE;
	} else {
		return JNI_FALSE;
	}
}