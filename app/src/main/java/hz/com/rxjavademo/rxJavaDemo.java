package hz.com.rxjavademo;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhengsf on 2018/12/13.
 */

public class rxJavaDemo {
    public Disposable mDisposable;
    public static final String TAG = "RX_JAVA_DEMO";
    //创建被观察者
    //<String>泛型T是要操作对象的类型。重写subscribe方法，里面写具体的计划。本例子就是推送连载1 、2/3。
    //ObservableEmitter<String> 对象的Emitter 发射器的意思。ObservableEmitter 有三种发射方法
    //onError onComplete onNext
    Observable novel  = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> emitter) throws Exception {
            emitter.onNext("连载1");
            emitter.onNext("连载2");
            emitter.onNext("连载3");
            emitter.onComplete();
        }
    });

    //创建观察者（读者）
    Observer<String> reader = new Observer<String>(){

        @Override
        public void onSubscribe(Disposable d) {
            mDisposable = d;
            Log.d(TAG,"onSubscribe");
        }

        @Override
        public void onNext(String value) {
            if("2".equals(value)){
                mDisposable.dispose();
                return;
            }
            Log.e(TAG,"onNext:"+value);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG,"onError"+e.getMessage());
        }

        @Override
        public void onComplete() {
            Log.e(TAG,"onComplete");
        }
    };

    public void observerTest(){
        novel.subscribe(reader);
    }

}
