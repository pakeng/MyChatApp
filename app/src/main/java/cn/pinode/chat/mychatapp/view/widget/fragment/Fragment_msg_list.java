package cn.pinode.chat.mychatapp.view.widget.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.pinode.chat.mychatapp.R;
import cn.pinode.chat.mychatapp.activity.ChatMainActivity;
import cn.pinode.chat.mychatapp.view.adapter.DividerItemDecoration;
import cn.pinode.chat.mychatapp.view.adapter.ItemRecycleAdapter;
import cn.pinode.chat.mychatapp.view.widget.HeaderView;
import cn.pinode.chat.mychatapp.view.widget.draglayout.DragLayout;


public class Fragment_msg_list extends Fragment {

    private RecyclerView recyclerView;
    private List<String> mLists = new ArrayList<>();
    private ItemRecycleAdapter adapter;
    private TextView title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        title = new TextView(getContext());
        title.setText("消息");
        title.setTextColor(Color.WHITE);
        title.setTextSize(20);
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_msg_list, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ChatMainActivity)getActivity()).getHeaderView().setCenterView(title);
        initRecycleView();
        initData();
        initListener();
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){

        }else {
            initListener();
            ((ChatMainActivity)getActivity()).getHeaderView().setCenterView(title);
        }
    }

    public void initListener(){

        ((ChatMainActivity)getActivity()).getDragLayout().setDragStateListener(new DragLayout.OnDragStatusListener() {
            @Override
            public void onClose() {

            }

            @Override
            public void onOpen() {

            }

            @Override
            public void onDraging(float percent) {
                //通过拖拽实现主界面的左上的头像的隐藏
                adapter.closeAllLayout();
                ((ChatMainActivity)getActivity()).getHeaderView().getLeftButton().setAlpha(1 - percent);
            }
        });

        adapter = new ItemRecycleAdapter(getContext(), mLists);

        ((ChatMainActivity)getActivity()).getHeaderView().setClickListener(new HeaderView.onClickListener() {
            @Override
            public void onLeftButtonClicked() {
                adapter.closeAllLayout();
                ((ChatMainActivity)getActivity()).getDragLayout().open();
            }

            @Override
            public void onRightButtonClicked() {
            }
        });


        recyclerView.setAdapter(adapter);
        /**
         * 监听recycleview的滑动事件，在滑动的时候要关闭打开的swipelayout
         */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    adapter.closeAllLayout();
                }
            }
        });
    }

    /**
     * 设置recycleview的一些参数
     */
    private void initRecycleView() {
        recyclerView = getView().findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < 10; i++) {
            mLists.add("item" + i);
        }

    }


}
