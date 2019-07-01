package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.util.Xml;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    private List<message> messagess=null;
    private int index=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe3);

        ListView listView =findViewById(R.id.listview);



        //解析data.xml
        try {
            messagess =pull(getResources().getAssets().open("data.xml"));
            //listview
            ListViewBaseAdapter listViewBaseAdapter =new ListViewBaseAdapter(Exercises3.this,messagess.size());
            listView.setAdapter(listViewBaseAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(Exercises3.this,"点击了 "+position,Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        findViewById(R.id.textView11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Exercises3.this, itent_next.class);
                intent1.putExtra("data","进入粉丝界面");
                startActivity(intent1);
            }
        });
        findViewById(R.id.textView12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Exercises3.this, itent_next.class);
                intent2.putExtra("data","进入点赞界面");
                startActivity(intent2);
            }
        });
        findViewById(R.id.textView13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Exercises3.this, itent_next.class);
                intent3.putExtra("data","进入@我的界面");
                startActivity(intent3);
            }
        });
        findViewById(R.id.textView14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Exercises3.this, itent_next.class);
                intent4.putExtra("data","进入评论界面");
                startActivity(intent4);
            }
        });


    }


    public class ListViewBaseAdapter extends BaseAdapter {
        private Context mContext;
        private int count=0;
        public ListViewBaseAdapter(Context context,int count) {
            mContext = context;
            this.count=count;
        }
        @Override public int getCount() {
            return 100;
        }
        @Override public Object getItem(int i) {
            return null;
        }

        @Override public long getItemId(int i) {
            return 0;
        }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view;
            if (convertView == null) {
                view = inflater.inflate(R.layout.im_list_item,null);
            } else {
                view = (View) convertView;
            }
            TextView title=view.findViewById(R.id.tv_title);
            TextView describe=view.findViewById(R.id.tv_description);
            TextView time=view.findViewById(R.id.tv_time);
            ImageView imageView=view.findViewById(R.id.robot_notice);

            if(index<this.count) {
                title.setText(messagess.get(index).getTitle());
                describe.setText(messagess.get(index).getHashtag());
                time.setText(messagess.get(index).getTime());
                if (messagess.get(index).getIcon().equals("TYPE_ROBOT")) {
                    imageView.setVisibility(View.VISIBLE);
                } else if (messagess.get(index).getIcon().equals("TYPE_GAME")) {
                    imageView.setVisibility(View.VISIBLE);
                } else if (messagess.get(index).getIcon().equals("TYPE_SYSTEM")) {
                    imageView.setVisibility(View.VISIBLE);
                }
                index++;
            }

            return view;
        }
    }

    public class message {
        private String title;
        private String hashtag;
        private String time;
        private String icon;
        public void setTitle(String  title){
            this.title=title;
        }
        public void setHashtag(String hashtag  ){
            this.hashtag=hashtag;
        }
        public void setTime(String  time){
            this.time=time;
        }
        public void setIcon(String  icon){
            this.icon=icon;
        }

        public String getTitle(){
            return title;
        }
        public String getHashtag(){
            return hashtag;
        }
        public String getTime(){
            return time;
        }
        public String getIcon(){
            return icon;
        }
    }


    public List<message> pull(InputStream is) throws Exception{
        List<message> list=new ArrayList<>();
        message message=null;
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(is,"utf-8");
        int type = parser.getEventType();

        while(type!=XmlPullParser.END_DOCUMENT){
            switch (type){
                case XmlPullParser.START_TAG:{
                    if("message".equals(parser.getName())){
                        message=new message();
                    }else if("title".equals(parser.getName())){
                        message.setTitle(parser.nextText());
                    }else if("hashtag".equals(parser.getName())){
                        message.setHashtag(parser.nextText());
                    }else if("time".equals(parser.getName())){
                        message.setTime(parser.nextText());
                    }else if("icon".equals(parser.getName())) {
                        message.setIcon(parser.nextText());
                    }
                    break;
                }
                case XmlPullParser.END_TAG:{
                    if("message".equals(parser.getName())){
                        list.add(message);
                    }
                    break;
                }
            }
            type=parser.next();
        }


        return list;
    }
}


