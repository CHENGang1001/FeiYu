package com.feiyu.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.feiyu.R;
import com.feiyu.fragment.HomeFragment;
import com.feiyu.fragment.MeFragment;
import com.feiyu.fragment.MsgFragment;
import com.feiyu.fragment.RoadFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.arrow)
    ImageView arrow;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_right_title)
    ImageView ivRightTitle;
    @BindView(R.id.tv_right_title)
    TextView tvRightTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.iv_road)
    ImageView ivRoad;
    @BindView(R.id.tv_road)
    TextView tvRoad;
    @BindView(R.id.iv_publish)
    ImageView ivPublish;
    @BindView(R.id.tv_publish)
    TextView tvPublish;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.ll_road)
    LinearLayout llRoad;
    @BindView(R.id.ll_publish)
    LinearLayout llPublish;
    @BindView(R.id.ll_msg)
    LinearLayout llMsg;
    @BindView(R.id.ll_me)
    LinearLayout llMe;

    private HomeFragment homeFragment;
    private RoadFragment roadFragment;
    private MsgFragment msgFragment;
    private MeFragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.arrow, R.id.title, R.id.iv_right_title, R.id.tv_right_title, R.id.rl_title,
            R.id.fl_content, R.id.ll_home, R.id.ll_road, R.id.ll_publish, R.id.ll_msg, R.id.ll_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.arrow:
                break;
            case R.id.title:
                break;
            case R.id.iv_right_title:
                break;
            case R.id.tv_right_title:
                break;
            case R.id.rl_title:
                break;
            case R.id.fl_content:
                break;
            case R.id.ll_home:
                break;
            case R.id.ll_road:
                break;
            case R.id.ll_publish:
                break;
            case R.id.ll_msg:
                break;
            case R.id.ll_me:
                break;
        }
    }

    private void selectFragment(int i){
        switch ()
    }


    private void hideFragment(){
        if (homeFragment==null){
            homeFragment = new HomeFragment();
        }
        if (roadFragment==null){
            roadFragment = new RoadFragment();
        }
        if (msgFragment==null){
            msgFragment = new MsgFragment();
        }
        if (meFragment==null){
            meFragment = new MeFragment();
        }

    }

    private void resetImg() {
        ivHome.setBackgroundResource(R.mipmap.ic_launcher);
        ivRoad.setBackgroundResource(R.mipmap.ic_launcher);
        ivPublish.setBackgroundResource(R.mipmap.ic_launcher);
        ivMsg.setBackgroundResource(R.mipmap.ic_launcher);
        ivMe.setBackgroundResource(R.mipmap.ic_launcher);

        tvHome.setTextColor(getResources().getColor(R.color.gray));
        tvRoad.setTextColor(getResources().getColor(R.color.gray));
        tvPublish.setTextColor(getResources().getColor(R.color.gray));
        tvMsg.setTextColor(getResources().getColor(R.color.gray));
        tvMe.setTextColor(getResources().getColor(R.color.gray));
    }

}
