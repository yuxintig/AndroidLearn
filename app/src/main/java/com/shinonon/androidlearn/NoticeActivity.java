package com.shinonon.androidlearn;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.shinonon.androidlearn.databinding.ActivityNoticeBinding;

public class NoticeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActivityNoticeBinding binding;
    public static final String ID_BASIC = "basic";
    public static final String  ID_HIGH= "high";

    public static final String[] NOTIFICATION_STYLES={
            "---请选择---","基本样式","悬浮样式","长文本样式",
            "大图样式","收件箱样式","自定义View"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNoticeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotifcationChannel(ID_BASIC,"一般消息" , NotificationManager.IMPORTANCE_DEFAULT);
            createNotifcationChannel(ID_HIGH,"订阅消息",NotificationManager.IMPORTANCE_HIGH);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                NOTIFICATION_STYLES);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spStyle.setAdapter(adapter);
        binding.spStyle.setOnItemSelectedListener(this);
    }

  

    //创建通知通道
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotifcationChannel(String channelId, String channelName,int importance){
        final NotificationChannel channel = new NotificationChannel(channelId,channelName,importance);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
    }

 

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,int position, long id){
        String style = NOTIFICATION_STYLES[position];
        binding.tvDescription.setText(style);
        if("基本样式".equals(style)){
            showBasicNotification();
        }else if ("悬浮样式".equals(style)){
            showFullNotification();
        }else if ("长文本样式".equals(style)){
            showBigTextNotification();
        }else if ("大图样式".equals(style)){
            //showBigPictureNotification();
        }else if ("收件箱样式".equals(style)){
            //showInboxNotification();
        }else if ("自定义View".equals(style)){
            //showCustomViewNotification();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void showBigTextNotification() {
        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        final Notification notification = new NotificationCompat.Builder(this,ID_HIGH)
                .setSmallIcon(R.drawable.ic_xigua)
                .setContentTitle("会议时间")
                .setContentText("研讨会于")
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.buling))
                .setFullScreenIntent(pendingIntent,true)
                .build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1000,notification);
    }

    private void showFullNotification() {
        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        final Notification notification = new NotificationCompat.Builder(this,ID_HIGH)
                .setSmallIcon(R.drawable.ic_xigua)
                .setContentTitle("会议时间")
                .setContentText("研讨会于")
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.buling))
                .setFullScreenIntent(pendingIntent,true)
                .build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1000,notification);
    }

    private void showBasicNotification() {
        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        final Notification notification = new NotificationCompat.Builder(this,ID_HIGH)
                .setSmallIcon(R.drawable.ic_xigua)
                .setContentTitle("会议时间")
                .setContentText("研讨会于")
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.buling))
                .setFullScreenIntent(pendingIntent,true)
                .build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1000,notification);
    }

    private void showHighNotification(){
        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        final Notification notification = new NotificationCompat.Builder(this,ID_HIGH)
                .setSmallIcon(R.drawable.ic_xigua)
                .setContentTitle("会议时间")
                .setContentText("研讨会于")
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.buling))
                .setFullScreenIntent(pendingIntent,true)
                .build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1000,notification);
    }

}

