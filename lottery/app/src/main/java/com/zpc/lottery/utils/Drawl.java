package com.zpc.lottery.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Drawl extends View {

    private int startX;//声明起点坐标
    private int startY;
    private int stopX;
    private int stopY;
    private Paint paint;//声明画笔

    public Drawl(Context context, int startX, int startY, int stopX, int stopY) {
        super(context);
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
        paint = new Paint(Paint.DITHER_FLAG);//创建一个画笔
        paint.setStyle(Paint.Style.STROKE);//设置非填充
        paint.setStrokeWidth(5);//笔宽5像素
        paint.setColor(Color.RED);//设置为红笔
        paint.setAntiAlias(true);//锯齿不显示

    }

    //画位图
    @Override
    protected void onDraw(Canvas canvas) {
//  super.onDraw(canvas);
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }


}