package com.example.project_input_nama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NameAdapter adapter;
    private List<NameModel> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        EditText inputNama = findViewById(R.id.inputNama);  // Deklarasi lokal
        Button tambahBtn = findViewById(R.id.tambahBtn);    // Deklarasi lokal

        nameList = new ArrayList<>();
        nameList.add(new NameModel("Alya"));
        nameList.add(new NameModel("Budi"));
        nameList.add(new NameModel("Citra"));
        nameList.add(new NameModel("Dedi"));
        nameList.add(new NameModel("Eka"));

        adapter = new NameAdapter(nameList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        tambahBtn.setOnClickListener(v -> {
            String namaBaru = inputNama.getText().toString().trim();
            if (!namaBaru.isEmpty()) {
                nameList.add(new NameModel(namaBaru));
                adapter.notifyItemInserted(nameList.size() - 1);
                inputNama.setText(""); // Bersihkan input
            }
        });
    }
}
