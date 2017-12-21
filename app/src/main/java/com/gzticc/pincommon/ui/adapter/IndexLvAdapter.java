package com.gzticc.pincommon.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.MyBaseAdapter;
import com.gzticc.pincommon.utils.UIUtils;

import java.util.List;

/**
 * @author pin
 * @Description:
 * @date 2017/12/20 11:44
 */

public class IndexLvAdapter extends MyBaseAdapter<String> {

    public IndexLvAdapter(List<String> data,Context context) {
        super(data,context);
    }

    @Override
    public View getMyView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView == null) {
            convertView = UIUtils.inflate(R.layout.index_lv_item);
            vh = new ViewHolder();
            vh.menuName = (TextView) convertView.findViewById(R.id.tvMenuName);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        String menuName = data.get(position);
        vh.menuName.setText(menuName);

        return convertView;
    }


    static class ViewHolder{
        TextView menuName;

    }
}
