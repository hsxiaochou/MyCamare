package com.example.employee.camera_album.actionsheet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.employee.camera_album.R;
import com.example.employee.camera_album.camera.CameraActivity;

/**
 * Created by 56831 on 2019/5/6.
 */

public class ActionSheet {

    public static final int CHOOSE_PICTURE = 100;
    public static final int TAKE_PICTURE = 200;
    public static final int CANCEL = 300;
    public static Context mcontext;

    public ActionSheet() {
    }

    public static Dialog showSheet(final Context context, DialogInterface.OnCancelListener cancelListener) {
        mcontext = context;
        final Dialog dialog = new Dialog(context, R.style.ActionSheet);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.view_action_sheet, null);
        final int cFullFillWidth = 10000;
        layout.setMinimumWidth(cFullFillWidth);

        TextView picTextView = (TextView) layout.findViewById(R.id.picTextView);
        TextView camTextView = (TextView) layout.findViewById(R.id.camTextView);
        TextView cancelTextView = (TextView) layout.findViewById(R.id.cancelTextView);


        picTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAlbumIntent = new Intent(Intent.ACTION_PICK);
                openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                ((Activity) context).startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                dialog.dismiss();
            }
        });

        camTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CameraActivity.toCameraActivity((Activity) mcontext, CameraActivity.TYPE_IDCARD_FRONT);
                dialog.dismiss();
            }
        });
        cancelTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        final int cMakeBottom = -1000;
        lp.y = cMakeBottom;
        lp.gravity = Gravity.BOTTOM;
        dialog.onWindowAttributesChanged(lp);
        dialog.setCanceledOnTouchOutside(true);
        if (cancelListener != null)
            dialog.setOnCancelListener(cancelListener);
        dialog.setContentView(layout);
        dialog.show();
        return dialog;
    }

}
