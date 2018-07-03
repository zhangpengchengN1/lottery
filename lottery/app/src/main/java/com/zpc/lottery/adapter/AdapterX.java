package com.zpc.lottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zpc.lottery.R;
import com.zpc.lottery.beas.BaseX;

import java.util.List;

public class AdapterX extends BaseAdapter {

    private Context context;
    private List<BaseX> list;

    public AdapterX(Context context, List<BaseX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder = new viewHolder();
            holder.text=view.findViewById(R.id.text);
            holder.text1 = view.findViewById(R.id.text1);
            holder.text2 = view.findViewById(R.id.text2);
            holder.text3 = view.findViewById(R.id.text3);
            holder.text4 = view.findViewById(R.id.text4);
            holder.text5 = view.findViewById(R.id.text5);
            holder.text6 = view.findViewById(R.id.text6);
            holder.text7 = view.findViewById(R.id.text7);
            holder.text8 = view.findViewById(R.id.text8);
            holder.text9 = view.findViewById(R.id.text9);
            holder.text10 = view.findViewById(R.id.text10);
            holder.text11 = view.findViewById(R.id.text11);
            view.setTag(holder);
        }else {
            holder= (viewHolder) view.getTag();
        }

        holder.text.setText(list.get(i).getIssue());
        holder.text1.setText(list.get(i).getB_1()==null?"":list.get(i).getB_1());
        holder.text2.setText(list.get(i).getB_2()==null?"":list.get(i).getB_2());
        holder.text3.setText(list.get(i).getB_3()==null?"":list.get(i).getB_3());
        holder.text4.setText(list.get(i).getB_4()==null?"":list.get(i).getB_4());
        holder.text5.setText(list.get(i).getB_5()==null?"":list.get(i).getB_5());
        holder.text6.setText(list.get(i).getB_6()==null?"":list.get(i).getB_6());
        holder.text7.setText(list.get(i).getB_7()==null?"":list.get(i).getB_7());
        holder.text8.setText(list.get(i).getB_8()==null?"":list.get(i).getB_8());
        holder.text9.setText(list.get(i).getB_9()==null?"":list.get(i).getB_9());
        holder.text10.setText(list.get(i).getB_10()==null?"":list.get(i).getB_10());
        holder.text11.setText(list.get(i).getB_11()==null?"":list.get(i).getB_11());

        return view;
    }

    class viewHolder {
        TextView text,text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11;
    }
}
