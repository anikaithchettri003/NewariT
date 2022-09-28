package com.example.newarit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ViewPager viewPager;
    private ArrayList<MyModel> modelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        actionBar = getSupportActionBar();

        viewPager = findViewById(R.id.ViewPager);
        loadcards();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title = modelArrayList.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void loadcards() {
        modelArrayList = new ArrayList<>();
        modelArrayList.add(new MyModel(
                "Title 01",
                "Description 01",
                "23/04/2022",
                R.drawable.bnfd));
        modelArrayList.add(new MyModel(
                "Title 02",
                "Description 02",
                "12/07/2022",
                R.drawable.bnfd));
        //add more cards  here


        MyAdapter myAdapter = new MyAdapter(this, modelArrayList);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(100,0,100,0);
    }
}