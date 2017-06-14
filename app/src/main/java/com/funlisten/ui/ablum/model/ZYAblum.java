package com.funlisten.ui.ablum.model;

import com.funlisten.base.bean.ZYIBaseBean;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblum implements ZYIBaseBean {

    public int id;

    public String name;

    public String title;

    public String coverUrl;//封面url

    public String backgroundUrl;//背景url

    public int audioCount;//音频数量

    public int categoryId;//类目id

    public int commentCount;//评论次数

    public String costType;//收费类型  收费类型 free:免费,paid:付费

    public int downloadCount;//下载次数

    public int favoriteCount;//订阅次数

    public String gmtCreate;//创建时间

    public String gmtModified;//修改时间

    public int originPrice;//原价

    public int sellPrice;//价格

    public int payCount;//购买次数

    public int playCount;//播放次数

    public int publisherId;//发布人id

    public String saleType;//售卖类型 售卖类型 album:专辑,audio:单集
}
