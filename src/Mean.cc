#include <jni.h>
#include <iostream>
#include "Lab1.h"
using namespace std;

JNIEXPORT jdouble JNICALL Java_Lab1_mean
    (JNIEnv *env, jobject obj, jintArray arr) {
    // The elements of the array are obtained
    jint *cArray = (*env).GetIntArrayElements(arr, NULL);
    // It is checked that the array is not empty and if it is empty it returns 0.0
    if (cArray == NULL) return 0.0;
    if (obj == NULL) return 0.0;
    // The size of the array is saved
    jsize length = (*env).GetArrayLength(arr);
    
    jint sum = 0;
    int i;
    for (i = 0; i < length; i++) {
        sum += cArray[i];
    }
    jdouble mean = (jdouble)sum / length;
    
    return mean;
}