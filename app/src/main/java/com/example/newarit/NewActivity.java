package com.example.newarit;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;


import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    private ViewPager viewPager;
    private ArrayList<MyModel> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        viewPager = findViewById(R.id.ViewPager);
        loadcards();

    }

    private void loadcards() {
        modelArrayList = new ArrayList<>();
        modelArrayList.add(new MyModel(
                "English -> Newari",
                "English:" +"\n"+
                        "Where are you from?"+"\n"+
                        "Newari:" +"\n"+
                        "Cha gana kha?",
                "23/04/2022",
                R.drawable.back));
        modelArrayList.add(new MyModel(
                "English -> Newari",
                "English:" +"\n"+
                        "I am from Sikkim"+"\n"+
                        "Newari:" +"\n"+
                        "Ji ______ na kha",
                "23/04/2022",
                R.drawable.back));
        modelArrayList.add(new MyModel(
                "English -> Newari",
                "English:" +"\n"+
                        "What is that?"+"\n"+
                        "Newari:" +"\n"+
                        "Wo Chu kha?",
                "23/04/2022",
                R.drawable.back));

        //add more cards  here


        MyAdapter myAdapter = new MyAdapter(this, modelArrayList);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(60,50,60,0);
    }

}