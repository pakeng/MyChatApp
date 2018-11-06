package cn.pinode.chat.mychatapp.view.widget.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import cn.pinode.chat.mychatapp.R;
import cn.pinode.chat.mychatapp.activity.ChatMainActivity;


public class Fragment_topic extends Fragment {

    private WebView webView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((ChatMainActivity)getActivity()).getHeaderView().setVisibility(View.GONE);
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_topic, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            ((ChatMainActivity)getActivity()).getHeaderView().setVisibility(View.VISIBLE);
        }else {
            ((ChatMainActivity)getActivity()).getHeaderView().setVisibility(View.GONE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        webView = getView().findViewById(R.id.topic_webview);
        webView.loadUrl("http://pinode.cn");
    }

}
