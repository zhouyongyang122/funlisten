package com.funlisten.ui.ablum.contract;

import com.funlisten.base.mvp.ZYListDataContract;
import com.funlisten.ui.ablum.model.ZYAblum;
import com.funlisten.ui.ablum.model.ZYAblumsModel;

/**
 * Created by ZY on 17/6/13.
 */

public interface ZYAblumListContract {

    interface IView extends ZYListDataContract.View<IPresenter>{

    }

    interface IPresenter extends ZYListDataContract.Presenter<ZYAblum>{

    }
}
