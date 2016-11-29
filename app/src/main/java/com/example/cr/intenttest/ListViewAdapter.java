package com.example.cr.intenttest;

/**
 * Created by b1014246 on 2016/11/09.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
        TextView textView2;
        ImageView imageView2;

    }

    private LayoutInflater inflater;
    private int itemLayoutId;
    private String[] titles;
    private int[] ids;
    private String[] memos;
    private int milks;
    private int labels;

    public ListViewAdapter(Context context, int itemLayoutId, String[] scenes, int[] photos, String[] texts, int milks) {
        super();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemLayoutId = itemLayoutId;
        this.titles = scenes;
        this.ids = photos;
        this.memos = texts;
        this.milks = milks;
        this.labels = labels;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // 最初だけ View を inflate して、それを再利用する
        if (convertView == null) {
            // activity_main.xml に list.xml を inflate して convertView とする
            convertView = inflater.inflate(itemLayoutId, parent, false);
            // ViewHolder を生成
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.imageView2 = (ImageView) convertView.findViewById(R.id.imageView2);
            convertView.setTag(holder);
        }
        // holder を使って再利用
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        // holder の imageView にセット
        holder.imageView.setImageResource(ids[position]);
        // 現在の position にあるファイル名リストを holder の textView にセット
        holder.textView.setText(titles[position]);

        holder.textView2.setText(memos[position]);

        holder.imageView2.setImageResource(milks);

        return convertView;
    }

    @Override
    public int getCount() {
        // texts 配列の要素数
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}