package com.funlisten.ui.login.presenter;

import com.funlisten.base.mvp.ZYBasePresenter;
import com.funlisten.ui.login.contract.ZYLoginContract;
import com.funlisten.ui.login.model.ZYLoginModel;

/**
 * Created by ZY on 17/6/30.
 */

public class ZYLoginPresenter extends ZYBasePresenter implements ZYLoginContract.IPresenter {

    ZYLoginContract.IView mView;

    ZYLoginModel mModel;

    public ZYLoginPresenter(ZYLoginContract.IView view) {
        mView = view;
        mView.setPresenter(this);
        mModel = new ZYLoginModel();
    }
}
