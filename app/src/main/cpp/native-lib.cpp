#include <jni.h>

//
// Created by Needfeed on 07/12/2020.
//


extern "C" jint
Java_id_ac_ui_cs_mobileprogramming_nataprawiraf_lab_FirstFragment_add(JNIEnv *env, jobject thiz, jint a,
                                                                jint b) {
    return a + b;
}
