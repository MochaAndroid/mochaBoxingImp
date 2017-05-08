package com.mocha.boxing_imp;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/**
 * @author ChenSL
 */
public class WindowManagerHelper {
    private static WindowManager getWindowManager(Context context) {
        Object service = context.getSystemService(Context.WINDOW_SERVICE);
        if (service == null)
            return null;

        return (WindowManager) service;
    }

    private static Display getDefaultDisplay(Context context) {
        WindowManager wm = getWindowManager(context);
        if (wm == null)
            return null;

        return wm.getDefaultDisplay();
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);
        if (dm != null) {
            return dm.heightPixels;
        }
        return 0;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);
        if (dm != null) {
            return dm.widthPixels;
        }
        return 0;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        Display display = getDefaultDisplay(context);
        if (display != null) {
            DisplayMetrics result = new DisplayMetrics();
            display.getMetrics(result);
            return result;
        }
        return null;
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getToolbarHeight(Context context) {
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            return TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

}
