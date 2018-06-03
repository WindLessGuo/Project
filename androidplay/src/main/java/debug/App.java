package debug;

import com.wind.baselibrary.base.BaseApplication;
import com.wind.baselibrary.utils.NetManager;

/**
 * @author : guo
 * @package : debug
 * @descrip :
 */
public class App extends BaseApplication {

    @Override
    protected void init() {
        NetManager.BASE_URL = "http://www.wanandroid.com/";
    }
}
