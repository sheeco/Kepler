/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_example_kepler_tools_watch */

#ifndef _Included_com_example_kepler_tools_watch
#define _Included_com_example_kepler_tools_watch
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_example_kepler_tools_watch
 * Method:    createwatch
 * Signature: (Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_example_kepler_tools_watch_createwatch
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_example_kepler_tools_watch
 * Method:    connectToMonitor
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_example_kepler_tools_watch_connectToMonitor
  (JNIEnv *, jobject);

/*
 * Class:     com_example_kepler_tools_watch
 * Method:    sendMsgToMonitor
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_example_kepler_tools_watch_sendMsgToMonitor
  (JNIEnv *, jobject, jstring);

#ifdef __cplusplus
}
#endif
#endif
