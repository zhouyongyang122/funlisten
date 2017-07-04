package com.funlisten.business.album.presenter;

import com.funlisten.base.bean.ZYResponse;
import com.funlisten.base.mvp.ZYBasePresenter;
import com.funlisten.service.net.ZYNetSubscriber;
import com.funlisten.service.net.ZYNetSubscription;
import com.funlisten.business.album.contract.ZYAlbumListHomeContract;
import com.funlisten.business.album.model.ZYAblumModel;
import com.funlisten.business.album.model.bean.ZYCatalog;

import java.util.List;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumListHomePresenter extends ZYBasePresenter implements ZYAlbumListHomeContract.IPresenter {

    ZYAlbumListHomeContract.IView mView;

    ZYAblumModel mModel;

    List<ZYCatalog> mCatalogs;

    public ZYAblumListHomePresenter(ZYAlbumListHomeContract.IView view) {
        mView = view;
        mModel = new ZYAblumModel();
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
