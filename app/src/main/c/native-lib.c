#include <jni.h>
#include <string.h>
#include <stdbool.h>

#define CORRECT_ANSWER "donut"

JNIEXPORT jboolean JNICALL
Java_pl_droidsonroids_hackme_Utils_isAnswerCorrect(JNIEnv *env, jclass type, jstring answer_) {

    const char *nativeString = (*env)->GetStringUTFChars(env, answer_, 0);
    const bool same = strcmp(CORRECT_ANSWER, nativeString) == 0;
    (*env)->ReleaseStringUTFChars(env, answer_, nativeString);
    if (same) {
        return JNI_TRUE;
    } else {
        return JNI_FALSE;
    }
}

