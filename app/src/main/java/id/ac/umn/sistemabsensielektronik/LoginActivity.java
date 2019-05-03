package id.ac.umn.sistemabsensielektronik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {


    private static int REQUEST_CODE = 101;

    private FirebaseAuth auth;

    private List<AuthUI.IdpConfig> getProviderList() {
        List<AuthUI.IdpConfig> providers = new ArrayList<>();

        providers.add(
                new AuthUI.IdpConfig.EmailBuilder().build()
        );

        return providers;
    }

    private void authenticateUser() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(getProviderList())
                        .setIsSmartLockEnabled(false)
                        .build(),
                REQUEST_CODE
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        } else {
            authenticateUser();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                return;
            }
        }
        else{
            if(response == null){
                return;
            }
            if(response.getError().getErrorCode() == ErrorCodes.NO_NETWORK){
                return;
            }
            if(response.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR){
                return;
            }
        }
    }
}
