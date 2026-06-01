package ma.syndic.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import ma.syndic.R;
import ma.syndic.adapters.PaiementAdapter;
import ma.syndic.model.Paiement;

public class PaiementsActivity extends AppCompatActivity {

    private final List<Paiement> paiements = new ArrayList<>();
    private PaiementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiements);

        RecyclerView rv = findViewById(R.id.recycler_paiements);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PaiementAdapter(paiements, this::basculerStatut);
        rv.setAdapter(adapter);

        FirebaseFirestore.getInstance().collection("paiements")
                .addSnapshotListener((snap, e) -> {
                    if (snap == null) return;
                    paiements.clear();
                    snap.forEach(doc -> {
                        Paiement p = doc.toObject(Paiement.class);
                        p.setId(doc.getId());
                        paiements.add(p);
                    });
                    adapter.notifyDataSetChanged();
                });
    }

    /** Marque une cotisation comme payée dans Firestore. */
    private void basculerStatut(Paiement p) {
        FirebaseFirestore.getInstance().collection("paiements")
                .document(p.getId()).update("paye", !p.isPaye());
    }
}
