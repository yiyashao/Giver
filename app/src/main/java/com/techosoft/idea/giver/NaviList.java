package com.techosoft.idea.giver;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;

import java.util.List;


public class NaviList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AVOSCloud.initialize(this, "V8rs92rEWMh65J46K9Np6jvd-gzGzoHsz", "nom630shHF4kLUVaQm5L0f4j");

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        Button buttonSendWantedRequest= (Button) this.findViewById(R.id.buttonWanted);
        buttonSendWantedRequest.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendARequest();
                    getAvObject();
                }
        });
    }

    public void sendARequest(){
        addAvObject();
        Toast.makeText(this, "sending request", Toast.LENGTH_SHORT).show();
    }

    public void addAvObject(){
        final AVObject todo = new AVObject("Todo");
        todo.put("title", "工程师周会");
        todo.put("content", "每周工程师会议，周一下午2点");
        todo.put("number", 2);
        todo.put("location", "会议室");// 只要添加这一行代码，服务端就会自动添加这个字段
        todo.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    // 存储成功
                    Log.d("LeanCloud", todo.getObjectId());// 保存成功之后，objectId 会自动从服务端加载到本地
                } else {
                    // 失败的话，请检查网络环境以及 SDK 配置是否正确
                }
            }
        });
    }

    public void getAvObject(){
        AVQuery<AVObject> query = new AVQuery<>("Todo");
        query.whereEqualTo("number", 2);
        // 如果这样写，第二个条件将覆盖第一个条件，查询只会返回 priority = 1 的结果
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                List<AVObject> priorityEqualsZeroTodos = list;// 符合 priority = 0 的 Todo 数组
                Log.d("LeanCloud", "ok, found some records " + list.size());
                AVObject oneItem = list.get(0);
                setMessageValue(oneItem.get("content").toString());
            }
        });
    }

    public void setMessageValue(String aValue){
        Toast.makeText(this, aValue, Toast.LENGTH_SHORT).show();
    }



}
