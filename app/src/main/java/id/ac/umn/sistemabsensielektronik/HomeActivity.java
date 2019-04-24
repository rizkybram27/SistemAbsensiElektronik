package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    private static int REQUEST_CODE=0x1;

    Button buttonMasterKaryawan, buttonAbsen, buttonNotification, buttonEditProfile, buttonLogout;
    TextView textUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Deklarasi function buttons:
        buttonMasterKaryawan = findViewById(R.id.buttonMasterKaryawan);
        buttonAbsen = findViewById(R.id.buttonAbsen);
        buttonNotification = findViewById(R.id.buttonNotification);
        buttonEditProfile = findViewById(R.id.buttonEditProfile);
        buttonLogout = findViewById(R.id.buttonLogout);

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME);
        TextView textUsername = findViewById(R.id.textUsername);
        textUsername.setText(username);

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
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                setResult(REQUEST_CODE, intent);
                finish();
            }
        });
    }
}
