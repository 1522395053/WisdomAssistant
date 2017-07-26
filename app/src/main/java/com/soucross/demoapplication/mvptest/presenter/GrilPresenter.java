package com.soucross.demoapplication.mvptest.presenter;

import com.soucross.demoapplication.mvptest.entity.Gril;
import com.soucross.demoapplication.mvptest.model.IGrilModel;
import com.soucross.demoapplication.mvptest.model.impl.IGrilModelImplV1;
import com.soucross.demoapplication.mvptest.ui.IGrilView;

import java.util.List;

/**
 * Created by lenovo on 2017/7/24.
 *
 * model == presenter < == > view
 * presenter 持有 model 和 View 的引用
 * 同时 view 也持有 presenter的引用
 *
 * mvc模式 是 presenter 持有 model 和 View 的引用
 * 同时 model 和  View  互相持有引用
 */

public class GrilPresenter {

    //interface   view
    IGrilView mGrilView;

    //interface   model  直接初始化一个默认的实现
    IGrilModel mGrilModel = new IGrilModelImplV1();

    //model 实现 通过set方法进行设置
    public void setmGrilModel(IGrilModel mGrilModel) {
        this.mGrilModel = mGrilModel;
    }


    /**
     * 策略模式设置 model实现类
     * @param mode
     */
    public void setmGrilModelMode(int mode) {
        switch (mode){
            case 1:
                this.mGrilModel = new IGrilModelImplV1();
                break;
            case 2:
                //this.mGrilModel = new IGrilModelImplV2();
                break;
        }

    }

    /**
     * 通过构造方法 实例化 mGrilView
     * @param mGrilView
     */
    public GrilPresenter(IGrilView mGrilView) {
        this.mGrilView = mGrilView;
    }

    /**
     * 绑定 View  和 model
     *
     * fetch 争取, 取得的意思
     */
    public void fetch(){
        if(null != mGrilModel && null != mGrilView){
            mGrilView.showLoading();
            //让 model加载数据
            mGrilModel.loadGril(new IGrilModel.OnLoadGrilListener() {
                @Override
                public void onCompleted(List<Gril> grils) {
                    if(null != mGrilView){
                        mGrilView.hideLoading();
                        mGrilView.showGrils(grils);
                    }
                }
            });
        }

    }


}
