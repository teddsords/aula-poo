package teddy.aula.br.a05_controle_abastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter {

    public ArrayList<FillUp> list;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View dadElement = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.abastecimento_item, viewGroup, false);
        listViewHolder drawer = new listViewHolder(dadElement);
        return drawer;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        listViewHolder drawer =(listViewHolder) viewHolder;
        FillUp fillUp = list.get(i);
        drawer.updateDrawer(fillUp);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
