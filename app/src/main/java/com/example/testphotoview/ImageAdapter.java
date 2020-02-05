package com.example.testphotoview;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mDataList;

    public ImageAdapter(List<String> mDataList) {
        this.mDataList = mDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PhotoView imageView = ((ImageViewHolder) holder).imageIv;
        Glide.with(imageView.getContext())
                .load(mDataList.get(position))
                .into(imageView);
        imageView.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        PhotoView imageIv;

        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageIv = itemView.findViewById(R.id.image_iv);
        }
    }
}
