package com.app.hannahcore.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import com.app.hannahcore.R;

/**
 * Created by Nick on 2019-05-14.
 */
public class DialogUtil extends Dialog {

    protected Context mContext;
    protected LayoutParams mLayoutParams;

    public LayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    public DialogUtil(Context context, int themeResId) {
        super(context, themeResId);
        this.initView(context);
    }

    public DialogUtil(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.initView(context);
    }

    public DialogUtil(Context context) {
        super(context);
        this.initView(context);
    }

    private void initView(Context context) {
        this.requestWindowFeature(1);
        this.getWindow().setBackgroundDrawableResource(R.drawable.transparent_bg);
        this.mContext = context;
        Window window = this.getWindow();
        this.mLayoutParams = window.getAttributes();
        this.mLayoutParams.alpha = 1.0F;
        window.setAttributes(this.mLayoutParams);
        if (this.mLayoutParams != null) {
            this.mLayoutParams.height = -1;
            this.mLayoutParams.gravity = 17;
        }

    }

    public DialogUtil(Context context, float alpha, int gravity) {
        super(context);
        this.requestWindowFeature(1);
        this.getWindow().setBackgroundDrawableResource(R.drawable.transparent_bg);
        this.mContext = context;
        Window window = this.getWindow();
        this.mLayoutParams = window.getAttributes();
        this.mLayoutParams.alpha = 1.0F;
        window.setAttributes(this.mLayoutParams);
        if (this.mLayoutParams != null) {
            this.mLayoutParams.height = -1;
            this.mLayoutParams.gravity = gravity;
        }

    }

    public void skipTools() {
        if (VERSION.SDK_INT >= 19) {
            this.getWindow().setFlags(1024, 1024);
        }
    }

    public void setFullScreen() {
        Window window = this.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = window.getAttributes();
        lp.width = -1;
        lp.height = -1;
        window.setAttributes(lp);
    }

    public void setFullScreenWidth() {
        Window window = this.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = window.getAttributes();
        lp.width = -1;
        lp.height = -2;
        window.setAttributes(lp);
    }

    public void setFullScreenHeight() {
        Window window = this.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = window.getAttributes();
        lp.width = -2;
        lp.height = -1;
        window.setAttributes(lp);
    }

    public void setOnWhole() {
        this.getWindow().setType(2003);
    }
}
