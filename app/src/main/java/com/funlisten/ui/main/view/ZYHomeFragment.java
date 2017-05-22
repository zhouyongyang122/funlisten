package com.funlisten.ui.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.funlisten.R;
import com.funlisten.base.mvp.ZYBaseFragment;
import com.funlisten.base.view.ZYLoadingView;
import com.funlisten.ui.main.contract.ZYHomeContract;
import com.funlisten.ui.main.model.bean.ZYHome;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZY on 17/5/11.
 */

public class ZYHomeFragment extends ZYBaseFragment<ZYHomeContract.IPresenter> implements ZYHomeContract.IView {

    @Bind(R.id.rootView)
    RelativeLayout rootView;

    @Bind(R.id.layout_refresh)
    SwipeRefreshLayout layout_refresh;

    @Bind(R.id.scroll_view)
    NestedScrollView scroll_view;

    @Bind(R.id.layout_module_root)
    LinearLayout layout_module_root;

    ZYLoadingView loadingView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zy_fragment_home, container, false);
        ButterKnife.bind(this, view);
        initLoadingView();
        return view;
    }

    private void initLoadingView() {
        loadingView = new ZYLoadingView(mActivity);
        loadingView.attach(rootView);
    }

    @Override
    public void refreshView(ZYHome home) {

    }

    @Override
    public void showLoading() {
        loadingView.showLoading();
    }

    @Override
    public void hideLoading() {
        loadingView.showNothing();
    }

    @Override
    public void showError() {
        loadingView.showError();
    }
}
