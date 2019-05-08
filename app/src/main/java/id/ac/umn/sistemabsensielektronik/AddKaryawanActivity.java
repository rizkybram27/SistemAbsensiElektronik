//CLEAR (06/05/2019)

package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddKaryawanActivity extends AppCompatActivity {

    Button buttonAddKaryawan;
    EditText editFirstName, editLastName, editEmail, editNIK, editDivision;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_karyawan);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        editFirstName = (EditText) findViewById(R.id.inputFirstName);
        editLastName = (EditText) findViewById(R.id.inputLastName);
        editEmail = (EditText) findViewById(R.id.inputEmail);
        editNIK = (EditText) findViewById(R.id.inputNIK);
        editDivision = (EditText) findViewById(R.id.inputDivision);
        buttonAddKaryawan = (Button) findViewById(R.id.buttonAddKaryawan);


        //If buttonAddKaryawan is clicked:
        buttonAddKaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ProgressBar declaration:
                progressBar.setVisibility(View.VISIBLE);

                //Mengambil instance class dari Firebase Database:
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                //Mengambil reference dari database yang akan digunakan, by default ada pada root-tree:
                DatabaseReference databaseReference = database.getReference();

                final String NIK = editNIK.getText().toString();
                databaseReference = database.getReference("/data/karyawan/" + NIK + "/NIK");
                databaseReference.setValue(NIK);

                final String division = editDivision.getText().toString();
                databaseReference = database.getReference("/data/karyawan/" + NIK + "/division");
                databaseReference.setValue(division);

                final String email = editEmail.getText().toString();
                databaseReference = database.getReference("/data/karyawan/" + NIK + "/email");
                databaseReference.setValue(email);

                final String firstName = editFirstName.getText().toString();
                databaseReference = database.getReference("/data/karyawan/" + NIK + "/firstname");
                databaseReference.setValue(firstName);

                final String lastName = editLastName.getText().toString();
                databaseReference = database.getReference("/data/karyawan/" + NIK + "/lastname");
                databaseReference.setValue(lastName);

                Intent intent = new Intent(AddKaryawanActivity.this, MasterKaryawanActivity.class);
                startActivity(intent);

                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
