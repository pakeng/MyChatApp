package cn.pinode.chat.mychatapp.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import cn.pinode.chat.mychatapp.R;
import cn.pinode.chat.mychatapp.view.widget.draglayout.SwipeLayout;

public class ItemAdapter extends BaseAdapter {


    private Context mContext;

    private List<SwipeLayout> openItems;
    private List<String> mDatas;

   // HashSet<SwipeLayout> mUnClosedLayouts = new HashSet<SwipeLayout>();

    public ItemAdapter(Context context, List<String> lists) {
        mContext = context;
        openItems = new ArrayList<>();
        mDatas = lists;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getOpenItems() {
        return openItems.size();
    }



    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        View view = convertView;
        if (convertView == null) {
            view = View.inflate(mContext, R.layout.main_msg_item_layout, null);
        }
        ViewHolder holder = ViewHolder.getHolder(view);
        holder.tvName.setText(mDatas.get(position));
        /**
         * 在这了对delete按钮实行监听
         */
        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除
                mDatas.remove(position);
                //通知刷新
                notifyDataSetChanged();
            }
        });
        SwipeLayout swipeLayout = (SwipeLayout) view;



        /**
         * 在这里实现只能拖拽出来一个item，拖拽其他的时候，要把之前已经拖拽出的给关闭
         */
        swipeLayout.setSwipeLayoutListener(new SwipeLayout.OnSwipeLayoutListener() {
            @Override
            public void onClose(SwipeLayout mSwipeLayout) {
                openItems.remove(mSwipeLayout);

            }

            @Override
            public void onOpen(SwipeLayout mSwipeLayout) {
                openItems.add(mSwipeLayout);
            }

            @Override
            public void onDraging(SwipeLayout mSwipeLayout) {

            }

            @Override
            public void onStartClose(SwipeLayout mSwipeLayout) {

            }

            @Override
            public void onStartOpen(SwipeLayout mSwipeLayout) {

               closeAllLayout();
                openItems.add(mSwipeLayout);
            }
        });
        return view;
    }



    public void closeAllLayout() {
        if(openItems.size() == 0)
            return;

        for (SwipeLayout l : openItems) {
            l.close();
        }
        openItems.clear();
    }

    static class ViewHolder {
        TextView tvCall, tvDelete;
        TextView tvName;

        public static ViewHolder getHolder(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.tvCall = (TextView) view.findViewById(R.id.tvCall);
                viewHolder.tvDelete = (TextView) view.findViewById(R.id.tvDelete);
                viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);
                tag = viewHolder;
                view.setTag(tag);

            }
            return (ViewHolder) tag;
        }
    }


}
