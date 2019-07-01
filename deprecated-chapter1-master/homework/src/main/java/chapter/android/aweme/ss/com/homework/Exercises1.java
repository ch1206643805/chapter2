package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 */
public class Exercises1 extends AppCompatActivity {
    private static final String TAG = "Exercises1";
        
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestory: ");
    }
    
}
