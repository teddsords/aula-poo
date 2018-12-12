package teddy.aula.br.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    public static final int ADD_FILLUP = 1312;
    private listAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView rvFillUpList = findViewById(R.id.rvLista);

        this.adapter = new listAdapter();
        this.adapter.list = FillUpDAO.getList(this.getApplicationContext());


        rvFillUpList.setAdapter(this.adapter);
        rvFillUpList.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }
    @Override
     public void onResume()
    {
        super.onResume();
        RecyclerView rvFillUpList = findViewById(R.id.rvLista);

        this.adapter = new listAdapter();
        this.adapter.list = FillUpDAO.getList(this.getApplicationContext());


        rvFillUpList.setAdapter(this.adapter);
        rvFillUpList.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }
    public void onClickFAB (View v)
    {
        Intent intent = new Intent(this.getApplicationContext(), AddFillUpActivity.class);
        if(this.adapter.list.size()>0)
            intent.putExtra("Old km", this.adapter.list.get(this.adapter.list.size()-1).getKilometers());
        startActivityForResult(intent, ADD_FILLUP);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_FILLUP){
            if(resultCode == 1){
                this.adapter.notifyDataSetChanged();
            }else{
                Toast.makeText(this.getApplicationContext(), "Ahm what?", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this.getApplicationContext(), "F*cked up", Toast.LENGTH_SHORT).show();
        }
    }

}
