package ma.syndic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.firestore.FirebaseFirestore;

import ma.syndic.R;

public class DashboardActivity extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        db = FirebaseFirestore.getInstance();
        TextView nbAppartements = findViewById(R.id.kpi_appartements);
        TextView tauxPaiement = findViewById(R.id.kpi_paiement);

        // Lecture temps réel des compteurs depuis Firestore
        db.collection("appartements").addSnapshotListener((snap, e) -> {
            if (snap != null) nbAppartements.setText(String.valueOf(snap.size()));
        });
        db.collection("paiements").addSnapshotListener((snap, e) -> {
            if (snap != null && snap.size() > 0) {
                long payes = snap.getDocuments().stream()
                        .filter(d -> Boolean.TRUE.equals(d.getBoolean("paye"))).count();
                int taux = (int) Math.round(payes * 100.0 / snap.size());
                tauxPaiement.setText(taux + " %");
            }
        });

        CardView cardHabitants = findViewById(R.id.card_habitants);
        CardView cardPaiements = findViewById(R.id.card_paiements);
        cardHabitants.setOnClickListener(v ->
                startActivity(new Intent(this, HabitantsActivity.class)));
        cardPaiements.setOnClickListener(v ->
                startActivity(new Intent(this, PaiementsActivity.class)));
    }
}
