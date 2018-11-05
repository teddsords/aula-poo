package teddy.aula.br.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<FillUp> fillUps = new ArrayList<FillUp>();
        fillUps = FillUpDAO.getList(this.getApplicationContext());
        TextView tvKilometerPerLiter = findViewById(R.id.tvKilometersPerLiter);
        TextView tvResult =findViewById(R.id.tvResult);

        NumberFormat nF = DecimalFormat.getInstance();
        nF.setMaximumFractionDigits(2);

        if (fillUps.size() > 1)
        {
            double liters = 0;
            double fuelEconomy;
            double totalKms;

            totalKms = fillUps.get(fillUps.size()-1).getKilometers() - fillUps.get(0).getKilometers();
            for (int i = 0; i < fillUps.size()-1; i++)
                liters += fillUps.get(i).getLiters();

            fuelEconomy = totalKms / liters;

            tvResult.setText(String.valueOf(nF.format(fuelEconomy)));
            tvResult.setVisibility(View.VISIBLE);
            tvKilometerPerLiter.setVisibility(View.VISIBLE);
        }
        else
        {
            tvResult.setText(getText(R.string.Unavailable));
            tvResult.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onResume ()
    {
        super.onResume();
        setContentView(R.layout.activity_main);
        ArrayList<FillUp> fillUps = new ArrayList<FillUp>();
        fillUps = FillUpDAO.getList(this.getApplicationContext());

        NumberFormat nF = DecimalFormat.getInstance();
        nF.setMaximumFractionDigits(2);

        if (fillUps.size() > 1)
        {
            double liters = 0;
            double fuelEconomy;
            double totalKms;

            totalKms = fillUps.get(fillUps.size()-1).getKilometers() - fillUps.get(0).getKilometers();
            for (int i = 0; i < fillUps.size()-1; i++)
                liters += fillUps.get(i).getLiters();

            fuelEconomy = totalKms / liters;

            TextView tvResult =findViewById(R.id.tvResult);
            tvResult.setText(String.valueOf(nF.format(fuelEconomy)));
            tvResult.setVisibility(View.VISIBLE);

            TextView tvKilometerPerLiter = findViewById(R.id.tvKilometersPerLiter);
            tvKilometerPerLiter.setVisibility(View.VISIBLE);
        }
        else
        {
            TextView tvResult =findViewById(R.id.tvResult);
            tvResult.setText(getString(R.string.Unavailable));
            tvResult.setVisibility(View.VISIBLE);
        }
    }
    public void onClickViewHistory(View v){
            Intent intent = new Intent(this.getApplicationContext(), ListActivity.class);
            startActivity(intent);
    }
}
