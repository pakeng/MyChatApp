package cn.pinode.chat.mychatapp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.pinode.chat.mychatapp.R;
import cn.pinode.chat.mychatapp.engine.worker.MessageWorker;
import cn.pinode.chat.mychatapp.engine.worker.WorkerDispatcher;

/**
 * @date on 2018年10月31日15:23:48
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 启动界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int SUCCESS = 10001;
    private static final String SUCCESS_STR = "发送成功:";
    Button send = null;
    EditText send_edit = null;
    TextView msg_show = null;
    private static final int ERROR = 1000;
    private static final String ERROR_STR = "发送失败";
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){


        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case ERROR:
                    msg_show.setText(ERROR_STR);
                    break;
                case SUCCESS:
                    msg_show.setText(SUCCESS_STR);
                    msg_show.append("\n");
                    msg_show.append(send_edit.getText().toString());
                    send_edit.setText("");
                    default:
                        break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        send = findViewById(R.id.msg_send);
        send_edit = findViewById(R.id.msg_edit);
        msg_show = findViewById(R.id.msg_show_tv);

        send.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msg_send:
                final String msg = send_edit.getText().toString();
                MessageWorker messageWorker = new MessageWorker(msg);
                WorkerDispatcher.getInstance().pushTask(messageWorker);
                break;
            default:
                break;
        }
    }
}
