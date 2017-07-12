package com.funlisten.business.album.contract;

import com.funlisten.base.mvp.ZYIBasePresenter;
import com.funlisten.base.mvp.ZYIBaseView;
import com.funlisten.base.mvp.ZYListDataContract;
import com.funlisten.business.album.model.bean.ZYAlbumDetail;

/**
 * Created by ZY on 17/7/4.
 */

public interface ZYAlbumHomeContract {

    interface IView extends ZYIBaseView<IPresenter> {
        void showDetail(ZYAlbumDetail albumDetail);
    }

    interface IPresenter extends ZYIBasePresenter {

        int getAlbumId();

        ZYAlbumDetail getAlbumDetail();

        void load();
    }
}
