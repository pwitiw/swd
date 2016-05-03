package pwr.swd;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/**
 * Created by marta on 24.04.2016.
 */
public class MyEditText extends EditText implements OnClickListener {

    Context mContext;
    Paint paint;
    EditText editText;
    View v;
    private int mPaddingLeft;
    private String mLabel = "ulica, miasto :  ";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public MyEditText(Context context) {
        super(context);
        mPaddingLeft = getPaddingLeft();
    }
    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaddingLeft = getPaddingLeft();
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaddingLeft = getPaddingLeft();
    }

    protected void onDraw(Canvas canvas) {
        TextPaint textPaint = getPaint();
        Rect size = new Rect();
        textPaint.getTextBounds(mLabel, 0, mLabel.length(), size);
        setPadding(mPaddingLeft + size.width(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        super.onDraw(canvas);

        canvas.drawText(mLabel, mPaddingLeft + size.left, size.bottom + getPaddingTop()+10, textPaint);
    }

    @Override
    public void onClick(View v) {
        EditText txt = (EditText) v;
        txt.selectAll();
    }
}