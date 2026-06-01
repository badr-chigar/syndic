package ma.syndic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import ma.syndic.R;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText emailField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.btn_login);
        TextView signupLink = findViewById(R.id.link_signup);

        loginBtn.setOnClickListener(v -> connecter());
        signupLink.setOnClickListener(v -> inscrire());
    }

    private void connecter() {
        String email = emailField.getText().toString().trim();
        String pwd = passwordField.getText().toString().trim();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(email, pwd)
                .addOnSuccessListener(r -> ouvrirDashboard())
                .addOnFailureListener(e ->
                        Toast.makeText(this, "Échec : " + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    private void inscrire() {
        String email = emailField.getText().toString().trim();
        String pwd = passwordField.getText().toString().trim();
        if (TextUtils.isEmpty(email) || pwd.length() < 6) {
            Toast.makeText(this, "Mot de passe : 6 caractères minimum", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.createUserWithEmailAndPassword(email, pwd)
                .addOnSuccessListener(r -> ouvrirDashboard())
                .addOnFailureListener(e ->
                        Toast.makeText(this, "Échec : " + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    private void ouvrirDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }
}
