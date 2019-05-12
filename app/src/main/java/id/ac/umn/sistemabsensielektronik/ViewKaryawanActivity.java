package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewKaryawanActivity extends AppCompatActivity {

    Button buttonViewKaryawan, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_karyawan);

        buttonViewKaryawan = findViewById(R.id.buttonViewKaryawan);
        buttonBack = findViewById(R.id.buttonBack);

        buttonViewKaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference();

                ValueEventListener changeListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()) {
                            long totalChild = dataSnapshot.getChildrenCount();

                            for (DataSnapshot child : dataSnapshot.getChildren()) {
                                Log.i("DATA", "KEY: " + child.getKey());
                            }

                            DataKaryawan dataKaryawan = dataSnapshot.getValue(DataKaryawan.class);
                            Log.i("OBJECT", "FIRSTNAME: " + dataKaryawan.getFirstName());
                            Log.i("OBJECT", "LASTNAME: " + dataKaryawan.getLastName());
                            Log.i("OBJECT", "NIK: " + dataKaryawan.getNIK());
                            Log.i("OBJECT", "EMAIL: " + dataKaryawan.getEmail());
                            Log.i("OBJECT", "DIVISION: " + dataKaryawan.getDivision());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                };

                databaseReference = database.getReference("/data/karyawan");
                databaseReference.addValueEventListener(changeListener);
            }
        });

        //If buttonBack is clicked:
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewKaryawanActivity.this, AbsenActivity.class);
                startActivity(intent);
            }
        });
    };
}
