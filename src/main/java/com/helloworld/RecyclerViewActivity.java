package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // 找到对应的 RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // 设置线性布局管理器（垂直布局）
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置适配器，并设置数据
        recyclerView.setAdapter(new RVAdapter(this, new String[] {
                "我希望你来的时候，正好是秋天。",
                "那样，我就可以和你",
                "坐在溪畔，",
                "数鱼儿和枫叶落下的涟漪。",
                "那时的水很清，",
                "可以看见水底的石子，",
                "映着忽闪忽闪的星星。"
        }));
        // 添加条目间的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}