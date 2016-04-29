package com.jarvanmo.myapplication.domain.biz.getimage;

import android.os.Handler;
import android.os.Looper;

import com.jarvanmo.myapplication.ui.viewmodel.AdapterViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by mo on 16-4-29.
 *
 * @author mo
 */
public class GetImageBizIml implements IGetImageBiz {

    @Inject
    public GetImageBizIml() {

    }


    @Override
    public void getImage(String userName, final OnGetImageListener listener) {
        listener.onLoadStart();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                final ArrayList<AdapterViewModel> arrayList = new ArrayList<>();
                AdapterViewModel adapterViewModel;
                for (int i = 0; i < 10; i++) {

                    adapterViewModel = new AdapterViewModel();
                    adapterViewModel.setTime(System.currentTimeMillis() + "");
                    if(i % 2 == 0){
                        adapterViewModel.setImageUrl("http://h.hiphotos.baidu.com/zhidao/pic/item/eac4b74543a9822628850ccc8c82b9014b90eb91.jpg");
                    }else{
                        adapterViewModel.setImageUrl("http://h.hiphotos.baidu.com/image/h%3D200/sign=71cd4229be014a909e3e41bd99763971/472309f7905298221dd4c458d0ca7bcb0b46d442.jpg");
                    }

                    arrayList.add(adapterViewModel);
                }

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        listener.onLoadComplete(arrayList);
                    }
                });


            }
        }).start();
    }
}
