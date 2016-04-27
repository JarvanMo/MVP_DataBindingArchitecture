package com.jarvanmo.mframework.ui.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author mo
 * base view holder that use data binding
 *
 */
public class BaseViewHolder<VDB extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private VDB mBinding;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public VDB getBinding() {
        return mBinding;
    }

    public void setBinding(VDB binding) {
        mBinding = binding;
    }
}
