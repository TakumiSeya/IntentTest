package com.example.cr.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

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

    private static final int[] poopLabels = {
            3, 4, 9, 2, 4, 5, 3, 8
    };

    private static final String[] poopComments = {
            "2~3日以内に最寄りの小児科(もしくは産科)を受診しましょう。",
            "6~7日観察を続け、判別結果が「4」のまま、あるいは1~3へと変化したら最寄りの小児科(もしくは産科)を受診しましょう。",
            "ウンチに赤みがかかっています。2~3日以内に最寄りの小児科(もしくは産科)を受診しましょう。",
            "ウンチの黒みが非常に強いです。2~3日以内に最寄りの小児科(もしくは産科)を受診しましょう。",
            "健康なウンチであると思われます。"
    };

    private static final int[] poopSmell = {
            3, 3, 3, 3, 1, 1, 3, 3
    };


    private static final int[] poopAmount = {
            2, 2, 2, 2, 1, 0, 3, 2
    };

    private static final int[] poopStatus = {
            2, 2, 1, 1, 1, 1, 2, 2
    };

    private static final String[][] poopCheckComments = {
            {"腐敗臭", "酸っぱい", "大人臭", "無臭"},
            {"多い", "少し多い", "いつも通り", "少し少ない", "少ない"},
            {"水っぽい", "少し水っぽい", "いつも通り", "少し固形っぽい", "固形っぽい"}
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

    /*
        example colors
        red     (255, 0, 0)
        lime    (0, 255, 0)
        blue    (0, 0, 255)
        aqua    (0, 255, 255)
        fuchsia (255, 0, 255)
        yellow  (255, 255, 0)
        gray    (128, 128, 128)
        black   (0, 0, 0)

        http://www.netyasun.com/home/color.html
     */
    private static final int[] colorR = {
            255, 0, 0, 0, 255, 255, 128, 0
    };

    private static final int[] colorG = {
            0, 255, 0, 255, 0, 255, 128, 0
    };

    private static final int[] colorB = {
            0, 0, 255, 255, 255, 0, 128, 0
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

        String poopComment = "";
        poopComment = poopCheckComment(poopLabels[position]);

        String selectedSmell = "";
        selectedSmell = poopCheckAboutSmell(poopSmell[position]);

        String selectedAmount = "";
        selectedAmount = poopCheckAboutAmount(poopAmount[position]);

        String selectedStatus = "";
        selectedStatus = poopCheckAboutStatus(poopStatus[position]);

        int selectedColorR = colorR[position];
        int selectedColorG = colorG[position];
        int selectedColorB = colorB[position];

        String hexR = Integer.toHexString( selectedColorR );
        String hexG = Integer.toHexString( selectedColorG );
        String hexB = Integer.toHexString( selectedColorB );

        String selectedColorCode = "#" + hexR + hexG + hexB;

        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Photo", selectedPhoto);
        intent.putExtra("Memo", selectedMemo);
        intent.putExtra("Milk", selectedPhoto2);
        intent.putExtra("PoopComment", poopComment);
        intent.putExtra("PoopSmell", selectedSmell);
        intent.putExtra("PoopAmount", selectedAmount);
        intent.putExtra("PoopStatus", selectedStatus);
        intent.putExtra("Color", selectedColorCode);
        //intent.putExtra("ColorG", selectedColorG);
        //intent.putExtra("ColorB", selectedColorB);
        // Activity をスイッチする
        startActivity(intent);
    }

    public static String poopCheckComment(int poopLabel) {
        String returnComment = poopComments[4];

        if((1 <= poopLabel) && (poopLabel < 4)) {
            returnComment = poopComments[0];
        }
        else if(poopLabel == 4) {
            returnComment = poopComments[1];
        }
        else if(poopLabel == 8) {
            returnComment = poopComments[2];
        }
        else if(poopLabel == 9) {
            returnComment = poopComments[3];
        }

        return returnComment;
    }

    public static String poopCheckAboutSmell(int poopSmell) {
        String returnComment = poopCheckComments[0][poopSmell];

        return returnComment;
    }

    public static String poopCheckAboutAmount(int poopAmount) {
        String returnComment = poopCheckComments[1][poopAmount];

        return returnComment;
    }

    public static String poopCheckAboutStatus(int poopStatus) {
        String returnComment = poopCheckComments[2][poopStatus];

        return returnComment;
    }

}