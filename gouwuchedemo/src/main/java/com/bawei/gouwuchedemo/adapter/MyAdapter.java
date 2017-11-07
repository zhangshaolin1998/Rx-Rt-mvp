package com.bawei.gouwuchedemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.gouwuchedemo.R;
import com.bawei.gouwuchedemo.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 于俊建 on 2017/11/6.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context context;
    private List<Bean.SongListBean> list;

    public MyAdapter(Context context,List<Bean.SongListBean> list) {
        this.context = context;
       this.list = list;
    }



    public void setData(Bean bean) {

        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(bean.getSong_list());
        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        IViewHolder holder = new IViewHolder(view);



        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        IViewHolder viewHolder = new IViewHolder(holder.itemView);
        ViewGroup.LayoutParams params = viewHolder.img.getLayoutParams();//得到item的LayoutParams布局参数
        viewHolder.img.setLayoutParams(params);//把params设置给itemView布局
        viewHolder.tv1.setText(list.get(position).getTitle());
        viewHolder.tv2.setText(list.get(position).getAuthor());
        //ImageLoader.getInstance().displayImage(list.get(position).getPic_big(),viewHolder.img,MyApp.getDisp());
        Uri uri = Uri.parse(list.get(position).getPic_big());
        viewHolder.img.setImageURI(uri);
        viewHolder.itemView.setTag(position);





    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class IViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;


        @BindView(R.id.img)
        SimpleDraweeView img;

//        private final ImageView img;
//        private final TextView tv1;
//        private final TextView tv2;

        public IViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            img = itemView.findViewById(R.id.img);
//            tv1 = itemView.findViewById(R.id.tv1);
//            tv2 = itemView.findViewById(R.id.tv2);

        }
    }


}
