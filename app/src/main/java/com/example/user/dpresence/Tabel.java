package com.example.user.dpresence;

import com.google.firebase.database.Exclude;
import java.util.HashMap;
import java.util.Map;

public class Tabel {
    public String nama;

    public Tabel() {
    }

    public Tabel(String nama) {
        this.nama = nama;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama", nama);
        return result;
    }
}
