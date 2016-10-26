package www.yunwen.androidsdk.mywebview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by iyunwen on 2016/10/26.
 */

public class MyWebView extends WebView {
    public MyWebView(Context context) {
        super(context);
        init();

    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        WebSettings settings = this.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        settings.setDefaultTextEncodingName("UTF-8");
    }


    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private int mMaxHeight = -1;

    public void setMaxHeight(int height) {
        mMaxHeight = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mMaxHeight > -1 && getMeasuredHeight() > mMaxHeight) {
            setMeasuredDimension(getMeasuredWidth(), mMaxHeight);
        }
    }

    private boolean isEnd;

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        int i = t + getHeight() + 1;
        int dp = dp(getContentHeight());
        if (i == dp) {
            //到地段了
            Log.e("AA", "-到地段了--");
            isEnd = true;

        } else {
            //正在滑动
            Log.e("AA", "-正在滑动--");
            isEnd = false;
            if (0 == t) {
                //到顶端
                Log.e("AA", "-到顶端--");
                isEnd = true;
            }

        }
    }

    private int dp(int val) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, val, getContext().getResources().getDisplayMetrics());
    }


    private float newScale = 1;

    public void setScaleSize(float newScale) {
        this.newScale = newScale;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (MotionEvent.ACTION_DOWN == action) {
                requestDisallowInterceptTouchEvent(true);
        }
        if (MotionEvent.ACTION_MOVE == action) {
            if (isEnd) {
                requestDisallowInterceptTouchEvent(false);
                isEnd = false;
            } else {
                requestDisallowInterceptTouchEvent(true);
            }
        }

        return super.onTouchEvent(event);
    }
}
