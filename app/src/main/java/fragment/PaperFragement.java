package fragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
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
public class PaperFragement extends BaseFragment{
    private TextView mtextview;
    private List<TestPaperBean.ListEntity> listEntities;
    public int mposition;
    public PaperFragement(int position) {
        super(position);
        mposition=position;
    }

    @Override
    public View initView() {
        View view= LayoutInflater.from(mActivity).inflate(R.layout.fragement_paper_view,null);
        mtextview=(TextView)view.findViewById(R.id.tv_content);
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
        listEntities=response.body().getList();
        TestPaperBean.ListEntity listEntity=listEntities.get(mposition);
        mtextview.setText(listEntity.getId()+"---"+listEntity.getTopic()+"---"+listEntity.getCondition());
    }

//    /**
//     * 解析数据
//     */
//    private void parsed(Response<TestPaperBean> response) {
//        listEntities=response.body().getList();
//        mFViewPager.setAdapter(myViewPagerAdapter);
//        myViewPagerAdapter.notifyDataSetChanged();
//
//    }
}
