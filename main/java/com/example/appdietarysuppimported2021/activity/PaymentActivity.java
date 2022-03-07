package com.example.appdietarysuppimported2021.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.appdietarysuppimported2021.R;

import java.io.Serializable;

public class PaymentActivity extends AppCompatActivity {
    Toolbar mToolbar1;
    Button mBtnPayment, mBtnCancel;
    TextView mTvPrice1;
    String mResult = "";
    EditText edtEmail, edtPhone, edtName, edtAddress, edtTransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);
        mToolbar1 = findViewById(R.id.toolBarPayment);
        mBtnCancel = findViewById(R.id.buttonCancel);
        mBtnPayment = findViewById(R.id.buttonPayment);


        edtName = findViewById(R.id.editTextName);
        edtEmail = findViewById(R.id.editTextEmail);
        edtPhone = findViewById(R.id.editTextPhone);
        edtAddress = findViewById(R.id.editTextAddress);
        edtTransfer = findViewById(R.id.editTextTransfer);

        setSupportActionBar(mToolbar1);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mBtnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();
                String address = edtAddress.getText().toString();
                String transfer = edtTransfer.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty() && !transfer.isEmpty()) {
                    Toast.makeText(PaymentActivity.this, "Thanh toán thành công", Toast.LENGTH_SHORT).show();

                    Intent intent2 = new Intent(PaymentActivity.this, ConfirmActivity.class);
                    intent2.putExtra("name", name);
                    intent2.putExtra("email", email);
                    intent2.putExtra("phone", phone);
                    intent2.putExtra("address", address);
                    intent2.putExtra("transfer", transfer);
                    startActivity(intent2);
                } else {
                    Toast.makeText(PaymentActivity.this, "Bạn phải điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }

            }

        });


        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this, "Đã hủy bỏ đơn hàng", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent3 = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(intent3);

            }
        });


    }
}

