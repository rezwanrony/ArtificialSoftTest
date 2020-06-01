package com.friendroid.artificialsofttest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.friendroid.artificialsofttest.R;
import com.friendroid.artificialsofttest.Utills.Utility;
import com.squareup.picasso.Picasso;

public class ReportDetailsActivity extends AppCompatActivity {

    ImageView img_reportdetails;
    TextView tv_reportdetails,tv_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_details);
        img_reportdetails=findViewById(R.id.img_reportdetails);
        tv_reportdetails=findViewById(R.id.tv_reportdetails);
        tv_price=findViewById(R.id.tv_pricedetails);
        Picasso.get().load(Utility.BaseImageUrl+getIntent().getStringExtra("image")).into(img_reportdetails);
        tv_reportdetails.setText(getIntent().getStringExtra("title"));
        tv_price.setText(getIntent().getStringExtra("price")+"৳");
    }
}
