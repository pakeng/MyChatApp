package cn.pinode.chat.mychatapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.pinode.chat.mychatapp.R;
import cn.pinode.chat.mychatapp.view.bean.ItemBean;
import cn.pinode.chat.mychatapp.view.utils.ItemDataUtils;

/**
 * @date on 2018年11月4日13:45:32
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 添加描述
 */


public class LeftItemAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<ItemBean> mItemBeans;

    public LeftItemAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mItemBeans = ItemDataUtils.getItemBeans();
    }

    @Override
    public int getCount() {
        return mItemBeans != null ? mItemBeans.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mItemBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.main_item_left_layout,null);
            holder.item_img = (ImageView) convertView.findViewById(R.id.item_img);
            holder.item_tv = (TextView) convertView.findViewById(R.id.item_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ItemBean itemBean = mItemBeans.get(position);

        holder.item_tv.setText(itemBean.getTitle());
        holder.item_img.setImageResource(itemBean.getImg());

        return convertView;
    }

    class ViewHolder {
        ImageView item_img;
        TextView item_tv;
    }
}
