package com.funlisten.ui.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.funlisten.R;
import com.funlisten.base.mvp.ZYBaseFragment;
import com.funlisten.ui.login.model.ZYUserManager;
import com.funlisten.utils.ZYToast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZY on 17/5/11.
 */

public class ZYMeFragment extends ZYBaseFragment {

    @Bind(R.id.imgAvatar)
    ImageView imgAvatar;

    @Bind(R.id.textName)
    TextView textName;

    @Bind(R.id.textLoginTip)
    TextView textLoginTip;

    @Bind(R.id.layoutFollowAndFans)
    LinearLayout layoutFollowAndFans;

    @Bind(R.id.textFollows)
    TextView textFollows;

    @Bind(R.id.textFans)
    TextView textFans;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zy_fragment_me, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.imgAvatar, R.id.textName, R.id.textFollows, R.id.textFans
    ,R.id.layoutPic,R.id.layoutDowload,R.id.layoutAlbum,R.id.layoutLove,R.id.layoutSub
    ,R.id.layoutStu,R.id.layoutBuy,R.id.layoutAccountManager,R.id.layoutHelper,R.id.layoutSet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgAvatar:
                ZYToast.show(mActivity,"个人资料页");
                break;
            case R.id.textName:
                if(ZYUserManager.getInstance().isGuesterUser(true)){
                    return;
                }
                break;
            case R.id.textFollows:
                ZYToast.show(mActivity,"关注页");
                break;
            case R.id.textFans:
                ZYToast.show(mActivity,"粉丝页");
                break;
            case R.id.layoutPic:
                ZYToast.show(mActivity,"相册页");
                break;
            case R.id.layoutDowload:
                ZYToast.show(mActivity,"下载页");
                break;
            case R.id.layoutAlbum:
                ZYToast.show(mActivity,"专辑页");
                break;
            case R.id.layoutLove:
                ZYToast.show(mActivity,"喜欢页");
                break;
            case R.id.layoutSub:
                ZYToast.show(mActivity,"订阅页");
                break;
            case R.id.layoutStu:
                ZYToast.show(mActivity,"学习页");
                break;
            case R.id.layoutBuy:
                ZYToast.show(mActivity,"订购页");
                break;
            case R.id.layoutAccountManager:
                ZYToast.show(mActivity,"账号管理页");
                break;
            case R.id.layoutHelper:
                ZYToast.show(mActivity,"帮助页");
                break;
            case R.id.layoutSet:
                ZYToast.show(mActivity,"设置页");
                break;
        }
    }
}
