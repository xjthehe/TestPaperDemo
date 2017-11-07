package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import bean.TestPaperBean;
import fragment.BaseFragment;
import fragment.FragmentFactory;
import fragment.PaperFragement;

/**
 * Created by lenovo on 2017/11/7.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<TestPaperBean.ListEntity> mlist;
    Context mcontext;
    public MyViewPagerAdapter(FragmentManager fm, List<TestPaperBean.ListEntity> list){
        super(fm);
        mlist=list;
    }

    @Override
    public Fragment getItem(int position) {
//        BaseFragment paperFragement= FragmentFactory.creatFragment(0);
        return new PaperFragement(position);
    }

    @Override
    public int getCount() {
        return mlist==null?0:mlist.size();
    }
}
