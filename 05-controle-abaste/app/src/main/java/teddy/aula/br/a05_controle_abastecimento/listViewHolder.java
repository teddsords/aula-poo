package teddy.aula.br.a05_controle_abastecimento;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.RecyclerView;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class listViewHolder extends RecyclerView.ViewHolder {

    private TextView tvKilometers;
    private TextView tvDate;
    private TextView tvLiters;
    private ImageView ivGasStation;
    private FillUp fillUpShown;

    public listViewHolder (@NonNull View viewItem)
    {
        super (viewItem);

        viewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent openEdit = new Intent(v.getContext(), FillUpDetailedActivity.class);
                openEdit.putExtra("fillup",listViewHolder.this.fillUpShown);
                ((ListActivity)v.getContext()).startActivityForResult(openEdit, ListActivity.ADD_FILLUP);
            }
        });

        viewItem.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Delete")
                        .setMessage("Hello")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
                return false;
            }
        });
        this.tvDate = itemView.findViewById(R.id.tvDate);
        this.tvKilometers = itemView.findViewById(R.id.tvKilometers);
        this.tvLiters = itemView.findViewById(R.id.tvLiters);
        this.ivGasStation = itemView.findViewById(R.id.ivGasStation);
    }

    public void updateDrawer (FillUp fillUp)
    {
        this.fillUpShown = fillUp;
        String kilometers = String.valueOf(fillUp.getKilometers()) + " Kms";
        String liters = String.valueOf(fillUp.getLiters()) + " L";
        String gasStation = fillUp.getGasStation();
        String date = this.tvDate.getContext().getString(R.string.Date, fillUp.getDate());

        this.tvLiters.setText(liters);
        this.tvKilometers.setText(kilometers);
        this.tvDate.setText(date);


        if (gasStation.equals("Ipiranga"))
            ivGasStation.setImageResource(R.drawable.ipiranga);
        else if (gasStation.equals("Petrobras"))
            ivGasStation.setImageResource(R.drawable.petrobras);
        else if (gasStation.equals("Shell"))
            ivGasStation.setImageResource(R.drawable.shell);

        else
            ivGasStation.setImageResource(R.drawable.texaco);
    }
}
