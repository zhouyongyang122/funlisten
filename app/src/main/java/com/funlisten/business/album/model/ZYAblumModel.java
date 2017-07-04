package com.funlisten.business.album.model;

import com.funlisten.base.bean.ZYListResponse;
import com.funlisten.base.bean.ZYResponse;
import com.funlisten.base.mvp.ZYBaseModel;
import com.funlisten.business.album.model.bean.ZYAlbumDetail;
import com.funlisten.business.album.model.bean.ZYCatalog;

import java.util.List;

import rx.Observable;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumModel extends ZYBaseModel {

    public Observable<ZYResponse<List<ZYCatalog>>> getCatalogs() {
        return mApi.getCatalogs(0);
    }

    public Observable<ZYResponse<ZYListResponse<ZYAlbumDetail>>> getAblums(int pageIndex, int pageSize, int categoryId, int publisherId) {
        return mApi.getAblums(pageIndex, pageSize, categoryId, publisherId);
    }

    public Observable<ZYResponse<ZYListResponse<ZYAlbumDetail>>> getAblums(int pageIndex, int pageSize, int categoryId) {
        return mApi.getAblums(pageIndex, pageSize, categoryId);
    }
}
