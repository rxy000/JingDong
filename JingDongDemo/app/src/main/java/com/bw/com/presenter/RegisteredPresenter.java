package com.bw.com.presenter;

import android.util.Log;
import com.bw.com.api.ApiService;
import com.bw.com.bean.RegisteredBean;
import com.bw.com.model.RegisterLinserter;
import com.bw.com.model.RegisteredModel;
import com.bw.com.view.RegisteredView;
import java.lang.ref.WeakReference;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ruixuyao on 2018/04/09.
 */

public class RegisteredPresenter {
    //防止内存泄漏，将view的对象使用弱引用来管理
    private WeakReference<RegisteredView> reference;
    private final RegisteredModel model;

    public RegisteredPresenter(RegisteredView view){

        model = new RegisteredModel();
    }

    public void attachView(RegisteredView view) {
        reference = new WeakReference<RegisteredView>(view);
    }

    public void detachView(RegisteredView view) {
        if (reference != null) {
            reference.clear();
            reference = null;
        }
    }
    public void getNewsList(String mobile, String password, final RegisterLinserter linserter){
        Log.i("+++",mobile+"+"+password);

        //得到代理对象
        RegisteredModel model=new RegisteredModel();
        ApiService apiService = model.getNewsData();
        Observable<RegisteredBean> observable = apiService.getReg(mobile,password);
        observable.subscribeOn(Schedulers.io())//io线程做耗时操作
                .observeOn(AndroidSchedulers.mainThread())//主线程更新数据
                .subscribe(new Observer<RegisteredBean>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(RegisteredBean goodsInfo) {
                        String str = goodsInfo.getCode();
                        Log.i("xxx", str);
                        if (str.equals("0")){
                            linserter.setRegisSuccssful();
                        }else {
                            linserter.setRegisEorr();
                        }
                        reference.get().showGoodsData(goodsInfo);
                    }
                });
    }
}
