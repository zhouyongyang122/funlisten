package com.funlisten.ui.ablum.presenter;

import com.funlisten.base.bean.ZYResponse;
import com.funlisten.base.mvp.ZYBasePresenter;
import com.funlisten.service.net.ZYNetSubscriber;
import com.funlisten.service.net.ZYNetSubscription;
import com.funlisten.ui.ablum.contract.ZYAblumListHomeContract;
import com.funlisten.ui.ablum.model.ZYAblumsModel;
import com.funlisten.ui.ablum.model.ZYCatalog;

import java.util.List;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumListHomePresenter extends ZYBasePresenter implements ZYAblumListHomeContract.IPresenter {

    ZYAblumListHomeContract.IView mView;

    ZYAblumsModel mModel;

    List<ZYCatalog> mCatalogs;

    public ZYAblumListHomePresenter(ZYAblumListHomeContract.IView view) {
        mView = view;
        mModel = new ZYAblumsModel();
        mView.setPresenter(this);
    }

    public void loadData() {
        mSubscriptions.add(ZYNetSubscription.subscription(mModel.getCatalogs(), new ZYNetSubscriber<ZYResponse<List<ZYCatalog>>>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(ZYResponse<List<ZYCatalog>> response) {
                super.onSuccess(response);
                mCatalogs = response.data;
                mView.refreshCatalogs(mCatalogs);
            }

            @Override
            public void onFail(String message) {
                super.onFail(message);
            }
        }));
    }
}
