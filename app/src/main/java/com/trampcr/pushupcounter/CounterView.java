package com.trampcr.pushupcounter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * Created by zxm on 2016/7/25.
 */
public class CounterView extends View implements View.OnClickListener {

    private Paint mPaint;
    private Rect mRect;
    private int number = Integer.parseInt(PushUpsActivity.number);
    private int mBackgroundColor;
    private int mTextColor;
    private int mTextSize;


    public CounterView(Context context) {
        //在构造器中用this调用后边的构造器，这样只在最后一个构造器中初始化view即可。
        this(context, null);
    }

    public CounterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        mRect = new Rect();

        this.setOnClickListener(this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CounterView);
        mBackgroundColor = typedArray.getColor(R.styleable.CounterView_backgroundColor, Color.BLACK);
        mTextColor= typedArray.getColor(R.styleable.CounterView_textColor, Color.YELLOW);
        mTextSize = (int) typedArray.getDimension(R.styleable.CounterView_textSize, 18);
    }

    /**
     * 在onDraw方法中画圆形按钮和数字
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画图需要画笔，但不能在onDraw中创建Paint，因为onDraw使用频繁，会导致过多的内存消耗，所以创建工作放在了init中。
        mPaint.setColor(mBackgroundColor);
        mPaint.setAntiAlias(false);
        //画圆形按钮
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, mPaint);
        //画白色数字需要将画笔颜色设置为白色
        mPaint.setColor(mTextColor);
        //设置字体大小
        mPaint.setTextSize(mTextSize);
        String text = String.valueOf(number);
        mPaint.getTextBounds(text, 0, text.length(), mRect);

        int textWidth = mRect.width();
        int textHeight = mRect.height();

        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 2, mPaint);
    }

    @Override
    public void onClick(View v) {
        if (number > 0) {
            number--;
            invalidate();
        } else if (number == 0) {
            Toast.makeText(getContext(), "训练结束", Toast.LENGTH_LONG).show();
        }
    }
}
