package teddy.aula.br.a05_controle_abastecimento;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FillUpDetailedActivity extends AppCompatActivity {

    private FillUp Shown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_up_detailed);

    this.Shown = (FillUp)getIntent().getSerializableExtra("fillup");

        if (this.Shown != null)
        {
            ImageView ivGasSation = findViewById(R.id.ivPostoDetalhe);
            TextView tvNomePostoDetalhe = findViewById(R.id.tvNomePostoDetalhe2);
            TextView tvKilometrajeDetalhe = findViewById(R.id.tvKilometrajeDetalhe2);
            TextView tvDateDetalhe = findViewById(R.id.tvDateDetalhe2);
            TextView tvLitrosDetalhe = findViewById(R.id.tvLitrosDetalhe2);
            TextView tvLongitudDetalhe = findViewById(R.id.tvLongitudDetalhe2);
            TextView tvLatitudDetalhe = findViewById(R.id.tvLatitudDetalhe2);

            tvDateDetalhe.setText(this.Shown.getDate());
            tvNomePostoDetalhe.setText(this.Shown.getGasStation());
            tvKilometrajeDetalhe.setText(Double.toString(this.Shown.getKilometers()));
            tvLitrosDetalhe.setText(Double.toString(this.Shown.getLiters()));
            tvLongitudDetalhe.setText(Double.toString(this.Shown.getLongitude()));
            tvLatitudDetalhe.setText(Double.toString(this.Shown.getLatitude()));

            if (this.Shown.getGasStation().equals("Petrobras") )
                ivGasSation.setImageResource(R.drawable.petrobras);
            else if (this.Shown.getGasStation().equals("Ipiranga"))
                ivGasSation.setImageResource(R.drawable.ipiranga);
            else if (this.Shown.getGasStation().equals("Shell"))
                ivGasSation.setImageResource(R.drawable.shell);
            else
                ivGasSation.setImageResource(R.drawable.texaco);
        }
    }
    public void onClickViewInMap(View v)
    {
        Intent openMap = new Intent(v.getContext(), MapsActivity.class);
        openMap.putExtra("fillup", this.Shown);
        startActivity(openMap);

    }
}
