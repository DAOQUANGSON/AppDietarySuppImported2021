package com.example.appdietarysuppimported2021.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdietarysuppimported2021.R;

import java.text.BreakIterator;
import java.text.StringCharacterIterator;


public class ConfirmActivity extends AppCompatActivity {
    Button mBtnFinish;
    TextView mTextNameInfo, mTextEmailInfo, mTextPhoneInfo, mTextAddressInfo, mTextTransferInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        mBtnFinish = findViewById(R.id.buttonFinish);
        mTextNameInfo = findViewById(R.id.TextNameInfo);
        mTextEmailInfo = findViewById(R.id.TextEmailInfo);
        mTextPhoneInfo = findViewById(R.id.TextPhoneInfo);
        mTextAddressInfo = findViewById(R.id.TextAddressInfo);
        mTextTransferInfo = findViewById(R.id.TextTransferInfo);

        Intent intent2 = getIntent();
        String editTextName = intent2.getStringExtra("name");
        String editTextEmail = intent2.getStringExtra("email");
        String editTextPhone = intent2.getStringExtra("phone");
        String editTextAddress = intent2.getStringExtra("address");
        String editTextTransfer = intent2.getStringExtra("transfer");

        Log.d("BBB",editTextName);
        Log.d("BBB",editTextEmail);
        Log.d("BBB",editTextPhone);
        Log.d("BBB",editTextAddress);
        Log.d("BBB",editTextTransfer);

        mTextNameInfo.setText(editTextName);
        mTextEmailInfo.setText(editTextEmail);
        mTextPhoneInfo.setText(editTextPhone);
        mTextAddressInfo.setText(editTextAddress);
        mTextTransferInfo.setText(editTextTransfer);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfirmActivity.this, "Hoàn thành đơn hàng", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(ConfirmActivity.this, MainActivity.class);
                startActivity(intent4);
                finish();
            }

        });

    }
}
