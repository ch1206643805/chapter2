package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class itent_next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itent_next2);
        String data = getIntent().getStringExtra("data");
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}
