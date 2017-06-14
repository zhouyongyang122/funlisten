package com.funlisten.ui.ablum.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.funlisten.base.mvp.ZYBaseFragmentActivity;
import com.funlisten.ui.ablum.presenter.ZYAblumListHomePresenter;
import com.funlisten.ui.ablum.presenter.ZYAblumListPresenter;
import com.funlisten.ui.ablum.view.ZYAblumListHomeFragment;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumListHomeActivity extends ZYBaseFragmentActivity<ZYAblumListHomeFragment> {

    public static Intent createIntent(Context context) {
        return new Intent(context, ZYAblumListHomeActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ZYAblumListHomePresenter(mFragment);
    }

    @Override
    protected ZYAblumListHomeFragment createFragment() {
        return new ZYAblumListHomeFragment();
    }
}
