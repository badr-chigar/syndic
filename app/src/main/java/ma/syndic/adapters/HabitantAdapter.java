package ma.syndic.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ma.syndic.R;
import ma.syndic.model.Habitant;

public class HabitantAdapter extends RecyclerView.Adapter<HabitantAdapter.VH> {

    private final List<Habitant> items;
    public HabitantAdapter(List<Habitant> items) { this.items = items; }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_habitant, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Habitant it = items.get(position);
        h.nom.setText(it.getNom());
        h.appartement.setText("Appt " + it.getAppartement());
        h.role.setText(it.isProprietaire() ? "Propriétaire" : "Locataire");
        h.initiale.setText(it.getNom().isEmpty() ? "?" : it.getNom().substring(0, 1).toUpperCase());
    }

    @Override public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView nom, appartement, role, initiale;
        VH(@NonNull View v) {
            super(v);
            nom = v.findViewById(R.id.h_nom);
            appartement = v.findViewById(R.id.h_appartement);
            role = v.findViewById(R.id.h_role);
            initiale = v.findViewById(R.id.h_initiale);
        }
    }
}
