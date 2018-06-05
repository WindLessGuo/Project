package debug;

import com.wind.baselibrary.base.BaseApplication;
import com.wind.baselibrary.utils.NetManager;

/**
 * @author : guo
 * @package : debug
 * @descrip :
 */
public class App extends BaseApplication {
/*    static {//static 代码段可以防止内存泄露
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.play_light_blue, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
    }*/
    @Override
    protected void init() {
        NetManager.BASE_URL = "http://www.wanandroid.com/";

    }
}
