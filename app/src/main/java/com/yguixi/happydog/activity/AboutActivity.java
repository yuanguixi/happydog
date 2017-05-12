package com.yguixi.happydog.activity;
/*
 *  描述：    关于
 */

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yguixi.happydog.R;
import com.yguixi.happydog.entity.Constants;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private CircleImageView profile_image;
    private ListView mListView;
    private List<String> mList = new ArrayList<>();
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView() {

        mList.add("作者:喜狗");
        mList.add("yguixi.com");
        mList.add("非商用");
        mList.add("QQ:57854190");

        profile_image = (CircleImageView) findViewById(R.id.profile_image);
        profile_image.setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.mListView);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_image:

                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                //不需要
                break;
            case 1:
                Constants.startWebView(this, "yguixi.com", Constants.GITHUB);
                break;
            case 2:
                Constants.startWebView(this, "CSDN Blog", Constants.BLOG);
                break;
            case 3:
                Constants.joinQQGroup(this, "WKsVihQjloOtstvRIXUWxU2M4QRKUwO0");
                break;
        }
    }
}
