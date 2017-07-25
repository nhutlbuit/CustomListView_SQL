package com.example.nhutl.sqlexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhutl.sqlexample.R;
import com.example.nhutl.sqlexample.activity.MainActivity;
import com.example.nhutl.sqlexample.dto.Column;

import java.util.List;

/**
 * Created by nhutl on 7/23/2017.
 */

public class ViewColumnAdapter extends BaseAdapter {
    private MainActivity context;

    public ViewColumnAdapter(MainActivity context, int layout, List<Column> columns) {
        this.context = context;
        this.layout = layout;
        this.columns = columns;
    }

    private int layout;
    private List<Column> columns;

    @Override
    public int getCount() {
        return columns.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView txtcot1,txtcot2, txtcot3, txtcot4;
        ImageView imgcot5, imgcot6;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            viewHolder.txtcot1 = (TextView) view.findViewById(R.id.txt_cot1);
            viewHolder.txtcot2 = (TextView) view.findViewById(R.id.txt_cot2);
            viewHolder.txtcot3 = (TextView) view.findViewById(R.id.txt_cot3);
            viewHolder.txtcot4 = (TextView) view.findViewById(R.id.txt_cot4);
            viewHolder.imgcot5 = (ImageView) view.findViewById(R.id.imgcot5);
            viewHolder.imgcot6 = (ImageView) view.findViewById(R.id.imgcot6);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        final Column column = columns.get(position);
        viewHolder.txtcot1.setText(columns.get(position).getCot1());
        viewHolder.txtcot2.setText(columns.get(position).getCot2());
        viewHolder.txtcot3.setText(columns.get(position).getCot3());
        viewHolder.txtcot4.setText(columns.get(position).getCot4());

        viewHolder.imgcot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.dialogUpdate(column);
                Toast.makeText(context, "edit", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imgcot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.deleteSanPham(column);
            }
        });


        return view;
    }
}
