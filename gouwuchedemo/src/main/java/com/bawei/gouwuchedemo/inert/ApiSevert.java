package com.bawei.gouwuchedemo.inert;

import com.bawei.gouwuchedemo.bean.Bean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 于俊建 on 2017/11/6.
 */

public interface ApiSevert {

    @GET("ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
    Call<Bean> getNoPrea();

}
