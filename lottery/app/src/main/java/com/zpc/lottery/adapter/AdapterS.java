package com.zpc.lottery.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zpc.lottery.R;
import com.zpc.lottery.beas.BaseX;

import java.util.List;

public class AdapterS extends BaseAdapter {

    private Context context;
    private List<BaseX> list;
    private TextView textView;

    public AdapterS(Context context, List<BaseX> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_1, null);
            holder = new viewHolder();
            holder.text1 = view.findViewById(R.id.text1);
            view.setTag(holder);
        } else {
            holder = (viewHolder) view.getTag();
        }
        int l[] = {0, 0};
        int l1[] = {0, 0};
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        String text1 = list.get(i).getBall1();
        if (textView == null) {
            textView = holder.text1;
        } else {
            textView.getLocationInWindow(l1);
            textView = holder.text1;
            holder.text1.getLocationInWindow(l);
        }
        if (text1.equals("01")) {
            holder.text1.setBackgroundColor(Color.parseColor("#bce672"));
            holder.text1.setText(text1);
        } else if (text1.equals("02")) {
            holder.text1.setBackgroundColor(Color.parseColor("#c9dd22"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 20), 0, 0, 0);
        } else if (text1.equals("03")) {
            holder.text1.setBackgroundColor(Color.parseColor("#bddd22"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 40), 0, 0, 0);
        } else if (text1.equals("04")) {
            holder.text1.setBackgroundColor(Color.parseColor("#afdd22"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 60), 0, 0, 0);
        } else if (text1.equals("05")) {
            holder.text1.setBackgroundColor(Color.parseColor("#a3d900"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 80), 0, 0, 0);
        } else if (text1.equals("06")) {
            holder.text1.setBackgroundColor(Color.parseColor("#9ed900"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 100), 0, 0, 0);
        } else if (text1.equals("07")) {
            holder.text1.setBackgroundColor(Color.parseColor("#9ed048"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 120), 0, 0, 0);
        } else if (text1.equals("08")) {
            holder.text1.setBackgroundColor(Color.parseColor("#96ce54"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 140), 0, 0, 0);
        } else if (text1.equals("09")) {
            holder.text1.setBackgroundColor(Color.parseColor("#00bc12"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 160), 0, 0, 0);
        } else if (text1.equals("10")) {
            holder.text1.setBackgroundColor(Color.parseColor("#0eb83a"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 180), 0, 0, 0);
        } else if (text1.equals("11")) {
            holder.text1.setBackgroundColor(Color.parseColor("#0aa344"));
            holder.text1.setText(text1);
            lp.setMargins(dip2px(context, 200), 0, 0, 0);
        }
        holder.text1.setLayoutParams(lp);
        drawer(l[0], l[1], l1[0], l1[1]);

        return view;
    }

    private void drawer(float startX, float startY, float stopX, float stopY) {
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#4b5cc4"));
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    class viewHolder {
        TextView text1;
    }
}
