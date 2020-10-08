package com.example.user.dpresence;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import me.biubiubiu.justifytext.library.JustifyTextView;

public class AboutDosen extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dosen);

        toolbar = findViewById(R.id.toolbarAboutDosen);
        toolbar.setTitle("TERM OF SERVICES");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String label = "PENGGUNAAN APLIKASI INI MENUNJUKKAN PENERIMAAN DAN KEPATUHAN TERHADAP SYARAT DAN KETENTUAN DIBAWAH INI.\n" +
                "\n" +
                "       Selamat datang di Aplikasi D’Presence, suatu aplikasi daftar hadir digital mahasiswa berbasis android dengan menggunakan system pemindaian QR code.\n" +
                "       Syarat-syarat dan ketentuan penggunaan berikut ini berlaku dalam mengakses, memasang, dan atau menggunakan Aplikasi. Harap diketahui bahwa kami dapat mengubah, memodifikasi, menambah dan menghapus Syarat Penggunaan ini sewaktu-waktu tanpa pemberitahuan sebelumnya. Syarat Penggunaan harus dibaca secara berkala. Dengan terus menggunakan Aplikasi ini setelah perubahan tersebut terhadap Syarat Penggunaan, pengguna terdaftar (baik sebagai dosen ataupun mahasiswa) sepakat dan menyetujui perubahan. Jika Anda menggunakan layanan, maka penggunaan Anda didasarkan pada kepatuhan dan penerimaan terhadap syarat dan ketentuan yang berlaku untuk layanan tersebut.\n" +
                "\n" +
                "PRIVASI\n" +
                "       Kami menghargai kerahasiaan Pengguna. Kami akan berusaha keras untuk mematuhi persyaratan perundangan perlindungan data yang relevan saat melakukan kewajibannya menurut Syarat Penggunaan ini.\n" +
                "\n" +
                "HUKUM YANG MENGATUR\n" +
                "       Syarat Penggunaan ini akan diatur oleh dan ditafsirkan sesuai dengan peraturan yang berlaku di suatu instansi atau lembaga tersebut.\n" +
                "\n" +
                "KETENTUAN\n" +
                "       Aplikasi ini merupakan aplikasi yang bersifat local area. Jika Anda memiliki pertanyaan lebih lanjut ataupun keluhan, harap menemui Admin.\n";

        JustifyTextView txtLabel = (JustifyTextView) findViewById(R.id.textdosen);
        txtLabel.setText(label);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAbout:
                Toast.makeText(this, "Menu is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, AboutDosen.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}