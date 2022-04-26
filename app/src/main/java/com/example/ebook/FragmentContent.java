package com.example.ebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentContent extends Fragment {
    TextView txtContent;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_content, container,false);

        txtContent = (TextView) v.findViewById(R.id.textViewContent);
        String content = getActivity().getIntent().getStringExtra("noi dung");
        txtContent.setText(content);

        return v;
    }
}
