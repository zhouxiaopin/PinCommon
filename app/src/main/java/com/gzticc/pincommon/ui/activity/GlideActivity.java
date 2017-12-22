package com.gzticc.pincommon.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.BaseActivity;
import com.gzticc.pincommon.ui.adapter.GlideActivityLvImgAdapter;
import com.gzticc.pincommon.utils.UIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import cn.gzticc.baselibrary.img.GlideImageLoader;

/**
 * @author pin
 * @Description:
 * @date 2017/12/20 15:47
 */

public class GlideActivity extends BaseActivity {
    @Bind(R.id.iv1)
    ImageView iv1;
    @Bind(R.id.iv2)
    ImageView iv2;
    @Bind(R.id.iv3)
    ImageView iv3;
    @Bind(R.id.iv4)
    ImageView iv4;
    @Bind(R.id.iv5)
    ImageView iv5;
    @Bind(R.id.lvImg)
    ListView lvImg;
    private GlideActivityLvImgAdapter glideActivityLvImgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_glide);
        UIUtils.showToast("glide",0);

        GlideImageLoader.setSrc(iv1,R.mipmap.ic_launcher2);
        GlideImageLoader.setSrc(iv2,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513767585792&di=7a7fed32641d7e4f71f933a68d672ee4&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D790202d463d0f703e6b295d438fb5148%2F45a1b3b7d0a20cf4c2bcaa1c77094b36adaf99ec.jpg");

        GlideImageLoader.setCircleSrc(iv3,"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3161881356,3164044227&fm=27&gp=0.jpg");
        GlideImageLoader.setCircleAngleSrc(iv4,"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3161881356,3164044227&fm=27&gp=0.jpg");
        GlideImageLoader.loadImge(iv5,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513768745976&di=e7bfd2312686506f4cfc7d6f8e0a653c&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1132993714%2C1948326907%26fm%3D214%26gp%3D0.jpg");
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            if(i%2 == 0 ) {
                data.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3161881356,3164044227&fm=27&gp=0.jpg");
            }else{
                data.add("http://p2.so.qhimgs1.com/sdr/200_200_/t01eb9a0acd3bbdc6f2.jpg");
            }

        }

        glideActivityLvImgAdapter = new GlideActivityLvImgAdapter(Arrays.asList(Constants.IMAGES),this);
//        glideActivityLvImgAdapter = new GlideActivityLvImgAdapter(data,this);
        lvImg.setAdapter(glideActivityLvImgAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        BannerImgLoader.clearImageAllCache(this);
    }
}
