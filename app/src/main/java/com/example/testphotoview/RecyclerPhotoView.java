package com.example.testphotoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerPhotoView extends RecyclerView {

    private ScaleGestureDetector gestureDetector;

    /**
     * 标记位  isScaleing 是否正在缩放，hasMorePointers 是否多个手指在屏幕上
     */
    private boolean isScaleing, hasMorePointers;

    public RecyclerPhotoView(Context context) {
        super(context);
        init(context);
    }

    public RecyclerPhotoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RecyclerPhotoView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        gestureDetector = new ScaleGestureDetector(context, new GestureListener());
    }

    class GestureListener implements ScaleGestureDetector.OnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            isScaleing = true;
            return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return false;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            isScaleing = false;
        }
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gestureDetector.onTouchEvent(ev);
        if (ev.getPointerCount() > 1) {
            hasMorePointers = true;
        } else {
            hasMorePointers = false;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (isScaleing || hasMorePointers) {
            return false;
        }
        return super.onInterceptTouchEvent(e);
    }
}
