package com.funlisten.ui.main.model;

import com.funlisten.base.bean.ZYResponse;
import com.funlisten.base.mvp.ZYBaseModel;
import com.funlisten.ui.main.model.bean.ZYHome;
import com.funlisten.ui.main.model.bean.ZYVersion;

import rx.Observable;

/**
 * Created by ZY on 17/5/10.
 */

public class ZYMainModel extends ZYBaseModel {

    public Observable<ZYResponse<ZYVersion>> getVersion() {
        return mApi.getVersion();
    }

    public Observable<ZYResponse<ZYHome>> getHomeData() {
        return mApi.getHomeData();
    }
}
