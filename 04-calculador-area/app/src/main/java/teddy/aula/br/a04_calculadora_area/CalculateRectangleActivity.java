package teddy.aula.br.a04_calculadora_area;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateRectangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_rectangle);
    }

    public void onClickCalculateRectangle (View v)
    {
        EditText etLength = findViewById(R.id.etLengthRectangle);
        EditText etWidth = findViewById(R.id.etWidthRectangle);

        try
        {
            double lengthD = Double.parseDouble(etLength.getText().toString());
            double widthD = Double.parseDouble(etWidth.getText().toString());

            Intent intentOpenScreenResultRectangle = new Intent(this.getApplicationContext(),RectangleResultActivity.class);

            intentOpenScreenResultRectangle.putExtra("lengthD",lengthD );
            intentOpenScreenResultRectangle.putExtra("widthD",widthD );

            this.startActivity(intentOpenScreenResultRectangle);
        }
        catch (Exception e)
        {
            Toast.makeText(this.getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            String string = getString(R.string.errorL);
            etLength.setError(string);
            string = getString(R.string.errorW);
            etWidth.setError(string);
        }

    }

}