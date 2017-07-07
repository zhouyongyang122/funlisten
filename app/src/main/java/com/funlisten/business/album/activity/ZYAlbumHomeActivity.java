package com.funlisten.business.album.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.funlisten.R;
import com.funlisten.base.mvp.ZYBaseFragmentActivity;
import com.funlisten.business.album.presenter.ZYAlbumHomePresenter;
import com.funlisten.business.album.view.ZYAlbumHomeFragment;

/**
 * Created by ZY on 17/7/4.
 */

public class ZYAlbumHomeActivity extends ZYBaseFragmentActivity<ZYAlbumHomeFragment> {

    static final String ALBUM_ID = "album_id";

    public static Intent createIntent(Context context, int albumId) {
        Intent intent = new Intent(context, ZYAlbumHomeActivity.class);
        intent.putExtra(ALBUM_ID, albumId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ZYAlbumHomePresenter(mFragment, getIntent().getIntExtra(ALBUM_ID, 0));

        showActionRightImg(R.drawable.nav_btn_share_n, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        showActionRightImg2(R.drawable.nav_btn_quick_play_n, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected ZYAlbumHomeFragment createFragment() {
        return new ZYAlbumHomeFragment();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }
}
