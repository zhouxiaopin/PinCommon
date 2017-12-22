package com.gzticc.pincommon.ui.fragment;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.BaseFragment;
import com.gzticc.pincommon.utils.LogUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.BannerImgLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 订购
 */
public class OrderFragment extends BaseFragment {
    @Bind(R.id.banner1)
    Banner banner1;
    @Bind(R.id.banner2)
    Banner banner2;
    @Bind(R.id.banner3)
    Banner banner3;
    @Bind(R.id.banner4)
    Banner banner4;
    @Bind(R.id.banner5)
    Banner banner5;
    @Bind(R.id.banner6)
    Banner banner6;
    @Bind(R.id.banner7)
    Banner banner7;

    public OrderFragment() {
        LogUtils.d("new OrderFragment");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            if(i%2 == 0 ) {
                data.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3161881356,3164044227&fm=27&gp=0.jpg");
            }else{
                data.add("http://p2.so.qhimgs1.com/sdr/200_200_/t01eb9a0acd3bbdc6f2.jpg");
            }

        }
        List<String> titleData = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            titleData.add("标题-"+i);
        }
        banner1.setImages(data)
                .setImageLoader(new BannerImgLoader())
                .start();
        banner2.setImages(data)
                .setImageLoader(new BannerImgLoader())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();
        banner3.setImages(data)
                .setImageLoader(new BannerImgLoader())
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .start();
        banner4.setImages(data)
                .setImageLoader(new BannerImgLoader())
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .start();
        banner5.setImages(data)
                .setImageLoader(new BannerImgLoader())
                .setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
                .setBannerTitles(titleData)
                .start();
        banner6.setImages(data)
                .setImageLoader(new BannerImgLoader())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setBannerTitles(titleData)
                .start();
        banner7.setImages(data)
                .setImageLoader(new BannerImgLoader())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setBannerTitles(titleData)
                .start();
    }

}
