package com.commonlib.log;

import android.util.Log;

/**
 * 日志打印类
 *
 * @author LGS
 */
public class ULog implements UConstant {

    private static Boolean isShowLog = true;// 开关

    public static void init(boolean _isShowLog) {
        isShowLog = _isShowLog;
    }

    public static void v(String tag, Object msg) {
        printLog(VERBOSE, tag, msg);
    }

    public static void v(Object msg) {
        printLog(VERBOSE, null, msg);
    }

    public static void d(String tag, Object msg) {
        printLog(DEBUG, tag, msg);

    }

    public static void d(Object msg) {
        printLog(DEBUG, null, msg);

    }

    public static void i(String tag, Object msg) {
        printLog(INFO, tag, msg);

    }

    public static void i(Object msg) {
        printLog(INFO, null, msg);

    }

    public static void w(String tag, Object msg) {
        printLog(WARN, tag, msg);
    }

    public static void w(Object msg) {
        printLog(WARN, null, msg);
    }

    public static void e(String tag, Object msg) {
        printLog(ERROR, tag, msg);
    }

    public static void e(Object msg) {
        printLog(ERROR, null, msg);
    }

    public static void a(String tag, Object msg) {
        printLog(ASSERT, tag, msg);
    }

    public static void a(Object msg) {
        printLog(ASSERT, null, msg);
    }


    private static void printLog(int type, String tagStr, Object objectMsg) {

        if (!isShowLog) {
            return;
        }

        String[] contents = wrapperContent(tagStr, objectMsg);
        String tag = contents[0];
        String msg = contents[1];
        String headString = contents[2];
        switch (type) {
            case VERBOSE:
                Log.v(tag, headString + msg);
                break;
            case DEBUG:
                Log.d(tag, headString + msg);
                break;
            case INFO:
                Log.i(tag, headString + msg);
                break;
            case WARN:
                Log.w(tag, headString + msg);
                break;
            case ERROR:
                Log.e(tag, headString + msg);
                break;
            case ASSERT:
                Log.wtf(tag, headString + msg);
                break;
        }
    }

    private static String[] wrapperContent(String tagStr, Object objectMsg) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int index = 5;
        String className = stackTrace[index].getFileName();
        String methodName = stackTrace[index].getMethodName();
        int lineNumber = stackTrace[index].getLineNumber();
        String methodNameShort = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ (").append(className).append(":").append(lineNumber).append(")#").append(methodNameShort).append(" ] ");
        String tag = (tagStr == null ? className : tagStr);
        String msg = (objectMsg == null) ? "Log with null object" : objectMsg.toString();
        String headString = stringBuilder.toString();

        return new String[]{tag, msg, headString};
    }

}
