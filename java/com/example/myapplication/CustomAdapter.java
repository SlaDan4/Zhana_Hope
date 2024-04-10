package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private String[] mItems;

    public CustomAdapter(Context context, String[] items) {
        super(context, R.layout.list_item_layout, items);
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);

        ImageView imageView = view.findViewById(R.id.item_image);
        TextView textView = view.findViewById(R.id.item_text);

        if (position == 1) {
            imageView.setImageResource(R.drawable.image1);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            params.width = 100 * (int) mContext.getResources().getDisplayMetrics().density;
            params.height = 100 * (int) mContext.getResources().getDisplayMetrics().density;
            imageView.setLayoutParams(params);
        } else if (position == 2) {
            imageView.setImageResource(R.drawable.image2);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            params.width = 85 * (int) mContext.getResources().getDisplayMetrics().density;
            params.height = 85 * (int) mContext.getResources().getDisplayMetrics().density;
            params.setMarginStart(10);
            imageView.setLayoutParams(params);
        } else if (position == 3) {
            imageView.setImageResource(R.drawable.image3);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            params.width = 70 * (int) mContext.getResources().getDisplayMetrics().density;
            params.height = 70 * (int) mContext.getResources().getDisplayMetrics().density;
            imageView.setLayoutParams(params);
            params.setMarginStart(5);
        } else {
            imageView.setVisibility(View.GONE);
        }

        if (position <= 3) {
            textView.setText(mItems[position]);
        } else {
            textView.setText((position) + ". " + mItems[position]);
        }

        return view;
    }

}

