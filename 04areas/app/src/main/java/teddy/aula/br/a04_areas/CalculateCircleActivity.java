package teddy.aula.br.a04_areas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_circle);
    }

    public void onClickCalculateCircle (View v)
    {
        EditText etRadius = findViewById(R.id.etRadius);

        try
        {
            double radiusD = Double.parseDouble(etRadius.getText().toString());

            Intent intentOpenScreenResultCircle = new Intent(this.getApplicationContext(),CircleResultActivity.class);

            intentOpenScreenResultCircle.putExtra("radiusD",radiusD );

            this.startActivity(intentOpenScreenResultCircle);
        }
        catch (Exception e)
        {
            Toast.makeText(this.getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            String string = getString(R.string.errorR);
            etRadius.setError(string);
        }
    }
}
