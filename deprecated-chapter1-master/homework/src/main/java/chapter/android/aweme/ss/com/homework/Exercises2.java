package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    private static TextView textView;
    private static final String TAG = "Exercises2";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        RelativeLayout layout=findViewById(R.id.header);
        textView = new TextView(this);
        textView.setText("view number "+0);
        textView.bringToFront();
        textView.setTextSize(30);
        layout.addView(textView);


    }

    public static int getViewCount (View view) {
        //todo 补全你的代码
        int count=0;
        LinkedList<ViewGroup> queue = new LinkedList<ViewGroup>();
        if(view instanceof ViewGroup){
            ViewGroup viewGroup =(ViewGroup) view;
            queue.add(viewGroup);
            while (!queue.isEmpty()){
                ViewGroup  top = queue.pop();
                for(int i=0;i<top.getChildCount();i++){
                    if(top.getChildAt(i) instanceof ViewGroup){
                        queue.add((ViewGroup) top.getChildAt(i));
                    }
                    else{
                        count++;
                    }
                }
            }
        }

        Log.d(TAG, "getViewCount: "+count);
        textView.setText("view number "+count);
        textView.bringToFront();
        textView.setTextSize(30);

        return 0;
    }

}
