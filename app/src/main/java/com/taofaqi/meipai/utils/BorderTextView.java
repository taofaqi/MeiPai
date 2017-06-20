package com.taofaqi.meipai.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by CrazyForUu on 2016/3/3.
 * 工具类，给TextView添加边框线
 */
public class BorderTextView extends TextView {

    private Paint paint = null;  //定义画笔
    private int color = Color.WHITE;  //设置默认画笔颜色

    public BorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //设置边框颜色
    public void setPaintColor(int color){
        this.color = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //定义画笔
        paint = new Paint();
        paint.setColor(color);

        //上
        canvas.drawLine(0, 0, this.getWidth()-1, 0, paint);
        //左
        canvas.drawLine(0, 0, 0, this.getHeight()-1, paint);
        //下
        canvas.drawLine(0, this.getHeight()-1, this.getWidth()-1, this.getHeight()-1, paint);
        //右
        canvas.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight()-1, paint);
    }
}
