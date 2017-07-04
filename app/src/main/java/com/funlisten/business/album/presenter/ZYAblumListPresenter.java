package com.funlisten.business.album.presenter;

import com.funlisten.base.bean.ZYListResponse;
import com.funlisten.base.bean.ZYResponse;
import com.funlisten.base.mvp.ZYListDataPresenter;
import com.funlisten.service.net.ZYNetSubscriber;
import com.funlisten.service.net.ZYNetSubscription;
import com.funlisten.business.album.contract.ZYAlbumListContract;
import com.funlisten.business.album.model.bean.ZYAlbumDetail;
import com.funlisten.business.album.model.ZYAblumModel;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumListPresenter extends ZYListDataPresenter<ZYAlbumListContract.IView, ZYAblumModel, ZYAlbumDetail> implements ZYAlbumListContract.IPresenter {

    int mCatagoryId;

    public ZYAblumListPresenter(ZYAlbumListContract.IView view, ZYAblumModel model, int categoryId) {
        super(view, model);
        mCatagoryId = categoryId;
    }

    @Override
    protected void loadData() {
        mView.showLoading();
        mSubscriptions.add(ZYNetSubscription.subscription(mModel.getAblums(mPageIndex, mRows, mCatagoryId), new ZYNetSubscriber<ZYResponse<ZYListResponse<ZYAlbumDetail>>>() {
            @Override
            public void onSuccess(ZYResponse<ZYListResponse<ZYAlbumDetail>> response) {
                super.onSuccess(response);
                success(response);
            }

            @Override
            public void onFail(String message) {
                super.onFail(message);
                fail(message);
            }
        }));
    }
}
