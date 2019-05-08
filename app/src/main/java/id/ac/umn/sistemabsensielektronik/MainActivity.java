package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    Button buttonMasterKaryawan, buttonAbsen, buttonNotification, buttonEditProfile, buttonLogout;
    TextView signedin_username, signedin_userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser == null){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        //Deklarasi function buttons:
        buttonMasterKaryawan = findViewById(R.id.buttonMasterKaryawan);
        buttonAbsen = findViewById(R.id.buttonAbsen);
        buttonNotification = findViewById(R.id.buttonNotification);
        buttonEditProfile = findViewById(R.id.buttonEditProfile);
        buttonLogout = findViewById(R.id.buttonLogout);

        //Deklarasi function TextView:
        signedin_username = findViewById(R.id.signedin_username);
        signedin_userid = findViewById(R.id.signedin_userid);

        //If buttonMasterKaryawan is clicked:
        buttonMasterKaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MasterKaryawanActivity.class);
                startActivity(intent);
            }
        });

        //If buttonAbsen is clicked:
        buttonAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AbsenActivity.class);
                startActivity(intent);
            }
        });

        //If buttonNotification is clicked:
        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        //If buttonEditProfile is clicked:
        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });

        //If buttonLogout is clicked:
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    startActivity(
                                            new Intent(MainActivity.this, LoginActivity.class)
                                    );
                                    finish();
                                }
                                else {
                                    //Apabila error...
                                }
                            }
                        });
            }
        });
    }
}
