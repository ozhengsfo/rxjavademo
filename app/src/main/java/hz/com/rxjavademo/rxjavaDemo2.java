package hz.com.rxjavademo;


import android.graphics.drawable.Drawable;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhengsf on 2018/12/13.
 */

public class rxjavaDemo2 {
    public static final String TAG = "RX_JAVA_DEMO2";
    public void rxjavaDemo2test(){
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        })
                .observeOn(AndroidSchedulers.mainThread())  //回调在主线程
                .subscribeOn(Schedulers.io()) //执行在IO线程
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG,"onNext:"+value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError="+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete()");
                    }
                });
    }

    public void pictureTest(){
      /*  Observable.create(new ObservableOnSubscribe<Drawable>() {
            @Override
            public void subscribe(ObservableEmitter<Drawable> emitter) throws Exception {
                for( int i =0; i<drawableRes.length;i++){
                    Drawable drawable = getResource().getDrawable(drawableRes[i]);
                    if(i ==5){
                        sleep(3000);
                    }
                    if(i==6){
                        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
                        saveBitmap(bitmap,"test.png", Bitmap.CompressFormat.PNG);
                    }
                    if (i==7){
                        updateIcon(drawable);
                    }
                    emitter.onNext(drawable);
                }

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Drawable>() {
                    @Override
                    public void accept(Drawable drawable) throws Exception {
                        //回调后在UI界面上展示出来
                    }
                });
*/
    }

}
