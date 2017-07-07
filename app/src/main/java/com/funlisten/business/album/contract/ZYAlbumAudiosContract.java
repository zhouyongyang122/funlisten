package com.funlisten.business.album.contract;

import com.funlisten.base.mvp.ZYListDataContract;
import com.funlisten.business.album.model.bean.ZYAlbumDetail;
import com.funlisten.business.audio.ZYAudio;

import java.util.List;

/**
 * Created by ZY on 17/7/5.
 */

public interface ZYAlbumAudiosContract {

    interface IView extends ZYListDataContract.View<IPresenter> {
    }

    interface IPresenter extends ZYListDataContract.Presenter<ZYAudio> {
        void setSortType(String sortType);
    }
}
