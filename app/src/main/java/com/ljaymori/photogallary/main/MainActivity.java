package com.ljaymori.photogallary.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.all.AllFragment;
import com.ljaymori.photogallary.main.picture.PictureFragment;
import com.ljaymori.photogallary.main.video.VideoFragment;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public static final int PAGE_POSITION_ALL = 0;
    public static final int PAGE_POSITION_PICTURE = 1;
    public static final int PAGE_POSITION_VIDEO = 2;



    private View actionbarView;
    private TextView tvTabAll;
    private TextView tvTabPicture;
    private TextView tvTabVideo;

    private AllFragment allFragment;
    private PictureFragment pictureFragment;

    private ViewPager viewPager;
    private MainPagerAdapter pagerAdapter;
    private VideoFragment videoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init Action Bar
        initActionBar();

        // init Fragments
        initFragments();

        // init Pager
        initPager();
    }

    private void initActionBar() {
        actionbarView = LayoutInflater.from(this).inflate(R.layout.actionbar_main, null);

        tvTabAll = (TextView) actionbarView.findViewById(R.id.text_all_actionbar);
        tvTabPicture = (TextView) actionbarView.findViewById(R.id.text_picture_actionbar);
        tvTabVideo = (TextView) actionbarView.findViewById(R.id.text_video_actionbar);

        tvTabAll.setOnClickListener(this);
        tvTabPicture.setOnClickListener(this);
        tvTabVideo.setOnClickListener(this);

        TextView tv = (TextView)actionbarView.findViewById(R.id.text_test);
        tv.setOnClickListener(this);

        getSupportActionBar().setCustomView(actionbarView);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
    }

    private void initFragments() {
        allFragment = new AllFragment();

        pictureFragment = new PictureFragment();

        videoFragment = new VideoFragment();

    }

    private void initPager() {
        viewPager = (ViewPager) findViewById(R.id.pager_main);

        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        pagerAdapter.setInitPages(initPages());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case PAGE_POSITION_ALL: {
                        tvTabAll.setTextColor(getResources().getColor(R.color.actionbar_letter_focus));
                        tvTabPicture.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        tvTabVideo.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        break;
                    }
                    case PAGE_POSITION_PICTURE: {
                        tvTabAll.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        tvTabPicture.setTextColor(getResources().getColor(R.color.actionbar_letter_focus));
                        tvTabVideo.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        break;
                    }
                    case PAGE_POSITION_VIDEO: {
                        tvTabAll.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        tvTabPicture.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        tvTabVideo.setTextColor(getResources().getColor(R.color.actionbar_letter_focus));
                        break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private ArrayList<TabParentFragment> initPages() {
        ArrayList<TabParentFragment> list = new ArrayList<TabParentFragment>();

        list.add(allFragment);
        list.add(pictureFragment);
        list.add(videoFragment);

        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_all_actionbar: {
                viewPager.setCurrentItem(PAGE_POSITION_ALL, true);
                break;
            }
            case R.id.text_picture_actionbar: {
                viewPager.setCurrentItem(PAGE_POSITION_PICTURE, true);
                break;
            }
            case R.id.text_video_actionbar: {
                viewPager.setCurrentItem(PAGE_POSITION_VIDEO, true);
                break;
            }
            case R.id.text_test : {
                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                test();
                break;
            }
        }
    }

    private void test() {

    }

}