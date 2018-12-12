package teddy.aula.br.a05_controle_abastecimento;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddFillUpActivity extends AppCompatActivity {

    private Spinner sGasStations;
    private EditText etActualKms;
    private EditText etPurchasedLiters;
    private EditText etDate;
    private double oldKm;
    private FillUp fillUpToSave = new FillUp();
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fill_up);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.GasStations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sGasStations = (Spinner) findViewById(R.id.sGasStations);
        sGasStations.setAdapter(adapter);

        etActualKms = findViewById(R.id.etActualKilometers);
        etPurchasedLiters = findViewById(R.id.etLitersBought);
        etDate = findViewById(R.id.etPurchaseDate);

        oldKm = this.getIntent().getDoubleExtra("Old km", -1);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        getLocation(fillUpToSave);
    }

    @Override
    public void onRequestPermissionsResult (int requestCode, String permisions[], int[] grantResults)
    {
        switch (requestCode)
        {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    getLocation(fillUpToSave);
                else
                    Toast.makeText(this, "Ja era", Toast.LENGTH_LONG).show();
                return;
        }
    }

    public void getLocation (final FillUp fillUp)
    {
        try
        {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            LocationListener locationListener =  new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                    fillUpToSave.setLatitude(location.getLatitude());
                    Log.d("Latitude", Double.toString(fillUpToSave.getLatitude()));
                    fillUpToSave.setLongitude(location.getLongitude());
                    Log.d("Longitude", Double.toString(fillUpToSave.getLongitude()));

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {}

                @Override
                public void onProviderEnabled(String provider) {}

                @Override
                public void onProviderDisabled(String provider) {}
            };
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        catch (SecurityException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void onClickSave(View v)
    {

        if (etActualKms.getText().toString().equals("") || etPurchasedLiters.getText().toString().equals("") || etDate.getText().toString().equals(""))
        {
            if(etActualKms.getText().toString().equals(""))
                this.etActualKms.setError(getString(R.string.error_kilometers));

            if (etPurchasedLiters.getText().toString().equals(""))
                this.etPurchasedLiters.setError(getString(R.string.error_liter));
            if (etDate.getText().toString().equals(""))
                this.etDate.setError(getString(R.string.error_date));

            return;
        }
        if (Double.parseDouble(etActualKms.getText().toString()) < oldKm)
        {
            etActualKms.setError(getString(R.string.Error));
            return;
        }
        getLocation(fillUpToSave);

        fillUpToSave.setKilometers(Double.parseDouble(etActualKms.getText().toString()));
        fillUpToSave.setLiters(Double.parseDouble(etPurchasedLiters.getText().toString()));
        fillUpToSave.setDate(etDate.getText().toString());
        fillUpToSave.setGasStation(sGasStations.getSelectedItem().toString());

        boolean save = FillUpDAO.save(this.getApplicationContext(), fillUpToSave);

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