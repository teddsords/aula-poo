package teddy.aula.br.a04_calculadora_area;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateTriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_triangle);
    }

    public void onClickCalculateTriangle (View v)
    {
        EditText etHeight = findViewById(R.id.etHeightTriangle);
        EditText etBase = findViewById(R.id.etBaseTriangle);

        try
        {
            double heightD = Double.parseDouble(etHeight.getText().toString());
            double baseD = Double.parseDouble(etBase.getText().toString());

            Intent intentOpenScreenResultTriangle = new Intent(this.getApplicationContext(), TriangleResultActivity.class);

            intentOpenScreenResultTriangle.putExtra("heightD" , heightD);
            intentOpenScreenResultTriangle.putExtra("baseD" , baseD);

            this.startActivity(intentOpenScreenResultTriangle);
        }
        catch (Exception e)
        {
            Toast.makeText(this.getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            String string = getString(R.string.errorH);
            etHeight.setError(string);
            string = getString(R.string.errorB);
            etBase.setError(string);
        }
    }
}
