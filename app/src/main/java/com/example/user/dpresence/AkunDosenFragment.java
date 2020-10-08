package com.example.user.dpresence;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AkunDosenFragment extends Fragment {
    DatabaseReference databaseReference;
    TextView nipDosen, namaDosen, emailDosen, prodiDosen, genderDosen, alamatDosen, telpDosen;

    public AkunDosenFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_akun_dosen, container, false);

        nipDosen = (TextView) rootView.findViewById(R.id.nipDosen);
        namaDosen = (TextView) rootView.findViewById(R.id.namaDosen);
        emailDosen = (TextView) rootView.findViewById(R.id.emailDosen);
        prodiDosen = (TextView) rootView.findViewById(R.id.prodiDosen);
        genderDosen = (TextView) rootView.findViewById(R.id.genderDosen);
        alamatDosen = (TextView) rootView.findViewById(R.id.alamatDosen);
        telpDosen = (TextView) rootView.findViewById(R.id.telpDosen);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = databaseReference.child("dosen").orderByChild("email");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot datasnapshot) {
                if (datasnapshot != null) {
                    for (DataSnapshot snapshot1 : datasnapshot.getChildren()){
                        Dosen allocation = snapshot1.getValue(Dosen.class);
                        nipDosen.setText(allocation.getNip());
                        namaDosen.setText(allocation.getNama());
                        emailDosen.setText(allocation.getEmail());
                        prodiDosen.setText(allocation.getProdi());
                        genderDosen.setText(allocation.getJk());
                        alamatDosen.setText(allocation.getAlamat());
                        telpDosen.setText(allocation.getTelp());
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return rootView;
    }
}