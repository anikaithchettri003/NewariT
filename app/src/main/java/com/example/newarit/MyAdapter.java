package com.example.newarit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<MyModel> modelArrayList;

    public MyAdapter(Context context, ArrayList<MyModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }


    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);

        ImageView banner1 = view.findViewById(R.id.banner1);
        TextView title1 = view.findViewById(R.id.title1);
        TextView description1 = view.findViewById(R.id.description);
        TextView date1 = view.findViewById(R.id.date);

        MyModel model = modelArrayList.get(position);
        String title = model.getTitle();
        String description = model.getDescription();
        String date = model.getDate();
        int image = model.getImage();

        banner1.setImageResource(image);
        title1.setText(title);
        description1.setText(description);
        date1.setText(date);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        container.addView(view, position);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
