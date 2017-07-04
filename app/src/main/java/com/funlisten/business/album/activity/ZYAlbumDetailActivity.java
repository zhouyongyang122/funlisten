package com.funlisten.business.album.activity;

import com.funlisten.base.mvp.ZYBaseFragmentActivity;
import com.funlisten.business.album.view.ZYAlbumDetailFragment;

/**
 * Created by ZY on 17/7/4.
 */

public class ZYAlbumDetailActivity extends ZYBaseFragmentActivity<ZYAlbumDetailFragment> {

    @Override
    protected ZYAlbumDetailFragment createFragment() {
        return new ZYAlbumDetailFragment();
    }
}
