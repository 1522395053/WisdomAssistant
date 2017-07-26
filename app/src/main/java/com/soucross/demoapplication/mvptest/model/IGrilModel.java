package com.soucross.demoapplication.mvptest.model;

/**
 * Created by lenovo on 2017/7/24.
 */

import com.soucross.demoapplication.mvptest.entity.Gril;

import java.util.List;

/**
 * 单一职责： 一个类只干一件事情
 */

public interface IGrilModel {

    /**
     * 用来加载数据的
     *
     * 加载数据需时传递一个监听器，可以监测加载数据的状态
     * onLoadGrilListener
     *
     */
    void loadGril(OnLoadGrilListener onLoadGrilListener);

    interface OnLoadGrilListener{
        /**
         * 加载完成的方法
         *
         * 加载完成后 传递加载的数据
         */
        void onCompleted(List<Gril> grils);



    }
}
