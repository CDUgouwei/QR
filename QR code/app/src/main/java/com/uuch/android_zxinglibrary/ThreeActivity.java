package com.uuch.android_zxinglibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.Random;

public class ThreeActivity extends BaseActivity {

    public EditText editText = null;
    public Button button = null;
    public Button button1 = null;
    public ImageView imageView = null;

    public Bitmap mBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);


        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {

        editText = (EditText) findViewById(R.id.edit_content);
        button = (Button) findViewById(R.id.button_content);
        button1 = (Button) findViewById(R.id.button1_content);
        imageView = (ImageView) findViewById(R.id.image_content);

        /**
         * 生成二维码图片
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(ThreeActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                //随机颜色的生成
                Random ran=new Random();
                int num1=ran.nextInt(255),num2=ran.nextInt(255),num3=ran.nextInt(255);
//                Toast.makeText(ThreeActivity.this, " "+num1+" "+num2+" "+num3, Toast.LENGTH_SHORT).show();

                editText.setText("");
                mBitmap = CodeUtil.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher),num1,num2,num3);
                imageView.setImageBitmap(mBitmap);
            }
        });

        /**
         * 生成不带logo的二维码图片
         */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(ThreeActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editText.setText("");
                mBitmap = CodeUtils.createImage(textContent, 400, 400, null);
                imageView.setImageBitmap(mBitmap);
            }
        });
    }

}
