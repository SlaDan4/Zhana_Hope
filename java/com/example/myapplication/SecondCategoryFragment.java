package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondCategoryFragment extends Fragment {
    private ListView listView;

    private String[] altItemsOrph = {
            "Детскиe домa:",
            "Детский дом №8",
            "Детский дом №1",
            "Детский дом №9",
            "Детский дом №7",
            "Детский дом №4",
            "Детский дом №12",
            "Детский дом №6",
            "Детский дом №10",
            "Детский дом №3",
            "Детский дом №5",
            "Детский дом №11",
            "Детский дом №2"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_category, container, false);
        listView = view.findViewById(R.id.category_list_1);
        listView.setAdapter(new CustomAdapter(requireContext(), altItemsOrph));
        return view;
    }
}
