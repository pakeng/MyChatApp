package cn.pinode.chat.mychatapp.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import cn.pinode.chat.mychatapp.R;

public class HeaderView extends RelativeLayout implements View.OnClickListener {
    private ImageButton right_btn; // 右侧按钮
    private ImageButton left_btn; // 左侧按钮
    private LinearLayout center_container; // 中间的layout
    private onClickListener clickListener;

    public HeaderView(Context context) {
        this(context, null);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setCenterView(View view){
        center_container.removeAllViews();
        center_container.addView(view);
    }

    public void setLeftVisibility(int visiable){
        left_btn.setVisibility(visiable);
    }

    public void setRightVisibility(int visiable){
        right_btn.setVisibility(visiable);
    }

    public void setClickListener(onClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View view) {
        if (clickListener==null){
            return;
        }
        switch (view.getTag().toString()){
            case "left":
                clickListener.onLeftButtonClicked();
                break;
            case "right":
                clickListener.onRightButtonClicked();
                break;
                default:
                    break;
        }
    }

    public interface onClickListener{
        void onLeftButtonClicked();
        void onRightButtonClicked();
    }

    public ImageButton getRightButton() {
        return right_btn;
    }

    public void setRightButton(ImageButton right_btn) {
        this.right_btn = right_btn;
        right_btn.setTag("right");
        right_btn.setOnClickListener(this);
    }

    public ImageButton getLeftButton() {
        return left_btn;
    }

    public void setLeftButton(ImageButton left_btn) {
        this.left_btn = left_btn;
        left_btn.setTag("left");
        left_btn.setOnClickListener(this);
    }

    public LinearLayout getCenter_container() {
        return center_container;
    }

    public void setCenter_container(LinearLayout center_container) {
        this.center_container = center_container;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        right_btn = (ImageButton) findViewById(R.id.header_right_img_btn);
        right_btn.setTag("right");
        right_btn.setOnClickListener(this);
        left_btn = (ImageButton) findViewById(R.id.header_left_img_btn);
        left_btn.setTag("left");
        left_btn.setOnClickListener(this);
        center_container = (LinearLayout) findViewById(R.id.header_center_container);
    }


}
