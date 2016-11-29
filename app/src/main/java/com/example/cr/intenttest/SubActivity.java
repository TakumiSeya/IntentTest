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

    private TextView label;
    private TestView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);



        Intent intent = getIntent();
        String selectedText = intent.getStringExtra("Text");
        int selectedPhoto = intent.getIntExtra("Photo", 0);
        String selectedText2 = intent.getStringExtra("Memo");
        int selectedPhoto2 = intent.getIntExtra("Milk", 0);
        String selectedComment = intent.getStringExtra("PoopComment");
        String selectedSmell = intent.getStringExtra("PoopSmell");
        String selectedAmount = intent.getStringExtra("PoopAmount");
        String selectedStatus = intent.getStringExtra("PoopStatus");

        TextView textView = (TextView)findViewById(R.id.selected_text);
        textView.setText(selectedText);
        ImageView  imageView = (ImageView) findViewById(R.id.selected_photo);
        imageView.setImageResource(selectedPhoto);

        TextView textView2 = (TextView)findViewById(R.id.selected_text2);
        textView2.setText(selectedText2);
        ImageView imageView2 = (ImageView)findViewById(R.id.selected_photo2);
        imageView2.setImageResource(selectedPhoto2);

        TextView textView3 = (TextView)findViewById(R.id.selected_comment);
        textView3.setText(selectedComment);

        TextView textView4 = (TextView)findViewById(R.id.selected_smell);
        textView4.setText(selectedSmell);

        TextView textView5 = (TextView)findViewById(R.id.selected_amount);
        textView5.setText(selectedAmount);

        TextView textView6 = (TextView)findViewById(R.id.selected_status);
        textView6.setText(selectedStatus);

        /*
        label = (TextView) this.findViewById(R.id.label);
        label.setText("abcd123456789cdefg\n" + "1234567893456978\n" +
                "hijklmnopq012698745rst4565848uvwxlmnopq\n" +
                "\n\n\n012698745rst4565848\nuvwx" );

        c = (TestView) this.findViewById(R.id.test_view);
        */
    }

}
