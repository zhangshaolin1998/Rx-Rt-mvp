package com.bawei.gouwuchedemo.view;

import com.bawei.gouwuchedemo.bean.Bean;

/**
 * Created by 于俊建 on 2017/11/6.
 */

public interface MainActivityViewListener {
    public void callBackSuccess(Bean bean);
    public void callBackFailure(int code);
}
