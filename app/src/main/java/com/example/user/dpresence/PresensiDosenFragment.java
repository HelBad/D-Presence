package com.example.user.dpresence;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class PresensiDosenFragment extends Fragment {
    FlipperLayout flipperLayout;
    CardView menu15, menu17a;

    public PresensiDosenFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_presensi_dosen, container, false);

        flipperLayout = (FlipperLayout) rootView.findViewById(R.id.imgslider);
        menu15 = (CardView) rootView.findViewById(R.id.menu15);
        menu17a = (CardView) rootView.findViewById(R.id.menu17a);
        setLayout();
        menu15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Class TI 2015", Toast.LENGTH_SHORT).show();
                Intent goPindah = new Intent(getActivity(), TabelPresensi.class);
                startActivity(goPindah);
            }
        });
        menu17a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Class TI 2017A", Toast.LENGTH_SHORT).show();
                Intent goPindah = new Intent(getActivity(), TabelPresensi.class);
                startActivity(goPindah);
            }
        });
        return rootView;
    }

    private void setLayout() {
        String url[] = new String[] {
                "https://cdn.pixabay.com/photo/2014/03/25/23/04/technology-298256_1280.jpg",
                "https://cdn.pixabay.com/photo/2014/05/03/00/45/computer-336628_1280.jpg",
                "https://cdn.pixabay.com/photo/2016/11/19/14/00/code-1839406_1280.jpg"
        };
        for(int i=0; i<3; i++) {
            FlipperView view = new FlipperView(getContext());
            view.setImageUrl(url[i]);
            flipperLayout.addFlipperView(view);
        }
    }
}