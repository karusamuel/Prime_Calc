package com.example.primecalc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.primecalc.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Integer> list;

    public MyAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View gridView;

//        if(convertView==null){
            gridView = layoutInflater.inflate(R.layout.grid_view_strip,null);

            TextView number = gridView.findViewById(R.id.number);
            number.setText(list.get(position).toString());

//        }else {
//            gridView = convertView;
//        }


        return gridView;
    }
}
