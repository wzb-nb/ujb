package com.example.ujb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置没有标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        ListView lv_list = (ListView) findViewById(R.id.list);
        lv_list.setAdapter(new MyBaseApapter());


        //使用java定时器     -------方法3
        Timer timer = new Timer();
        timer.schedule(new MyTask(),2000);//定时器延时执行任务的方法

        //使用子线程延迟跳转 -------方法2
       /* new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    //页面跳转
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();*/

        //使用动画  -------------方法1
       /* RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_splash);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(1000);//设置动画播放时间为1秒
        layout.startAnimation(alphaAnimation);
        //设置动画监听
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            //动画结束
            @Override
            public void onAnimationEnd(Animation animation) {
                //页面跳转
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/
    }
    class MyTask extends TimerTask{
        @Override
        public void run() {
            //页面跳转
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    class MyBaseApapter extends BaseAdapter{

        private List<String> list;

        @Override
        public int getCount() {
            //显示条目
            return 30;
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            //通过android打气筒inflate获得空间的显示内容
            if(convertView == null){
                view = View.inflate(SplashActivity.this, R.layout.activity_item, null);
            }else{
                view = convertView;
            }

            return view;
        }
    }
}
