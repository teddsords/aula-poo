package teddy.aula.br.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RectangleResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_result);

        double length = this.getIntent().getDoubleExtra("lengthD", -1);
        double width = this.getIntent().getDoubleExtra("widthD", -1);

        if (length == -1 && width == -1)
            Toast.makeText(this.getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

        else
        {
            double area = length * width;
            TextView tvResult = findViewById(R.id.tvRectangleResult);
            NumberFormat nF = DecimalFormat.getInstance();
            nF.setMaximumFractionDigits(2);
            String string = getString(R.string.squaremetre);
            if (area == 1)
                string = getString(R.string.squaremetersingular);

            String finalAnswer = nF.format(area) + " " + string;
            tvResult.setText(finalAnswer);
        }
    }

    public void onClickRectangleFinish (View v)
    {
        Intent intentRectangleOpenScreenMainActivity = new Intent(this.getApplicationContext(), MainActivity.class);
        intentRectangleOpenScreenMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intentRectangleOpenScreenMainActivity);
        finish();
    }
}
