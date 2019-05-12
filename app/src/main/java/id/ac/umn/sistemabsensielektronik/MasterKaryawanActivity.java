package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MasterKaryawanActivity extends AppCompatActivity {

    Button buttonView, buttonAdd, buttonEdit, buttonRemove, buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_karyawan);

        //Deklarasi function buttons:
        buttonView = findViewById(R.id.buttonView);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonRemove = findViewById(R.id.buttonRemove);
        buttonHome = findViewById(R.id.buttonHome);

        //If buttonView is clicked:
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterKaryawanActivity.this, ViewKaryawanActivity.class);
                startActivity(intent);
            }
        });

        //If buttonAdd is clicked:
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterKaryawanActivity.this, AddKaryawanActivity.class);
                startActivity(intent);
            }
        });

        //If buttonEdit is clicked:
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterKaryawanActivity.this, AddKaryawanActivity.class);
                startActivity(intent);
            }
        });

        //If buttonRemove is clicked:
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterKaryawanActivity.this, AddKaryawanActivity.class);
                startActivity(intent);
            }
        });

        //If buttonHome is clicked:
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterKaryawanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
