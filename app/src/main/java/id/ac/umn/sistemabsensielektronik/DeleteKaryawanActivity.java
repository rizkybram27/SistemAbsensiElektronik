package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteKaryawanActivity extends AppCompatActivity {

    Button buttonDelete, buttonCancel;
    EditText infoNIK, editPassword;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_karyawan);

        databaseReference = FirebaseDatabase.getInstance().getReference("data/karyawan/");
        infoNIK = findViewById(R.id.infoNIK);
        editPassword = findViewById(R.id.editPassword);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonCancel = findViewById(R.id.buttonCancel);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteKaryawanActivity.this, MasterKaryawanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NIK = infoNIK.getText().toString();
                String password = editPassword.getText().toString();

                //If password is empty:
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password to perform this action!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //REMOVING THE DATA (Only 1 line but very important):
                databaseReference.child(NIK).removeValue();

                Toast.makeText(DeleteKaryawanActivity.this,"Data removed!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DeleteKaryawanActivity.this, MasterKaryawanActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
