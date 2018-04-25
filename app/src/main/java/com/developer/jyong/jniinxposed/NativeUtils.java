package com.developer.jyong.jniinxposed;


import android.util.Log;

public class NativeUtils {

    public static String TAG = "JNITest";

    public static void load(String path) {
        try {
            System.load(path);
            Log.w(TAG, "load Jni library");
        } catch (Throwable e) {
            e.printStackTrace();
            Log.w(TAG, "load jni library have error ");
        }
    }

    public static native String stringFromJNI();

}
