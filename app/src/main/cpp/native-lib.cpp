#include <jni.h>
#include <string>
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

std::string jstring2str(JNIEnv *env, jstring jstr) {
    char *rtn = NULL;
    jclass clsstring = env->FindClass("java/lang/String");
    jstring strencode = env->NewStringUTF("GB2312");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte *ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
    std::string stemp(rtn);
    free(rtn);
    return stemp;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_my_fridademo_MainActivity_hookSO(JNIEnv *env, jobject thiz, jstring name, jint age,
                                          jint grade) {
    std::string nameS = jstring2str(env, name);
    // TODO: implement hookSO()
    if (age > 18) {
        std::string str1 = "， 你已经成年";
        nameS.append(str1);
    } else {
        std::string str1 = "， 你还未成年，不能进入";
        nameS.append(str1);
    }
    return env->NewStringUTF(nameS.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_my_fridademo_MainActivity_hookSO2(JNIEnv *env, jobject thiz, jint num1, jint num2) {
    // TODO: implement hookSO2()
    return num1 + num2;
}