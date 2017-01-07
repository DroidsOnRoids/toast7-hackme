#include <jni.h>
#include <string.h>

#define CORRECT_ANSWER "donut"
#define CORRECT_ANSWER_SIZE sizeof(CORRECT_ANSWER)

JNIEXPORT jboolean JNICALL
Java_pl_droidsonroids_hackme_Utils_isAnswerCorrect(JNIEnv *env, jclass type, jstring answer_) {
	char answer[CORRECT_ANSWER_SIZE + 1];
	(*env)->GetStringUTFRegion(env, answer_, 0, CORRECT_ANSWER_SIZE + 1, answer);

	if (strcmp(answer, CORRECT_ANSWER) == 0) {
		return JNI_TRUE;
	} else {
		return JNI_FALSE;
	}
}