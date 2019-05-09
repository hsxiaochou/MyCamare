package com.example.a56831.myapplication;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.employee.camera_album.actionsheet.ActionSheet;
import com.example.employee.camera_album.camera.CameraActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.bt);
        tv = findViewById(R.id.tv);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionSheet.showSheet(MainActivity.this, null);
            }
        });
        iv = findViewById(R.id.iv);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == CameraActivity.REQUEST_CODE && resultCode == CameraActivity.RESULT_CODE)) {
            final String path = CameraActivity.getImagePath(data);
            tv.setText(path);
            iv.setImageBitmap(BitmapFactory.decodeFile(path));
        } else if (requestCode == ActionSheet.CHOOSE_PICTURE && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            iv.setImageURI(path);
            tv.setText(path.toString());
        } else {

        }

    }
}
