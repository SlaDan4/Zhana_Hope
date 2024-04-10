package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private Spinner spinnerCat;
    private Spinner spinnerOrph;
    private FrameLayout frameLayout;

    private FirstCategoryFragment firstCategoryFragment = new FirstCategoryFragment();
    private SecondCategoryFragment secondCategoryFragment = new SecondCategoryFragment();

    private FirstOrphFragment firstOrphFragment = new FirstOrphFragment();
    private SecondOrphFragment secondOrphFragment = new SecondOrphFragment();

    private String[] itemsCat = {
            "Категории",
            "Игрушки",
            "Канцелярские принадлежности",
            "Одежда и обувь",
            "Книги",
            "Спортивные принадлежности",
            "Техника",
            "Гигиенические средства"
    };

    private String[] altItemsCat = {
            "Категории",
            "Техника",
            "Книги",
            "Канцелярские принадлежности",
            "Гигиенические средства",
            "Спортивные принадлежности",
            "Игрушки",
            "Одежда и обувь"
    };

    private String[] itemsOrph = {
            "Детский дом",
            "Детский дом №1",
            "Детский дом №2",
            "Детский дом №3",
            "Детский дом №4",
            "Детский дом №5",
            "Детский дом №6",
            "Детский дом №7",
            "Детский дом №8",
            "Детский дом №9",
            "Детский дом №10",
            "Детский дом №11",
            "Детский дом №12"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCat = findViewById(R.id.spinnerCat);
        spinnerOrph = findViewById(R.id.spinnerOrph);
        frameLayout = findViewById(R.id.frameLayout);


        ArrayAdapter<String> adapterCat = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemsCat);
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCat.setAdapter(adapterCat);

        ArrayAdapter<String> adapterOrph = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemsOrph);
        adapterOrph.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrph.setAdapter(adapterOrph);

        spinnerOrph.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    if (position % 2 == 0) {
                        setNewFragment(firstOrphFragment);
                    } else {
                        setNewFragment(secondOrphFragment);
                    }
                    spinnerCat.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    if (position % 2 == 0) {
                        setNewFragment(firstCategoryFragment);
                    } else {
                        setNewFragment(secondCategoryFragment);
                    }
                    spinnerOrph.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}