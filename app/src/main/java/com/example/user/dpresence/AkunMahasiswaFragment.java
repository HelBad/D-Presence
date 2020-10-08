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

public class AkunMahasiswaFragment extends Fragment {
    DatabaseReference databaseReference;
    TextView nimMhs, namaMhs, emailMhs, kelasMhs, prodiMhs, genderMhs, alamatMhs, telpMhs;

    public AkunMahasiswaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_akun_mahasiswa, container, false);

        nimMhs = (TextView) rootView.findViewById(R.id.nimMhs);
        namaMhs = (TextView) rootView.findViewById(R.id.namaMhs);
        emailMhs = (TextView) rootView.findViewById(R.id.emailMhs);
        kelasMhs = (TextView) rootView.findViewById(R.id.kelasMhs);
        prodiMhs = (TextView) rootView.findViewById(R.id.prodiMhs);
        genderMhs = (TextView) rootView.findViewById(R.id.genderMhs);
        alamatMhs = (TextView) rootView.findViewById(R.id.alamatMhs);
        telpMhs = (TextView) rootView.findViewById(R.id.telpMhs);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = databaseReference.child("mhs").orderByChild("email");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot datasnapshot) {
                if (datasnapshot != null) {
                    for (DataSnapshot snapshot1 : datasnapshot.getChildren()){
                        Mahasiswa allocation = snapshot1.getValue(Mahasiswa.class);
                        nimMhs.setText(allocation.getNim());
                        namaMhs.setText(allocation.getNama());
                        emailMhs.setText(allocation.getEmail());
                        kelasMhs.setText(allocation.getKelas());
                        prodiMhs.setText(allocation.getProdi());
                        genderMhs.setText(allocation.getJk());
                        alamatMhs.setText(allocation.getAlamat());
                        telpMhs.setText(allocation.getTelp());
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