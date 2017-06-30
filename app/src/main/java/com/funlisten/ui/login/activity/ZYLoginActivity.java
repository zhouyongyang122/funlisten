package com.funlisten.ui.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.funlisten.base.mvp.ZYBaseFragmentActivity;
import com.funlisten.ui.login.presenter.ZYLoginPresenter;
import com.funlisten.ui.login.view.ZYLoginFragment;

/**
 * Created by ZY on 17/6/30.
 */

public class ZYLoginActivity extends ZYBaseFragmentActivity<ZYLoginFragment> {

    public static Intent createIntent(Context context) {
        return new Intent(context, ZYLoginActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ZYLoginPresenter(mFragment);
        showTitle("登录");
    }

    @Override
    protected ZYLoginFragment createFragment() {
        return new ZYLoginFragment();
    }
}
