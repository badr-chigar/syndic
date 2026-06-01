package ma.syndic.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ma.syndic.R;
import ma.syndic.model.Paiement;

public class PaiementAdapter extends RecyclerView.Adapter<PaiementAdapter.VH> {

    public interface OnToggle { void toggle(Paiement p); }

    private final List<Paiement> items;
    private final OnToggle onToggle;
    public PaiementAdapter(List<Paiement> items, OnToggle onToggle) {
        this.items = items; this.onToggle = onToggle;
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_paiement, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Paiement p = items.get(position);
        h.appartement.setText("Appt " + p.getAppartement());
        h.mois.setText(p.getMois());
        h.montant.setText(String.format("%.0f MAD", p.getMontant()));
        h.statut.setText(p.isPaye() ? "Payé" : "En attente");
        h.statut.setBackgroundResource(p.isPaye() ? R.drawable.badge_ok : R.drawable.badge_warn);
        h.itemView.setOnClickListener(v -> onToggle.toggle(p));
    }

    @Override public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView appartement, mois, montant, statut;
        VH(@NonNull View v) {
            super(v);
            appartement = v.findViewById(R.id.p_appartement);
            mois = v.findViewById(R.id.p_mois);
            montant = v.findViewById(R.id.p_montant);
            statut = v.findViewById(R.id.p_statut);
        }
    }
}
