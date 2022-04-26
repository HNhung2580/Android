package com.example.ebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentChapter extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_chapter, container, false);

       String[] chapter = getResources().getStringArray(R.array.chapter_book);
       final String[] content = getResources().getStringArray(R.array.content_book);

       ListView lvChapter = (ListView) v.findViewById(R.id.listviewChapter);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, chapter);

        lvChapter.setAdapter(listViewAdapter);

        lvChapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int positon, long id) {
                String noidung = content[positon];
                Intent intent5 = new Intent(getActivity(), ActivityContent.class);
                intent5.putExtra("noi dung", noidung);
                startActivity(intent5);
            }
        });

        return v;
    }

}
