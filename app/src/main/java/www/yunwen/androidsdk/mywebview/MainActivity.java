package www.yunwen.androidsdk.mywebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mWebView.setMaxHeight(300);
        List<String> urlData = new ArrayList<>();
        urlData.add("http://v.baidu.com/");
        urlData.add("http://v.baidu.com/gameindex/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        urlData.add("http://music.baidu.com/");
        recycleview recycleview = new recycleview(this, urlData);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.show_all_webview);
        mRecyclerView.setAdapter(recycleview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
