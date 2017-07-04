package com.funlisten.business.album.contract;

import com.funlisten.base.mvp.ZYListDataContract;
import com.funlisten.business.album.model.bean.ZYAlbumDetail;

/**
 * Created by ZY on 17/7/4.
 */

public interface ZYAlbumDetailContract {

    interface IView extends ZYListDataContract.View<ZYAlbumListContract.IPresenter>{

    }

    interface IPresenter extends ZYListDataContract.Presenter<ZYAlbumDetail>{

    }
}
