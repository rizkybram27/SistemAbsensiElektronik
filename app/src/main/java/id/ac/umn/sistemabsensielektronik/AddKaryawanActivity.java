package id.ac.umn.sistemabsensielektronik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

public class AddKaryawanActivity extends AppCompatActivity {


    private EditText editFirst, editLast, editNik, editEmail, editPhone, editPassword, editPassword2;
    private Spinner spinnerDepartment, spinnerJob;
    private Button buttonAddKaryawan;
    private FirebaseAuth mAuth;

    //defining firebaseauth object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_karyawan);

        //Get Firebase auth instance
        mAuth = FirebaseAuth.getInstance();

        editFirst = (EditText) findViewById(R.id.editFirst);
        editLast = (EditText) findViewById(R.id.editLast);
        editNik = (EditText) findViewById(R.id.editNik);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPhone = (EditText) findViewById(R.id.editPhone);
        spinnerDepartment = (Spinner) findViewById(R.id.spinnerDepartment);
        spinnerJob = (Spinner) findViewById(R.id.spinnerJob);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editPassword2 = (EditText) findViewById(R.id.editPassword2);
        buttonAddKaryawan = (Button) findViewById(R.id.buttonAddKaryawan);



    }
}
