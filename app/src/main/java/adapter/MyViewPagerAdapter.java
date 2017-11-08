package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import bean.TestPaperBean;
import fragment.PaperFragement;

/**
 * Created by lenovo on 2017/11/7.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<TestPaperBean.ListEntity> mlist;
    private ViewPager mviewPager;
    Context mcontext;
    public MyViewPagerAdapter(FragmentManager fm, List<TestPaperBean.ListEntity> list, ViewPager viewPager){
        super(fm);
        mlist=list;
        mviewPager=viewPager;
    }


    @Override
    public Fragment getItem(int position) {
        return new PaperFragement(position,mviewPager);
    }

    @Override
    public int getCount(){
        return mlist==null?0:mlist.size();
    }
}
