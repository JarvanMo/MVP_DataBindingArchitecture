package com.jarvanmo.myapplication.ui.adapter;

import android.content.Context;
import android.view.View;

import com.jarvanmo.mframework.ui.adapter.RecyclerViewAdapter;
import com.jarvanmo.mframework.ui.viewholder.BaseViewHolder;
import com.jarvanmo.myapplication.R;
import com.jarvanmo.myapplication.app.ActivityContext;
import com.jarvanmo.myapplication.databinding.ItemTestAdapterBinding;
import com.jarvanmo.myapplication.ui.view.testadapter.ITestAdapterView;
import com.jarvanmo.myapplication.ui.viewmodel.AdapterViewModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by mo on 16-4-29.
 *
 * @author mo
 */
public class TestAdapter extends RecyclerViewAdapter<ItemTestAdapterBinding, AdapterViewModel, TestViewHolder> {

    private ITestAdapterView mView;

    @Inject
    public TestAdapter(@ActivityContext Context context) {
        super(context);
    }


    public void setView(ITestAdapterView view) {
        mView = view;
    }


    @Override
    public void onControlView(AdapterViewModel item, ItemTestAdapterBinding binding, int position) {
        binding.setImageInfo(item);
        Context context = getContext();
        Picasso.with(context).load(item.getImageUrl()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).fit().into(binding.imageIv);

        binding.imageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.loadMore();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_test_adapter;
    }


}

class TestViewHolder extends BaseViewHolder<ItemTestAdapterBinding> {

    public TestViewHolder(View itemView) {
        super(itemView);
    }
}
