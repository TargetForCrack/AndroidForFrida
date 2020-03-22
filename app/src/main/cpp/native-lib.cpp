#include <jni.h>
#include <string>
#include <string.h>
#include <android/log.h>
#include <unistd.h>
#include <stdarg.h>
#include <stdio.h>

#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO, "hooktest", __VA_ARGS__)

int getInt(int i) {
    return i + 99;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_my_fridademo_MainActivity_getString(JNIEnv *env, jobject thiz) {
    // TODO: implement getString()
    LOGI("[+] %d\n", getInt(1));
    std::string hello = "a string from ndk";
    return env->NewStringUTF(hello.c_str());
}