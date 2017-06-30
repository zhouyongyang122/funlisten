package com.funlisten.ui.ablum.presenter;

import com.funlisten.base.bean.ZYListResponse;
import com.funlisten.base.bean.ZYResponse;
import com.funlisten.base.mvp.ZYListDataPresenter;
import com.funlisten.service.net.ZYNetSubscriber;
import com.funlisten.service.net.ZYNetSubscription;
import com.funlisten.ui.ablum.contract.ZYAblumListContract;
import com.funlisten.ui.ablum.model.ZYAblum;
import com.funlisten.ui.ablum.model.ZYAblumsModel;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumListPresenter extends ZYListDataPresenter<ZYAblumListContract.IView, ZYAblumsModel, ZYAblum> implements ZYAblumListContract.IPresenter {

    int mCatagoryId;

    public ZYAblumListPresenter(ZYAblumListContract.IView view, ZYAblumsModel model, int categoryId) {
        super(view, model);
        mCatagoryId = categoryId;
    }

    @Override
    protected void loadData() {
        mView.showLoading();
        mSubscriptions.add(ZYNetSubscription.subscription(mModel.getAblums(mPageIndex, mRows, mCatagoryId), new ZYNetSubscriber<ZYResponse<ZYListResponse<ZYAblum>>>() {
            @Override
            public void onSuccess(ZYResponse<ZYListResponse<ZYAblum>> response) {
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
