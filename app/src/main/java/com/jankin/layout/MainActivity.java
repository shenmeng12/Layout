package com.jankin.layout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button button1;
    private Button button2;
    private EditText userName;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btn_sigIn);
        button2 = findViewById(R.id.btn_singUp);
        userName = findViewById(R.id.edt_username);
        passWord = findViewById(R.id.edt_passwd);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: 按钮一点击");
                String string = String.valueOf(userName.getText());
                String string1 = String.valueOf(passWord.getText());
                Toast.makeText(MainActivity.this, string +"     "+string1, Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_singUp:
                new AlertDialog.Builder(this)
                        .setTitle("消息提示")
                        .setIcon(R.drawable.warning)
                        .setMessage("你点击了注册按钮")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //TODO:当用户点击OK按钮时，需要做的事情
                                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(intent);
                            }
                        })
                        .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //
                            }
                        })
                        .create().show();
                break;
        }
    }
}
