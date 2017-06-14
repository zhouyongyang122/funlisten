package com.funlisten.ui.ablum.model;

import com.funlisten.base.bean.ZYListResponse;
import com.funlisten.base.bean.ZYResponse;
import com.funlisten.base.mvp.ZYBaseModel;

import java.util.List;

import rx.Observable;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumsModel extends ZYBaseModel {

    public Observable<ZYResponse<List<ZYCatalog>>> getCatalogs() {
        return mApi.getCatalogs(0);
    }

    public Observable<ZYResponse<ZYListResponse<ZYAblum>>> getAblums(int pageIndex, int pageSize, int categoryId, int publisherId) {
        return mApi.getAblums(pageIndex, pageSize, categoryId, publisherId);
    }
}
