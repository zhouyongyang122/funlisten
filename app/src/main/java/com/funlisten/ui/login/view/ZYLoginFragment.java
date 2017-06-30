package com.funlisten.ui.login.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.funlisten.R;
import com.funlisten.base.mvp.ZYBaseFragment;
import com.funlisten.ui.login.contract.ZYLoginContract;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZY on 17/6/30.
 */

public class ZYLoginFragment extends ZYBaseFragment<ZYLoginContract.IPresenter> implements ZYLoginContract.IView {

    @Bind(R.id.editMobile)
    EditText editMobile;

    @Bind(R.id.editPwd)
    EditText editPwd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zy_activity_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.layoutWechat, R.id.layoutWeibo, R.id.layoutQQ})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layoutWechat:
                break;
            case R.id.layoutWeibo:
                break;
            case R.id.layoutQQ:
                break;
            case R.id.textLogin:
                break;
            case R.id.textRegist:
                break;
            case R.id.textForget:
                break;
        }
    }

}
