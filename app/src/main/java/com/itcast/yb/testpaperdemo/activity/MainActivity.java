package com.itcast.yb.testpaperdemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.itcast.yb.testpaperdemo.R;

import org.w3c.dom.Text;

import java.util.List;

import adapter.MyViewPagerAdapter;
import bean.TestPaperBean;
import http.HttpUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private FragmentManager mFm;
    private ViewPager mFViewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private List<TestPaperBean.ListEntity> listEntities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        //初始导入
        initBasic();
    }

    /**
     * 视图初始化绑定
     */
    private void initBasic() {
        mFm=getSupportFragmentManager();
        mFViewPager=(ViewPager) findViewById(R.id.viewpager);
        myViewPagerAdapter =new MyViewPagerAdapter(mFm,listEntities);
        mFViewPager.setAdapter(myViewPagerAdapter);
        myViewPagerAdapter.notifyDataSetChanged();
    }

    /**
     * 获取请求数据
     */
    private void initData() {
        HttpUtils.creat().queryTestPaper().enqueue(new Callback<TestPaperBean>() {
            @Override
            public void onResponse(Call<TestPaperBean> call, Response<TestPaperBean> response) {
                parsed(response);
            }

            @Override
            public void onFailure(Call<TestPaperBean> call, Throwable t) {

            }
        });
    }

    /**
     * 解析数据
     */
    private void parsed(Response<TestPaperBean> response) {
        listEntities=response.body().getList();
    }
}
