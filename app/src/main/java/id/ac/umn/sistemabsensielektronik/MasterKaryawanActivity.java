package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MasterKaryawanActivity extends AppCompatActivity {

    private static int REQUEST_CODE=0x1;
    Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_karyawan);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterKaryawanActivity.this, AddKaryawanActivity.class);
                setResult(REQUEST_CODE, intent);
                finish();
            }
        });
    }
}
