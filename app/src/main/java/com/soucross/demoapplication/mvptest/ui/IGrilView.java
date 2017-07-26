package com.soucross.demoapplication.mvptest.ui;

import com.soucross.demoapplication.mvptest.entity.Gril;

import java.util.List;

/**
 * Created by lenovo on 2017/7/24.
 */

public interface IGrilView {
    /**
     * 显示进度条
     */
    void showLoading();
    /**
     * 显示进度条
     */
    void hideLoading();
    /**
     * 显示数据的方法
     * @param grils
     */
    void showGrils(List<Gril> grils);
}
