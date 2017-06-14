package com.funlisten.ui.ablum.presenter;

import com.funlisten.base.mvp.ZYListDataPresenter;
import com.funlisten.ui.ablum.contract.ZYAblumListContract;
import com.funlisten.ui.ablum.model.ZYAblum;
import com.funlisten.ui.ablum.model.ZYAblumsModel;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumListPresenter extends ZYListDataPresenter<ZYAblumListContract.IView,ZYAblumsModel,ZYAblum> implements ZYAblumListContract.IPresenter {

    public ZYAblumListPresenter(ZYAblumListContract.IView view, ZYAblumsModel model) {
        super(view, model);
    }

    @Override
    protected void loadData() {

    }
}
