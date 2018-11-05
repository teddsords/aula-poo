package teddy.aula.br.a05_controle_abastecimento;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class listViewHolder extends RecyclerView.ViewHolder {

    private TextView tvKilometers;
    private TextView tvDate;
    private TextView tvLiters;
    private ImageView ivGasStation;

    public listViewHolder (@NonNull View viewItem)
    {
        super (viewItem);
        this.tvDate = itemView.findViewById(R.id.tvDate);
        this.tvKilometers = itemView.findViewById(R.id.tvKilometers);
        this.tvLiters = itemView.findViewById(R.id.tvLiters);
        this.ivGasStation = itemView.findViewById(R.id.ivGasStation);
    }

    public void updateDrawer (FillUp fillUp)
    {
        String kilometers = String.valueOf(fillUp.getKilometers()) + " Kms";
        String liters = String.valueOf(fillUp.getLiters()) + "L";
        String gasStation = fillUp.getGasStation();

        this.tvLiters.setText(liters);
        this.tvKilometers.setText(kilometers);
        this.tvDate.setText(fillUp.getDate());

        if (gasStation.equals("Ipiranga"))
            ivGasStation.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.ipiranga));
        else if (gasStation.equals("Petrobras"))
            ivGasStation.setImageDrawable(ContextCompat.getDrawable(App.getContext(),R.drawable.petrobras));
        else if (gasStation.equals("Shell"))
            ivGasStation.setImageDrawable(ContextCompat.getDrawable(App.getContext(),R.drawable.shell));
        else
            ivGasStation.setImageDrawable(ContextCompat.getDrawable(App.getContext(),R.drawable.texaco));
    }
}
