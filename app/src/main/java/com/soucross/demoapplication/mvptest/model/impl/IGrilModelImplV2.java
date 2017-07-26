package com.soucross.demoapplication.mvptest.model.impl;

import com.soucross.demoapplication.mvptest.entity.Gril;
import com.soucross.demoapplication.mvptest.model.IGrilModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/24.
 */

public class IGrilModelImplV2 implements IGrilModel {
    @Override
    public void loadGril(OnLoadGrilListener onLoadGrilListener) {

        List<Gril> grils = new ArrayList<>();

        grils.add(new Gril("小红"));
        grils.add(new Gril("小花"));


        //加载完成，传递加载的数据
        onLoadGrilListener.onCompleted(grils);



    }
}
