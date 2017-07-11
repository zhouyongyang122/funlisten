package com.funlisten.business.play.view.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.funlisten.R;
import com.funlisten.base.adapter.ZYBaseRecyclerAdapter;
import com.funlisten.base.viewHolder.ZYBaseViewHolder;
import com.funlisten.business.play.model.ZYAudio;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ZY on 17/7/10.
 */

public class ZYPlayAudiosVH extends ZYBaseViewHolder<ZYAudio> {

    @Bind(R.id.textPlayType)
    TextView textPlayType;

    @Bind(R.id.textPlaySort)
    TextView textPlaySort;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.textClose)
    TextView textClose;

    List<ZYAudio> audios;

    ZYAudio currentPlayAudio;

    ZYBaseRecyclerAdapter<ZYAudio> adapter;

    @Override
    public void updateView(ZYAudio data, int position) {
        if (data != null) {
            currentPlayAudio = data;
            if(adapter == null){
                adapter = new ZYBaseRecyclerAdapter<ZYAudio>() {
                    @Override
                    public ZYBaseViewHolder<ZYAudio> createViewHolder(int type) {
                        return null;
                    }
                };
            }
        }
    }

    @Override
    public int getLayoutResId() {
        return R.layout.zy_view_play_audios;
    }

    @OnClick({R.id.textPlayType, R.id.textPlaySort, R.id.textClose})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textPlayType:
                break;
            case R.id.textPlaySort:
                break;
            case R.id.textClose:
                break;
        }
    }
}
