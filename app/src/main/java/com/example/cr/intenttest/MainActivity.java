package com.example.cr.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

// 後で使います
//public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    private BaseAdapter adapter;

    // Isle of Wight in U.K.
    private static final String[] scenes = {
            // Scenes of Isle of Wight
            "11/16 17:27",
            "11/16 18:03",
            "11/16 20:11",
            "11/16 21:36",
            "11/17 04:41",
            "11/17 06:31",
            "11/17 10:15",
            "11/17 12:29"
    };

    // ちょっと冗長的ですが分かり易くするために
    private static final int[] photos = {
            R.drawable.ic_01,
            R.drawable.ic_02,
            R.drawable.ic_03,
            R.drawable.ic_04,
            R.drawable.ic_05,
            R.drawable.ic_06,
            R.drawable.ic_07,
            R.drawable.ic_08
    };

    private static final String[] texts = {
            // Scenes of Isle of Wight
            "Ventnor",
            "Wroxall",
            "Whitewell",
            "Ryde",
            "StLawrence",
            "Lake",
            "Sandown",
            "Shanklin"
    };

    private static final int milks = R.drawable.ic_bottle_horizonal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewのインスタンスを生成
        ListView listView = (ListView) findViewById(R.id.list_view);

        

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に inflate するためにadapterに引数として渡す
        adapter = new ListViewAdapter(this.getApplicationContext(), R.layout.list, scenes, photos, texts, milks);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // 後で使います
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent intent = new Intent(this.getApplicationContext(), SubActivity.class);
        // clickされたpositionのtextとphotoのID
        String selectedText = scenes[position];
        int selectedPhoto = photos[position];
        String selectedMemo = texts[position];
        int selectedPhoto2 = milks;
        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Photo", selectedPhoto);
        intent.putExtra("Memo", selectedMemo);
        intent.putExtra("Milk", selectedPhoto2);
        // Activity をスイッチする
        startActivity(intent);
    }

}