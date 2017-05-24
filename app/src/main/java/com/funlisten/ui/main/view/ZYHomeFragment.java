package com.funlisten.ui.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.funlisten.R;
import com.funlisten.base.activity.ZYWebViewActivity;
import com.funlisten.base.mvp.ZYBaseFragment;
import com.funlisten.base.view.ZYLoadingView;
import com.funlisten.ui.main.contract.ZYHomeContract;
import com.funlisten.ui.main.model.bean.ZYHome;
import com.funlisten.ui.main.view.viewHolder.ZYHomeBannerVH;
import com.funlisten.utils.ZYStatusBarUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Bind(R.id.viewTop)
    View viewTop;

    ZYLoadingView loadingView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zy_fragment_home, container, false);
        ButterKnife.bind(this, view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewTop.getLayoutParams();
        layoutParams.height = ZYStatusBarUtils.getStatusBarHeight(mActivity);
        viewTop.setLayoutParams(layoutParams);
        initLoadingView();
        return view;
    }

    private void initLoadingView() {
        loadingView = new ZYLoadingView(mActivity);
        loadingView.attach(rootView);
    }

    @OnClick({R.id.layoutSearch})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layoutSearch:
                //跳转到搜索界面
                break;
        }
    }

    @Override
    public void refreshView(ZYHome home) {
        layout_module_root.removeAllViews();
        showBanner(home.recommendBannerDtoList);
    }

    private void showBanner(List<ZYHome.Banner> banners) {
        if (banners != null && banners.size() > 0) {
            ZYHomeBannerVH bannerVH = new ZYHomeBannerVH(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_MOVE:
                            layout_refresh.setEnabled(false);
                            break;
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:
                            layout_refresh.setEnabled(false);
                            break;
                    }
                    return false;
                }
            }, new ZYHomeBannerVH.OnHomeBannerListener() {
                @Override
                public void onBanner(ZYHome.Banner banner) {
                    mActivity.startActivity(ZYWebViewActivity.createIntent(mActivity, banner.url, ""));
                }
            });
            bannerVH.bindView(LayoutInflater.from(mActivity).inflate(bannerVH.getLayoutResId(), layout_module_root, false));
            layout_module_root.addView(bannerVH.getItemView(), 0);
            bannerVH.updateView(banners, 0);
        }
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
