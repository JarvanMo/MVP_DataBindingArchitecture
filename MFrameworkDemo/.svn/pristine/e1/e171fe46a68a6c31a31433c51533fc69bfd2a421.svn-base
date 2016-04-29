package com.jarvanmo.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.jarvanmo.myapplication.R;
import com.jarvanmo.myapplication.app.DemoBaseActivity;
import com.jarvanmo.myapplication.app.component.AppComponent;
import com.jarvanmo.myapplication.app.component.DaggerTestAdapterComponent;
import com.jarvanmo.myapplication.app.module.TestAdapterActivityModule;
import com.jarvanmo.myapplication.databinding.ActivityAdapterTestBinding;
import com.jarvanmo.myapplication.ui.adapter.TestAdapter;
import com.jarvanmo.myapplication.ui.presenter.TestAdapterPresenter;
import com.jarvanmo.myapplication.ui.view.testadapter.ITestAdapterView;
import com.jarvanmo.myapplication.ui.viewmodel.AdapterViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by mo on 16-4-29.
 *
 * @author mo
 */
public class TestAdapterActivity extends DemoBaseActivity implements ITestAdapterView {

    @Inject
    TestAdapter mTestAdapter;
    @Inject
    TestAdapterPresenter mPresenter;

    ActivityAdapterTestBinding binding;

    @Inject
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_adapter_test);
        binding.testRv.setLayoutManager(new LinearLayoutManager(this));
        binding.testRv.setAdapter(mTestAdapter);
        mPresenter.attachView(this);
        mPresenter.loadData();
        mTestAdapter.setView(this);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
//        DaggerActivityComponent.builder().appComponent(appComponent).activityModule(new ActivityModule(this)).build().inject(this);

        DaggerTestAdapterComponent.builder().appComponent(appComponent).testAdapterActivityModule(new TestAdapterActivityModule(this)).build().inject(this);
    }

    @Override
    public void startLoadData() {
        mProgressDialog.setMessage("loading...");
        mProgressDialog.show();
    }

    @Override
    public void onLoadComplete(ArrayList<AdapterViewModel> list) {
        mProgressDialog.dismiss();
        mTestAdapter.addAll(list);
    }

    @Override
    public void loadMore() {
        mPresenter.loadMore();
    }

}
