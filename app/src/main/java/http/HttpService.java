package http;

import bean.TestPaperBean;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/11/7.
 */
public interface HttpService {
    @GET("list1.json")
    Call<TestPaperBean> queryTestPaper();

}
