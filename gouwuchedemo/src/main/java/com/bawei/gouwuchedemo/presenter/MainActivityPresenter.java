package com.bawei.gouwuchedemo.presenter;

import com.bawei.gouwuchedemo.bean.Bean;
import com.bawei.gouwuchedemo.modle.MainActivityModel;
import com.bawei.gouwuchedemo.modle.MainActivityModelListener;
import com.bawei.gouwuchedemo.view.MainActivityViewListener;

/**
 * Created by 于俊建 on 2017/11/6.
 */

public class MainActivityPresenter {
    private MainActivityViewListener listener;
    private MainActivityModel mainActivityModel;
    public MainActivityPresenter(MainActivityViewListener listener) {
        this.listener = listener;
        this.mainActivityModel = new MainActivityModel();
    }
    public void getData(boolean up){

        mainActivityModel.getData(up, new MainActivityModelListener() {
            @Override
            public void callBackSuccess(Bean bean) {
                listener.callBackSuccess(bean);
            }

            @Override
            public void callBackFailure(int code) {
                listener.callBackFailure(code);
            }
        });

    }

}
