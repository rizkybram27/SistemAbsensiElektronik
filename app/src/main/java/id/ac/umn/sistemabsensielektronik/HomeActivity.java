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

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    Button buttonMasterKaryawan, buttonAbsen, buttonNotification, buttonEditProfile, buttonLogout;
    TextView signedin_username, signedin_userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
        signedin_userid.setText(currentUser.getUid());
        signedin_username.setText(currentUser.getDisplayName());


        //Jika buttonMasterKaryawan diklik:
        buttonMasterKaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MasterKaryawanActivity.class);
                startActivity(intent);
            }
        });

        //Jika buttonAbsen diklik:
        buttonAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AbsenActivity.class);
                startActivity(intent);
            }
        });

        //Jika buttonNotification diklik:
        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        //Jika buttonEditProfile diklik:
        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });


        //Jika buttonLogout diklik:
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance()
                        .signOut(HomeActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    startActivity(
                                            new Intent(HomeActivity.this, MainActivity.class)
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
