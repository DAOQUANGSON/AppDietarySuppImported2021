package com.example.appdietarysuppimported2021.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdietarysuppimported2021.R;
import com.example.appdietarysuppimported2021.adapter.CartAdapter;
import com.example.appdietarysuppimported2021.interfaces.OnItemClickCartAdapter;
import com.example.appdietarysuppimported2021.model.Cart;
import com.example.appdietarysuppimported2021.model.ElementCart;
import com.example.appdietarysuppimported2021.shared.AppCache;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
public class CartActivity extends AppCompatActivity {
    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    TextView mTvTitleTotal,mTvPrice;
    Button mBtnOrder;

    CartAdapter mCartAdapter;
    List<ElementCart> mListCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        mToolbar = findViewById(R.id.toolBarCart);
        mRecyclerView = findViewById(R.id.recyclerViewCart);
        mTvPrice = findViewById(R.id.textPrice);
        mTvTitleTotal = findViewById(R.id.textTitleTotal);
        mBtnOrder = findViewById(R.id.order);
        checkVisiblePayment();
        updatePrice();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });





        mListCart = Cart.getInstance().getCarts();
        mCartAdapter = new CartAdapter(mListCart);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mCartAdapter);
        mCartAdapter.setOnItemClickCartAdapter(new OnItemClickCartAdapter() {
            @Override
            public void increment(int position) {
                ElementCart elementCart = Cart.getInstance().getCarts().get(position);
                elementCart.setQuantity(elementCart.getQuantity() + 1);
                mCartAdapter.notifyItemChanged(position);
                checkVisiblePayment();
                updatePrice();
                AppCache.createFile(Cart.getInstance().createJson(Cart.getInstance().getCarts()).toString(),CartActivity.this);
            }

            @Override
            public void decrement(int position) {
                ElementCart elementCart = Cart.getInstance().getCarts().get(position);
                elementCart.setQuantity(elementCart.getQuantity() - 1);
                mCartAdapter.notifyItemChanged(position);
                checkVisiblePayment();
                updatePrice();
                AppCache.createFile(Cart.getInstance().createJson(Cart.getInstance().getCarts()).toString(),CartActivity.this);
            }

            @Override
            public void delete(int position) {
                Cart.getInstance().getCarts().remove(position);
                mCartAdapter.notifyItemRemoved(position);
                checkVisiblePayment();
                updatePrice();
                AppCache.createFile(Cart.getInstance().createJson(Cart.getInstance().getCarts()).toString(),CartActivity.this);
            }
        });

        mBtnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(CartActivity.this, PaymentActivity.class);
//                intent1.putExtra("Price", mTvPrice);
                startActivity(intent1);

            }
        });
    }
    private void checkVisiblePayment(){
        if (Cart.getInstance().getCarts() == null || Cart.getInstance().getCarts().size() == 0){
            mTvTitleTotal.setVisibility(View.GONE);
            mTvPrice.setVisibility(View.GONE);
            mBtnOrder.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.GONE);
        }else{
            mTvTitleTotal.setVisibility(View.VISIBLE);
            mTvPrice.setVisibility(View.VISIBLE);
            mBtnOrder.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }
    private void updatePrice(){
        NumberFormat formatter = new DecimalFormat("#,###");
        mTvPrice.setText(formatter.format(Cart.getInstance().totalCart()) + " VNĐ");
    }

}