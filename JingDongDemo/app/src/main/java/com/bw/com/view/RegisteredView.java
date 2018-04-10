package com.bw.com.view;

import com.bw.com.bean.RegisteredBean;

/**
 * Created by ruixuyao on 2018/04/09.
 */

public interface RegisteredView {
    //展示数据
    void showGoodsData(RegisteredBean data);
    //报错信息的展示
    void showError(String error);
}
