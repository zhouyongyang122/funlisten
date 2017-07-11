package com.funlisten.business.play.model;

import com.funlisten.base.bean.ZYResponse;
import com.funlisten.base.mvp.ZYBaseModel;

import rx.Observable;

/**
 * Created by ZY on 17/7/10.
 */

public class ZYModel extends ZYBaseModel {

    /**
     * 获取音频对象url
     *
     * @param id
     * @return
     */
    Observable<ZYResponse> getAudioUrl(String id) {
        return mApi.getAudioUrl(id);
    }

    /**
     * 获取音频对象
     *
     * @param id
     * @return
     */
    Observable<ZYResponse> getAudio(String id) {
        return mApi.getAudio(id);
    }

}
