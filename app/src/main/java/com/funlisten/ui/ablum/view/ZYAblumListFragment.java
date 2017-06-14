package com.funlisten.ui.ablum.view;

import android.view.View;

import com.funlisten.base.mvp.ZYListDateFragment;
import com.funlisten.base.viewHolder.ZYBaseViewHolder;
import com.funlisten.ui.ablum.contract.ZYAblumListContract;
import com.funlisten.ui.ablum.model.ZYAblum;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumListFragment extends ZYListDateFragment<ZYAblumListContract.IPresenter, ZYAblum> implements ZYAblumListContract.IView {

    @Override
    protected void onItemClick(View view, int position) {

    }

    @Override
    protected ZYBaseViewHolder<ZYAblum> createViewHolder() {
        return null;
    }
}
