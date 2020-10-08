package com.example.user.dpresence;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class PresensiMahasiswaFragment extends Fragment {
    public static TextView textNim, textNama, textMatkul;
    private  Button btnScan, btnAdd;
    DatabaseReference databaseReference;

    public PresensiMahasiswaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_presensi_mahasiswa, container, false);

        textNim = (TextView) rootView.findViewById(R.id.textNim);
        textNama = (TextView) rootView.findViewById(R.id.textNama);
        textMatkul = (TextView) rootView.findViewById(R.id.textMatkul);
        btnScan = (Button) rootView.findViewById(R.id.btnScan);
        btnAdd = (Button) rootView.findViewById(R.id.btnAdd);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = databaseReference.child("mhs").orderByChild("email");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot datasnapshot) {
                if (datasnapshot != null) {
                    for (DataSnapshot snapshot1 : datasnapshot.getChildren()){
                        Mahasiswa allocation = snapshot1.getValue(Mahasiswa.class);
                        textNim.setText(allocation.getNim());
                        textNama.setText(allocation.getNama());
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("perkuliahan").child("pertemuan1");

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QRCodeScanner.class);
                startActivity(intent);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
        return rootView;
    }

    private void addData() {
        String nim = textNim.getText().toString().trim();
        String nama = textNama.getText().toString().trim();
        String matkul = textMatkul.getText().toString().trim();

        if (!TextUtils.isEmpty(matkul)) {
            String id = databaseReference.push().getKey();
            Matkul identity = new Matkul(matkul);
            databaseReference.child(id).setValue(identity);
            Matkul name = new Matkul(matkul);
            databaseReference.child(id).setValue(name);
            Matkul study = new Matkul(matkul);
            databaseReference.child(id).setValue(study);
            textMatkul.setText("");
            Toast.makeText(getActivity(), "Data added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Please Scan QR Code", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(getActivity(), "You Cancelled the Scanning", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), result.getContents(), Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}