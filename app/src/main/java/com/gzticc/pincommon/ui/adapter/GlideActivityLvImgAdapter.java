package com.gzticc.pincommon.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.MyBaseAdapter;
import com.gzticc.pincommon.utils.UIUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.gzticc.baselibrary.img.GlideImageLoader;

/**
 * @author pin
 * @Description:
 * @date 2017/12/21 8:50
 */

public class GlideActivityLvImgAdapter extends MyBaseAdapter<String> {

    public GlideActivityLvImgAdapter(List<String> data, Context context) {
        super(data, context);
    }

    @Override
    public View getMyView(int position, View convertView, ViewGroup parent) {
        GlideActivityLvImgAdapter.ViewHolder vh;
        if(convertView == null) {
            convertView = UIUtils.inflate(R.layout.glide_img_lv_item);
//            convertView = inflater.inflate(R.layout.glide_img_lv_item, null, false);
            vh = new GlideActivityLvImgAdapter.ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (GlideActivityLvImgAdapter.ViewHolder) convertView.getTag();
        }


        String imgUrl = data.get(position);
        GlideImageLoader.loadImge(vh.imageView,imgUrl);
        // 加载图片
//        Picasso.with(mContext)
//                .load(imgUrl)
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher2)
//                .into(vh.imageView);
        return convertView;
    }


    static class ViewHolder{
        @Bind(R.id.ivItem)
        ImageView imageView;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

    }
}
