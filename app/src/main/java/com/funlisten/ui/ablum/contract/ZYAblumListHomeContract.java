package com.funlisten.ui.ablum.contract;

import com.funlisten.base.mvp.ZYIBasePresenter;
import com.funlisten.base.mvp.ZYIBaseView;
import com.funlisten.ui.ablum.model.ZYCatalog;

import java.util.List;

/**
 * Created by ZY on 17/6/13.
 */

public interface ZYAblumListHomeContract {

    interface IView extends ZYIBaseView<IPresenter>{

        void refreshCatalogs(List<ZYCatalog> mCatalogs);
    }

    interface IPresenter extends ZYIBasePresenter{
        void loadData();
    }
}
