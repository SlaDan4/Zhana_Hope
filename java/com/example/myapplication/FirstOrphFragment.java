package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FirstOrphFragment extends Fragment {
    private ListView listView;

    private String[] itemsCat = {
            "Категории:",
            "Игрушки",
            "Канцелярские принадлежности",
            "Одежда и обувь",
            "Книги",
            "Спортивные принадлежности",
            "Техника",
            "Гигиенические средства"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_category, container, false);
        listView = view.findViewById(R.id.category_list_1);
        listView.setAdapter(new CustomAdapter(requireContext(), itemsCat));
        return view;
    }
}
