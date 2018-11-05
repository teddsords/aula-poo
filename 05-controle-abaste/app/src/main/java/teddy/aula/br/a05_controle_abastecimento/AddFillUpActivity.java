package teddy.aula.br.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddFillUpActivity extends AppCompatActivity {


    private String[] gasStations = new String[]{"Ipiranga", "Petrobras", "Shell", "Texaco"};
    private Spinner sGasStations;
    private EditText etActualKms;
    private EditText etPurchasedLiters;
    private EditText etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fill_up);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, gasStations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sGasStations = (Spinner) findViewById(R.id.sGasStations);
        sGasStations.setAdapter(adapter);

        etActualKms = findViewById(R.id.etActualKilometers);
        etPurchasedLiters = findViewById(R.id.etLitersBought);
        etDate = findViewById(R.id.etPurchaseDate);
    }

    public void onClickSave(View v)
    {
        FillUp fillUp = new FillUp();

        fillUp.setKilometers(Double.parseDouble(etActualKms.getText().toString()));
        fillUp.setLiters(Double.parseDouble(etPurchasedLiters.getText().toString()));
        fillUp.setDate(etDate.getText().toString());
        fillUp.setGasStation(sGasStations.getSelectedItem().toString());

        boolean save = FillUpDAO.fileSave(this.getApplicationContext(), fillUp);

        if (save)
        {
            setResult(1);
            finish();
        }
        else
        {
            Toast.makeText(this.getApplicationContext(), "Unable to save", Toast.LENGTH_LONG).show();
        }
    }
}
