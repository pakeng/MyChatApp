package cn.pinode.chat.mychatapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import cn.pinode.chat.mychatapp.R;
import cn.pinode.chat.mychatapp.view.adapter.LeftItemAdapter;
import cn.pinode.chat.mychatapp.view.widget.BottomBar;
import cn.pinode.chat.mychatapp.view.widget.draglayout.DragLayout;
import cn.pinode.chat.mychatapp.view.widget.HeaderView;
import cn.pinode.chat.mychatapp.view.widget.fragment.Fragment2;
import cn.pinode.chat.mychatapp.view.widget.fragment.Fragment3;
import cn.pinode.chat.mychatapp.view.widget.fragment.Fragment_msg_list;

public class ChatMainActivity extends AppCompatActivity {

    private DragLayout dragLayout;
    private ListView lv;
    private HeaderView headerView;
    private View head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scene);

        initViews();

        initListener();
    }

    /**
     * 初始化布局控件
     */
    private void initViews() {
        dragLayout = (DragLayout) findViewById(R.id.dl);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new LeftItemAdapter(this));
        headerView = (HeaderView) findViewById(R.id.header_view);
        TextView title = new TextView(this);
        title.setText("Title");
        headerView.setCenterView(title);
        head = headerView.getLeftButton();

        BottomBar bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.frame_container)
                .setTitleBeforeAndAfterColor("#999999", "#0CB8F6")
                .addItem(Fragment_msg_list.class,
                        getResources().getString(R.string.msg_list),
                        R.drawable.item1_before,
                        R.drawable.item1_after)
                .addItem(Fragment2.class,
                        getResources().getString(R.string.friends_list),
                        R.drawable.item2_before,
                        R.drawable.item2_after)
                .addItem(Fragment3.class,
                        getResources().getString(R.string.topic_list),
                        R.drawable.item3_before,
                        R.drawable.item3_after)
                .addItem(Fragment3.class,
                        getResources().getString(R.string.friends_news),
                        R.drawable.item3_before,
                        R.drawable.item3_after)
                .build();
    }

    /**
     * 初始化listener
     */
    private void initListener() {

        /**
         * DragLayout的事件监听
         */
        dragLayout.setDragStateListener(new DragLayout.OnDragStatusListener() {
            @Override
            public void onClose() {

            }

            @Override
            public void onOpen() {

            }

            @Override
            public void onDraging(float percent) {
//                //通过拖拽实现主界面的左上的头像的隐藏
//                head.setAlpha(1 - percent);
            }
        });
    }


    public HeaderView getHeaderView(){
        return headerView;
    }

    public DragLayout getDragLayout() {
        return dragLayout;
    }
}
