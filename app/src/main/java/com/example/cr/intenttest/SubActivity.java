package com.example.cr.intenttest;

/**
 * Created by b1014246 on 2016/11/09.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String selectedText = intent.getStringExtra("Text");
        int selectedPhoto = intent.getIntExtra("Photo", 0);
        String selectedText2 = intent.getStringExtra("Memo");
        int selectedPhoto2 = intent.getIntExtra("Milk", 0);

        TextView textView = (TextView)findViewById(R.id.selected_text);
        textView.setText(selectedText);
        ImageView  imageView = (ImageView) findViewById(R.id.selected_photo);
        imageView.setImageResource(selectedPhoto);

        TextView textView1 = (TextView)findViewById(R.id.selected_text2);
        textView1.setText(selectedText2);
        ImageView imageView2 = (ImageView)findViewById(R.id.selected_photo2);
        imageView2.setImageResource(selectedPhoto2);

        //setContentView(new DrawTest(this));

    }



}
