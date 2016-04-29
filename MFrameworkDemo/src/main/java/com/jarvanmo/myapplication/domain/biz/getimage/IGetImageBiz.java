package com.jarvanmo.myapplication.domain.biz.getimage;

import com.jarvanmo.myapplication.ui.viewmodel.AdapterViewModel;

import java.util.ArrayList;

/**
 * Created by mo on 16-4-29.
 *
 * @author mo
 */
public interface IGetImageBiz {
    void getImage(String userName , OnGetImageListener listener);
}

