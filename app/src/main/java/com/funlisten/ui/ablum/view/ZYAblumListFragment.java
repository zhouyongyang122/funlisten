package com.funlisten.ui.ablum.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funlisten.base.mvp.ZYListDateFragment;
import com.funlisten.base.viewHolder.ZYBaseViewHolder;
import com.funlisten.ui.ablum.contract.ZYAblumListContract;
import com.funlisten.ui.ablum.model.ZYAblum;
import com.funlisten.ui.ablum.view.viewHolder.ZYAblumListVH;

/**
 * Created by ZY on 17/6/13.
 */

public class ZYAblumListFragment extends ZYListDateFragment<ZYAblumListContract.IPresenter, ZYAblum> implements ZYAblumListContract.IView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        mRefreshRecyclerView.getLoadingView().setRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.subscribe();
            }
        });

        return view;
    }

    @Override
    protected void onItemClick(View view, int position) {
        ZYAblum ablum = mAdapter.getItem(position);
        if (ablum != null) {
            //跳转专辑详情
        }
    }

    @Override
    protected ZYBaseViewHolder<ZYAblum> createViewHolder() {
        return new ZYAblumListVH();
    }
}
