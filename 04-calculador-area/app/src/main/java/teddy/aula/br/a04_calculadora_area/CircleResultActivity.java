package teddy.aula.br.a04_calculadora_area;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.lang.Math;

public class CircleResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_result);

        double radius = this.getIntent().getDoubleExtra("radiusD", -1);

        if (radius == -1)
            Toast.makeText(this.getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

        else
        {
            double area = Math.PI * Math.pow(radius, 2) ;
            TextView tvResult = findViewById(R.id.tvCircleResult);
            NumberFormat nF = DecimalFormat.getInstance();
            nF.setMaximumFractionDigits(2);
            String string = getString(R.string.squaremetre);
            String finalAnswer = nF.format(area) + " " + string;
            tvResult.setText(finalAnswer);
        }
    }

    public void onClickCircleFinish (View v)
    {
        Intent intentCircleOpenScreenMainActivity = new Intent(this.getApplicationContext(), MainActivity.class);
        intentCircleOpenScreenMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intentCircleOpenScreenMainActivity);
        finish();
    }
}