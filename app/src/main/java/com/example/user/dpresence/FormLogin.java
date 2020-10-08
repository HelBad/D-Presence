package com.example.user.dpresence;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FormLogin extends AppCompatActivity implements View.OnClickListener {
    AlertDialog.Builder alertDialog;
    Button loginDosen;
    Button loginMhs;
    EditText textUsername;
    EditText textPassword;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        alertDialog = new AlertDialog.Builder(this);
        textUsername = (EditText) findViewById(R.id.textUsername);
        textPassword = (EditText) findViewById(R.id.textPassword);
        loginDosen = (Button) findViewById(R.id.loginDosen);
        loginDosen.setOnClickListener(this);
        loginMhs = (Button) findViewById(R.id.loginMhs);
        loginMhs.setOnClickListener(this);

        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View view) {
        if(view == loginDosen) {
            loginDosen();
        } else if(view == loginMhs) {
            loginMahasiswa();
        }
    }

    private void loginDosen() {
        String email = textUsername.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        Query query = databaseReference.child("dosen").orderByChild("email").equalTo(textUsername.getText().toString().trim());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        Dosen usersBean = user.getValue(Dosen.class);
                        if (usersBean.password.equals(textPassword.getText().toString().trim())) {
                            Intent intent = new Intent(getApplicationContext(), MenuDosen.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(FormLogin.this, "Password is wrong", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(FormLogin.this, "User not found", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void loginMahasiswa() {
        String email = textUsername.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        Query query = databaseReference.child("mhs").orderByChild("email").equalTo(textUsername.getText().toString().trim());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot user : dataSnapshot.getChildren()) {
                        Mahasiswa usersBean = user.getValue(Mahasiswa.class);
                        if (usersBean.password.equals(textPassword.getText().toString().trim())) {
                            Intent intent = new Intent(getApplicationContext(), MenuMahasiswa.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(FormLogin.this, "Password is wrong", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(FormLogin.this, "User not found", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(FormLogin.this, "Back is Clicked", Toast.LENGTH_SHORT).show();
        alertDialog.setTitle("Close Application");
        alertDialog.setMessage("Do you want to close the application ?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create().show();
    }
}