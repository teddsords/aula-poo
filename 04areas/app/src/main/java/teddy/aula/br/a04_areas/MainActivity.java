package teddy.aula.br.a04_areas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }

    public void clickRectangle(View v)
    {
        Intent intentOpenScreenRectangle = new Intent(this.getApplicationContext(), CalculateRectangleActivity.class);
        this.startActivity(intentOpenScreenRectangle);
    }
    public void clickTriangle(View v)
    {
        Intent intentOpenScreenTriangle = new Intent(this.getApplicationContext(), CalculateTriangleActivity.class);
        this.startActivity(intentOpenScreenTriangle);
    }
    public void clickCircle(View v)
    {
        Intent intentOpenScreenCircle = new Intent(this.getApplicationContext(), CalculateCircleActivity.class);
        this.startActivity(intentOpenScreenCircle);
    }
}
