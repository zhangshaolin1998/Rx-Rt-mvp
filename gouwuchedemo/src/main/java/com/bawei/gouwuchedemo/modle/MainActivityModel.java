package com.bawei.gouwuchedemo.modle;

import android.app.Activity;

import com.bawei.gouwuchedemo.LoggingInterceptor;
import com.bawei.gouwuchedemo.api.Api;
import com.bawei.gouwuchedemo.bean.Bean;
import com.bawei.gouwuchedemo.inert.ApiSevert;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityModel extends Activity {
   // String u = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0";

    public void getData(boolean up, final MainActivityModelListener listener){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.benUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        ApiSevert apiSevert = retrofit.create(ApiSevert.class);
        Call<Bean> call = apiSevert.getNoPrea();
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean bean = response.body();
                //List<Bean.SongListBean> song_list = bean.getSong_list();
                listener.callBackSuccess(bean);

            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {

            }
        });


    }

}