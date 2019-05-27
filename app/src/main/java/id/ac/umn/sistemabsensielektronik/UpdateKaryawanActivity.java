package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UpdateKaryawanActivity extends AppCompatActivity {

    EditText editFirstName, editLastName, editDivision, editEmail, infoNIK;
    Button buttonUpdate;
    DatabaseReference databaseReference;
    ListView listViewKaryawan;
    ArrayList<DataKaryawan> dataKaryawan;

    //User ID = NIK, penampung NIK dari Firebase:
    /*public static String NIK;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_karyawan);

        databaseReference = FirebaseDatabase.getInstance().getReference("data/karyawan/");

        buttonUpdate = findViewById(R.id.buttonUpdate);
        infoNIK = findViewById(R.id.infoNIK);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editDivision = findViewById(R.id.editDivision);
        editEmail = findViewById(R.id.editEmail);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = editFirstName.getText().toString();
                String lastName = editLastName.getText().toString();
                String division = editDivision.getText().toString();
                String email = editEmail.getText().toString();
                String NIK = infoNIK.getText().toString();

                if (TextUtils.isEmpty(firstName)){
                    Log.d("debug", "Data firstName tidak diisi.");
                } else { databaseReference.child(NIK).child("firstName").setValue(firstName); }

                if (TextUtils.isEmpty(lastName)){
                    Log.d("debug", "Data lastName tidak diisi.");
                } else { databaseReference.child(NIK).child("lastName").setValue(lastName); }

                if (TextUtils.isEmpty(division)){
                    Log.d("debug", "Data division tidak diisi.");
                } else { databaseReference.child(NIK).child("division").setValue(division); }

                if (TextUtils.isEmpty(email)){
                    Log.d("debug", "Data email tidak diisi.");
                } else { databaseReference.child(NIK).child("email").setValue(email); }

                Toast.makeText(UpdateKaryawanActivity.this,"Data updated.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UpdateKaryawanActivity.this, MasterKaryawanActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
