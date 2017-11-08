package fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itcast.yb.testpaperdemo.R;

import java.util.List;

import bean.TestPaperBean;
import http.HttpUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by lenovo on 2017/11/7.
 */
@SuppressLint("ValidFragment")
public class PaperFragement extends BaseFragment implements View.OnClickListener {
    private TextView tv_content_id;
    private  ViewPager mviewPager;
    private List<TestPaperBean.ListEntity> listEntities;
    public int mposition;
    Button btn_rever;
    Button btn_next;
    private TextView tv_topic;
    private LinearLayout ll_a;
    private LinearLayout ll_b;
    private LinearLayout ll_c;
    private LinearLayout ll_d;


    public PaperFragement(int position,ViewPager viewPager) {
        super(position);
        mposition = position;
        mviewPager=viewPager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        CallBackValue callBackValue= (CallBackValue) getActivity();
    }

    @Override
    public View initView(){
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragement_paper_view, null);
        tv_content_id = (TextView) view.findViewById(R.id.tv_content_id);
        tv_topic = (TextView) view.findViewById(R.id.tv_topic);
        ll_a=(LinearLayout)view.findViewById(R.id.ll_a);
        ll_b=(LinearLayout)view.findViewById(R.id.ll_b);
        ll_c=(LinearLayout)view.findViewById(R.id.ll_c);
        ll_d=(LinearLayout)view.findViewById(R.id.ll_d);

        btn_rever = (Button) view.findViewById(R.id.btn_rever);
        btn_next = (Button) view.findViewById(R.id.btn_next);
        btn_rever.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        return view;
    }

    @Override
    public void initData() {
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

    private void parsed(Response<TestPaperBean> response) {
        listEntities = response.body().getList();
        TestPaperBean.ListEntity listEntity = listEntities.get(mposition);
        tv_content_id.setText(listEntity.getId()+"");
        tv_topic.setText(listEntity.getTopic());

        //选项数据。
//        ((TextView)ll_a.findViewById(R.id.tv_a)).setText();
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_rever:
                int current=mviewPager.getCurrentItem();
                    current--;
                    mviewPager.setCurrentItem(current);
                    break;
                case R.id.btn_next:
                    current=mviewPager.getCurrentItem();
                    current++;
                    mviewPager.setCurrentItem(current);
                    break;
            }
    }


//    //定义一个回调接口
//    public interface CallBackValue{
//        public void SendMessageValue(ViewPager viewPager);
//    }
}
