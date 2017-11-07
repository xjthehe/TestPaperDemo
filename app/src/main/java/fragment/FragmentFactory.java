package fragment;
import android.support.v4.view.ViewPager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/11/7.
 */
public class FragmentFactory {
    private static Map<Integer,BaseFragment> map=new HashMap<>();
    public static BaseFragment creatFragment(int position, ViewPager viewPager){
        BaseFragment fragment=map.get(position);
        if(fragment==null){
            switch (position){
                case 0:
                    fragment=new PaperFragement(position,viewPager);
                    break;
                case 1:
                    fragment=new PaperFragement(position,viewPager);
                    break;
                case 2:
                    fragment=new PaperFragement(position,viewPager);
                    break;
                case 3:
                    fragment=new PaperFragement(position,viewPager);
                    break;
                case 4:
                    fragment=new PaperFragement(position,viewPager);
                    break;
            }
        }
        return fragment;
    }
}
