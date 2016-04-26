package com.jarvanmo.mframework.ui.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mo on 16-4-26.
 *
 */
public class BaseViewHolder<VDB extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private VDB mBinding ;
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public VDB getBinding(){
        return mBinding;
    }
    public void setBinding(VDB binding){
        mBinding = binding;
    }
}
