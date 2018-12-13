package hz.com.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public rxJavaDemo rxdemo;
    public rxjavaDemo2 rxdemo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxdemo = new rxJavaDemo();
        rxdemo.observerTest();
        rxdemo2 = new rxjavaDemo2();
        rxdemo2.rxjavaDemo2test();
    }

}
