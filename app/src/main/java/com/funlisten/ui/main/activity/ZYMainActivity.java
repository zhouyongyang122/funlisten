package com.funlisten.ui.main.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.funlisten.R;
import com.funlisten.base.mvp.ZYBaseActivity;
import com.funlisten.service.ZYUpdateService;
import com.funlisten.ui.main.contract.ZYMainContract;
import com.funlisten.ui.main.model.bean.ZYVersion;
import com.funlisten.ui.main.presenter.ZYMainPresenter;
import com.funlisten.utils.ZYStatusBarUtils;
import com.funlisten.utils.ZYToast;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by ZY on 17/4/27.
 */

public class ZYMainActivity extends ZYBaseActivity<ZYMainContract.IPresenter> implements ZYMainContract.IView {

    public static final int MAIN_HOME_INDEX = 0;

    public static final int MAIN_ME_INDEX = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.zy_activity_main);

        setPresenter(new ZYMainPresenter(this));

        initView();
        ZYStatusBarUtils.immersiveStatusBar(this, 1);
        if (ZYStatusBarUtils.isCanLightStatusBar()) {
            ZYStatusBarUtils.tintStatusBar(this, Color.TRANSPARENT, 0);
        }
    }

    private void initView() {
        hideActionLeftImg();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void showUpdateView(final ZYVersion version) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("版本更新");
        dialog.setMessage(version.info);
        dialog.setPositiveButton("更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ZYToast.show(mActivity, "正在下载中...");
                startService(ZYUpdateService.createIntent(version.download));
            }
        });
        if (version.keyupdate > 0) {
            //强更
            dialog.setCancelable(false);
        } else {
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
        dialog.create().show();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getVersion();
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this).setTitle("退出").setMessage("是否退出听谁说?")
                .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MobclickAgent.onKillProcess(mActivity);
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("再看看", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
    }
}
