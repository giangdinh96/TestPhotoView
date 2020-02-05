package com.example.testphotoview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageList();
    }

    private void initImageList() {
        RecyclerView imageListRv = findViewById(R.id.list_rv);
        ImageAdapter imageAdapter = new ImageAdapter(generateImageListFake());
        imageListRv.setLayoutManager(new LinearLayoutManager(this));
        imageListRv.setAdapter(imageAdapter);
    }

    private List<String> generateImageListFake() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add("https://i.pinimg.com/originals/2a/37/bc/2a37bc4b74a3dcb4ace8bee7057d050b.jpg");
        }
        return result;
    }
}
