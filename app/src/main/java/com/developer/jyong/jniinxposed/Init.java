package com.developer.jyong.jniinxposed;


import android.util.Log;

import java.io.File;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Init implements IXposedHookLoadPackage {

    private static String TAG = "JNITest";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable {

        if (!param.packageName.equals("com.tencent.mm"))
            return;

        Log.w(TAG, "handleLoadPackage: ------------------------------");

        NativeUtils.load(getPath());
        String result = NativeUtils.stringFromJNI();
        Log.w(TAG, "handleLoadPackage: result " + result);

        Log.w(TAG, "handleLoadPackage: ------------------------------");

    }

    public String getPath() {
        String pkgPath = "/data/app/com.developer.jyong.jniinxposed-";
        String soPath = "/lib/arm/libnative-lib.so";
        String fullPath = "";

        for (int i = 1; i < 3; i++) {
            fullPath = pkgPath + i + soPath;
            if (new File(fullPath).exists()) {
                return fullPath;
            }
        }
        return fullPath;
    }
}
