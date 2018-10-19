package teddy.aula.br.a04_calculadora_area;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TriangleResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_result);

        double height = this.getIntent().getDoubleExtra("heightD", -1);
        double base = this.getIntent().getDoubleExtra("baseD", -1);

        if (base == -1 && height == -1)
            Toast.makeText(this.getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

        else
        {
            double area = (base * height) / 2;
            TextView tvResult = findViewById(R.id.tvTriangleResult);
            NumberFormat nF = DecimalFormat.getInstance();
            nF.setMaximumFractionDigits(2);
            String string = getString(R.string.squaremetre);
            String finalAnswer = nF.format(area) + " " + string;
            tvResult.setText(finalAnswer);
        }
    }

    public void onClickTriangleFinish (View v)
    {
        Intent intentTriangleOpenScreenMainActivity = new Intent(this.getApplicationContext(), MainActivity.class);
        intentTriangleOpenScreenMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intentTriangleOpenScreenMainActivity);
        finish();
    }
}
