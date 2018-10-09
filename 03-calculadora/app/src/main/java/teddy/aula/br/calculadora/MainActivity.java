package teddy.aula.br.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Calculate (View clickedElement)
    {
        EditText length = findViewById(R.id.etLength);
        EditText height = findViewById(R.id.etHeight);
        EditText width = findViewById(R.id.etWidth);
        TextView volume = findViewById(R.id.tvAnswer);
        Button bCalculate = findViewById(R.id.bCalculate);
        Button bReset = findViewById(R.id.bReset);

        if (length.getText().toString().equals("")  || height.getText().toString().equals("") || width.getText().toString().equals(""))
        {
            length.setError("Please inform the length");
            height.setError("Please inform the height");
            width.setError("Please inform the width");
            return;
        }

        try{
            float lengthFloat = Float.parseFloat(length.getText().toString());
            float heigthFloat = Float.parseFloat(height.getText().toString());
            float widthFloat = Float.parseFloat(width.getText().toString());

            float volumeFloat = lengthFloat*widthFloat*heigthFloat;
            String string1, string2;

            string1 = getString(R.string.Volume);
            string2 = getString(R.string.Meter);

            volume.setText(string1 + ": "  + volumeFloat + " "+ string2);
            volume.setVisibility(View.VISIBLE);
        }catch (Exception e)
        {
            Toast errou = Toast.makeText(this, "Ihh Rapaz", Toast.LENGTH_LONG);
            errou.show();

        }
        bCalculate.setVisibility(View.INVISIBLE);
        bReset.setVisibility(View.VISIBLE);
    }

    public void reset (View clickedElement)
    {
        EditText length = findViewById(R.id.etLength);
        EditText height = findViewById(R.id.etHeight);
        EditText width = findViewById(R.id.etWidth);
        TextView volume = findViewById(R.id.tvAnswer);
        Button bCalculate = findViewById(R.id.bCalculate);
        Button bReset = findViewById(R.id.bReset);

        length.setText("");
        height.setText("");
        width.setText("");
        volume.setText("");

        volume.setVisibility(View.INVISIBLE);

        bCalculate.setVisibility(View.VISIBLE);
        bReset.setVisibility(View.INVISIBLE);

    }
}
