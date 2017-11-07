package utils;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by lenovo on 2017/11/7.
 */
public class ActivityCollector {
    private static Stack<Activity> stack=new Stack<>();
    private static  ActivityCollector instatnce;
    private ActivityCollector(){

    }

    public static  ActivityCollector getActivityCollector(){
        if(instatnce==null){
            instatnce=new ActivityCollector();
        }
        return instatnce;
    }

    public void addActivity(Activity activity){
        stack.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (activity != null) {
            stack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void finishAll(){
            for (int i = 0; i <stack.size() ; i++) {
                if(null!=stack.get(i)){
                    stack.get(i).finish();
                }
            }
            stack.clear();
    }
}
