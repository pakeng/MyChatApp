package cn.pinode.chat.mychatapp.view.widget.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.pinode.chat.mychatapp.R;
import cn.pinode.chat.mychatapp.activity.ChatMainActivity;
import cn.pinode.chat.mychatapp.view.widget.HeaderView;
import cn.pinode.chat.mychatapp.view.widget.draglayout.DragLayout;


public class Fragment_friends_list extends Fragment {
    private TextView title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 修改 header
        title = new TextView(getContext());
        title.setText("联系人");
        title.setTextColor(Color.WHITE);
        title.setTextSize(20);
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_friends_list, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ChatMainActivity)getActivity()).getHeaderView().setCenterView(title);
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
//                ((ChatMainActivity)getActivity()).getHeaderView().getLeftButton().setAlpha(1 - percent);
            }
        });


        ((ChatMainActivity)getActivity()).getHeaderView().setClickListener(new HeaderView.onClickListener() {
            @Override
            public void onLeftButtonClicked() {
                ((ChatMainActivity)getActivity()).getDragLayout().open();
            }

            @Override
            public void onRightButtonClicked() {

            }
        });

    }


}
