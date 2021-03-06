package com.funlisten.base.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funlisten.base.viewHolder.ZYBaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZY on 17/3/16.
 */

public abstract class ZYBaseRecyclerAdapter<D> extends RecyclerView.Adapter {

    private static final int DEFAULT_DELAY = 100;

    private static final int TYPE_HEADER = 10;
    private static final int TYPE_FOOTER = 11;
    public static final int TYPE_NORMAL = 12;

    private List<D> mDatas;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    private List<ZYBaseViewHolder> mHeader = new ArrayList<>();
    private List<ZYBaseViewHolder> mFooter = new ArrayList<>();

    private int mClickDelay = DEFAULT_DELAY;

    public ZYBaseRecyclerAdapter() {

    }

    public ZYBaseRecyclerAdapter(List<D> datas) {
        mDatas = datas;
    }

    public void setClickDelay(int clickDelay) {
        mClickDelay = clickDelay;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mHeader.size()) {
            return TYPE_HEADER;
        } else if (position < mDatas.size() + mHeader.size()) {
            return TYPE_NORMAL;
        } else {
            return TYPE_FOOTER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ZYBaseViewHolder baseViewHolder;
        switch (viewType) {
            case TYPE_HEADER:
                baseViewHolder = mHeader.get(0);
                return new ViewHolder(parent, baseViewHolder,
                        baseViewHolder.getDataBindingRoot(parent.getContext(), parent));
            case TYPE_NORMAL:
                baseViewHolder = createViewHolder(viewType);
                return new ViewHolder(parent, baseViewHolder,
                        baseViewHolder.getDataBindingRoot(parent.getContext(), parent));
            case TYPE_FOOTER:
                baseViewHolder = mFooter.get(0);
                return new ViewHolder(parent, baseViewHolder,
                        baseViewHolder.getDataBindingRoot(parent.getContext(), parent));
            default:
                baseViewHolder = createViewHolder(viewType);
                return new ViewHolder(parent, baseViewHolder,
                        baseViewHolder.getDataBindingRoot(parent.getContext(), parent));
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (position < mHeader.size()) {
            ((ViewHolder) holder).baseViewHolder.updateView(null, position);
        } else if (position < mDatas.size() + mHeader.size()) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        holder.itemView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int realPosition = holder.getAdapterPosition();
                                if (realPosition >= 0) {
                                    mOnItemClickListener.onItemClick(holder.itemView, realPosition - mHeader.size());
                                }
                            }
                        }, mClickDelay);
                    }
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mOnItemLongClickListener != null) {
                        int realPosition = holder.getAdapterPosition();
                        if (realPosition >= 0) {
                            mOnItemLongClickListener.onItemLongClick(holder.itemView, realPosition - mHeader.size());
                        }
                    }
                    return false;
                }
            });
            ((ViewHolder) holder).baseViewHolder.updateView(mDatas.get(position - mHeader.size()),
                    position - mHeader.size());
        } else {
            ((ViewHolder) holder).baseViewHolder.updateView(null, position - mHeader.size() - mDatas.size());
        }
    }

    @Override
    public int getItemCount() {
        if (mDatas == null) {
            return 0;
        }

        return mDatas.size() + mHeader.size() + mFooter.size();
    }

    public abstract ZYBaseViewHolder<D> createViewHolder(int type);

    public void setDatas(List<D> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    public int getHeaderSize() {
        return mHeader.size();
    }

    public int getFooterSize() {
        return mFooter.size();
    }

    public void addHeader(ZYBaseViewHolder baseViewHolder) {
        mHeader.add(baseViewHolder);
    }

    public void addFooter(ZYBaseViewHolder baseViewHolder) {
        mFooter.add(baseViewHolder);
    }

    public void removeHeader(ZYBaseViewHolder baseViewHolder) {
        mHeader.remove(baseViewHolder);
    }

    public void removeFooter(ZYBaseViewHolder baseViewHolder) {
        mFooter.remove(baseViewHolder);
    }

    public D getItem(int position) {
        if (position >= 0 && position < mDatas.size()) {
            return mDatas.get(position);
        } else {
            throw new IndexOutOfBoundsException("data size = " + mDatas.size() + " position = " + position);
        }
    }

    public GridLayoutManager.SpanSizeLookup createSpanSizeLookup(final int spanCount) {
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position < mHeader.size()) {
                    return spanCount;
                } else if (position < mDatas.size() + mHeader.size()) {
                    return 1;
                } else {
                    return spanCount;
                }
            }
        };
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        public ZYBaseViewHolder baseViewHolder;

        public ViewHolder(ViewGroup parent, ZYBaseViewHolder baseViewHolder, View root) {
            super(root != null ? root : LayoutInflater.from(parent.getContext()).inflate(baseViewHolder.getLayoutResId(), parent, false));
            this.baseViewHolder = baseViewHolder;
            this.baseViewHolder.bindView(itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(View view, int position);
    }
}
