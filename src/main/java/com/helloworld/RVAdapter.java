package com.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 这是 RecyclerView 的适配器，用于绑定数据和控件
 * 尖括号中的内容是 ViewHolder，在后面有定义
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private Context context;
    private String[] data;

    public RVAdapter(Context context, String[] data) {
        // 构造函数需要传入 Context（在 Activity 中传入 this 即可）和数据
        this.context = context;
        this.data = data;
    }

    /*
    该方法负责创建 ViewHolder。
    在该方法中需要完成的任务：
    1. 创建布局
    2. 根据刚才创建的布局创建 ViewHolder
    3. 返回 ViewHolder 对象
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建布局
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        // 创建并返回 ViewHolder
        return new ViewHolder(view);
    }

    /*
    该方法负责更新 ViewHolder 中的数据
    holder 为需要更新的 ViewHolder
    position 为第几个条目
    一般情况下，我们需要将第 position 个数据绑定
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 设置文本框文字，内容为第 position 个数据
        holder.textView.setText(data[position]);
    }

    /*
    该方法用于告知系统一共有多少个条目
     */
    @Override
    public int getItemCount() {
        return data.length;
    }

    /**
     * 这是管理列表中条目布局的类
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // 在构造函数中找到需要动态更新的控件
            textView = itemView.findViewById(R.id.text);
        }
    }
}
