//CLEAR (06/05/2019)

package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
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

        //Input:
        editFirstName = (EditText) findViewById(R.id.inputFirstName);
        editLastName = (EditText) findViewById(R.id.inputLastName);
        editEmail = (EditText) findViewById(R.id.inputEmail);
        editNIK = (EditText) findViewById(R.id.inputNIK);
        editDivision = (EditText) findViewById(R.id.inputDivision);
        buttonAddKaryawan = (Button) findViewById(R.id.buttonAddKaryawan);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        /*
        final String getFirstName = editFirstName.getText().toString();
        final String getLastName = editLastName.getText().toString();
        final String getEmail = editEmail.getText().toString();
        final String getNIK = editNIK.getText().toString();
        final String getDivision = editDivision.getText().toString();
        */

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

                final String NIK, division, email, firstName, lastName;

                NIK = editNIK.getText().toString();
                division = editDivision.getText().toString();
                email = editEmail.getText().toString();
                firstName = editFirstName.getText().toString();
                lastName = editLastName.getText().toString();

                if(TextUtils.isEmpty(firstName)){
                    Toast.makeText(getApplicationContext(), "Masukkan nama yang akan diregistrasikan.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(lastName)){
                    Toast.makeText(getApplicationContext(), "Jika tidak memiliki nama belakang, harap mengisi dengan tanda '-'.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Kolom alamat email wajib diisi.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(NIK)){
                    Toast.makeText(getApplicationContext(), "Harap mengisi kolom NIK.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(division)){
                    Toast.makeText(getApplicationContext(), "Harap mengisi kolom Division.", Toast.LENGTH_LONG).show();
                    return;
                }

                databaseReference = database.getReference("/data/karyawan/" + NIK + "/NIK");
                databaseReference.setValue(NIK);

                databaseReference = database.getReference("/data/karyawan/" + NIK + "/email");
                databaseReference.setValue(email);

                databaseReference = database.getReference("/data/karyawan/" + NIK + "/firstname");
                databaseReference.setValue(firstName);

                databaseReference = database.getReference("/data/karyawan/" + NIK + "/lastname");
                databaseReference.setValue(lastName);

                databaseReference = database.getReference("/data/karyawan/" + NIK + "/division");
                databaseReference.setValue(division);

                progressBar.setVisibility(View.GONE);

                Intent intent = new Intent(AddKaryawanActivity.this, MasterKaryawanActivity.class);
                startActivity(intent);
            }

                /*
                //Completion Listener, handling error Firebase:
                DatabaseReference.CompletionListener completionListener = new DatabaseReference.CompletionListener(){
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError,
                                           @NonNull DatabaseReference databaseReference){
                        if(databaseError != null){
                            Toast.makeText(AddKaryawanActivity.this, "Database error, silahkan contact admin.", Toast.LENGTH_SHORT).show();
                            Log.d("DATABASE ERROR", "Database Error!");
                        }
                    }
                };*/
        });
    }
}
