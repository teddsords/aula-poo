package teddy.aula.br.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

            volume.setText("Volume: " + volumeFloat + " Squared meter");
            volume.setVisibility(View.VISIBLE);
        }catch (Exception e)
        {
            Toast errou = Toast.makeText(this, "Ihh Rapaz", Toast.LENGTH_LONG);
            errou.show();

        }

    }
}
