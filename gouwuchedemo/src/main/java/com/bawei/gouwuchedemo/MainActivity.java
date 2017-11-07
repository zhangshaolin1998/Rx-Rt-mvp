package com.bawei.gouwuchedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.gouwuchedemo.adapter.MyAdapter;
import com.bawei.gouwuchedemo.bean.Bean;
import com.bawei.gouwuchedemo.presenter.MainActivityPresenter;
import com.bawei.gouwuchedemo.view.MainActivityViewListener;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityViewListener {


    private RecyclerView thirdRecyclerview;
    private MainActivityPresenter presenter;
    private MyAdapter adapter;
    private List<Bean.SongListBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
        thirdRecyclerview= (RecyclerView) findViewById(R.id.third_recyclerview);
        thirdRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MyAdapter(MainActivity.this,list);
        presenter = new MainActivityPresenter(this);
        thirdRecyclerview.setAdapter(adapter);

//        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent in=new Intent(MainActivity.this,Main2Activity.class);
//                startActivity(in);
//            }
//        });
        presenter.getData(true);

    }


    @Override
    public void callBackSuccess(Bean bean) {
            adapter.setData(bean);
    }

    @Override
    public void callBackFailure(int code) {

    }
}
