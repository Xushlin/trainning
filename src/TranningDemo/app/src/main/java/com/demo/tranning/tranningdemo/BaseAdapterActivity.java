package com.demo.tranning.tranningdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class BaseAdapterActivity extends AppCompatActivity {
    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        myList = (ListView) findViewById(R.id.myList);
        BaseAdapter adapter = new BaseAdapter()
        {
            @Override
            public int getCount()
            {
                // 指定一共包含40个选项
                return 40;
            }
            @Override
            public Object getItem(int position)
            {
                return null;
            }
            // 重写该方法，该方法的返回值将作为列表项的ID
            @Override
            public long getItemId(int position)
            {
                return position;
            }
            // 重写该方法，该方法返回的View将作为列表框
            @Override
            public View getView(int position
                    , View convertView , ViewGroup parent)
            {
                // 创建一个LinearLayout，并向其中添加两个组件
                LinearLayout line = new LinearLayout(BaseAdapterActivity.this);
                line.setOrientation(0);
                ImageView image = new ImageView(BaseAdapterActivity.this);
                image.setImageResource(R.mipmap.ic_launcher);
                TextView text = new TextView(BaseAdapterActivity.this);
                text.setText("第" + (position +1 ) + "个列表项");
                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                // 返回LinearLayout实例
                return line;
            }
        };
        myList.setAdapter(adapter);
    }
}
