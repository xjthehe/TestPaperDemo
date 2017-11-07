package fragment;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/11/7.
 */
public class FragmentFactory {
    private static Map<Integer,BaseFragment> map=new HashMap<>();

    public static BaseFragment creatFragment(int position){
        BaseFragment fragment=map.get(position);
        if(fragment==null){
            switch (position){
                case 0:
                BaseFragment pagerFragement=new PaperFragement(position);
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
        return fragment;
    }
}
