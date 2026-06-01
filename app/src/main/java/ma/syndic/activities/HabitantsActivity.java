package ma.syndic.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import ma.syndic.R;
import ma.syndic.adapters.HabitantAdapter;
import ma.syndic.model.Habitant;

public class HabitantsActivity extends AppCompatActivity {

    private final List<Habitant> habitants = new ArrayList<>();
    private HabitantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitants);

        RecyclerView rv = findViewById(R.id.recycler_habitants);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HabitantAdapter(habitants);
        rv.setAdapter(adapter);

        FirebaseFirestore.getInstance().collection("habitants")
                .addSnapshotListener((snap, e) -> {
                    if (snap == null) return;
                    habitants.clear();
                    snap.forEach(doc -> {
                        Habitant h = doc.toObject(Habitant.class);
                        h.setId(doc.getId());
                        habitants.add(h);
                    });
                    adapter.notifyDataSetChanged();
                });
    }
}
