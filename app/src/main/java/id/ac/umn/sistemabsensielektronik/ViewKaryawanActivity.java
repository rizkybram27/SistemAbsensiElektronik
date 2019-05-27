package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import id.ac.umn.sistemabsensielektronik.AdapterDataKaryawan;
import id.ac.umn.sistemabsensielektronik.DataKaryawan;

public class ViewKaryawanActivity extends AppCompatActivity {

    Button buttonViewKaryawan, buttonBack;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DataKaryawan> dataKaryawan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_karyawan);


        //If buttonBack is clicked:
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewKaryawanActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //If buttonViewKaryawan is clicked:
        buttonViewKaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mengambil instance class dari Firebase Database:
                //Mengambil reference dari database yang akan digunakan, by default ada pada root-tree:
                databaseReference = FirebaseDatabase.getInstance().getReference("data/karyawan/");

                ValueEventListener changeListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            long totalChild = dataSnapshot.getChildrenCount();

                            for(DataSnapshot child : dataSnapshot.getChildren()){
                                Log.i("DATA", "KEY: " + child.getKey());
                            }

                            DataKaryawan dataKaryawan = dataSnapshot.getValue(DataKaryawan.class);
                            Log.i("OBJECT", "Firstname: " + dataKaryawan.getFirstName());
                            Log.i("OBJECT", "Lastname: " + dataKaryawan.getLastName());
                            Log.i("OBJECT", "NIK: " + dataKaryawan.getNIK());
                            Log.i("OBJECT", "Email: " + dataKaryawan.getEmail());
                            Log.i("OBJECT", "Division: " + dataKaryawan.getDivision());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                };
                databaseReference.addValueEventListener(changeListener);
            }
        });
    }
}