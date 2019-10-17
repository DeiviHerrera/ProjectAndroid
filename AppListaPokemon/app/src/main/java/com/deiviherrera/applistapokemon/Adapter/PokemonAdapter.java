package com.deiviherrera.applistapokemon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.deiviherrera.applistapokemon.Model.PokemonModel;
import com.deiviherrera.applistapokemon.PokemonActivity;
import com.deiviherrera.applistapokemon.R;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    //paso1 programacion
    private Context context;
    private ArrayList<PokemonModel> lista;

    //paso 2
    public PokemonAdapter(Context context){
        this.context=context;
        lista=new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //paso3
        View view = LayoutInflater.from(context).inflate(R.layout.item_pokemon, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //paso8
        viewHolder.getItems(lista.get(i));
    }

    @Override
    public int getItemCount() {
        //paso4
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //paso 5
        private ImageView imgItem;
        private TextView tvItemPokemon;
        private CardView cardContenedor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //paso6
            imgItem = itemView.findViewById(R.id.imgItemPokemon);
            tvItemPokemon = itemView.findViewById(R.id.tvItemPokemon);
            cardContenedor = itemView.findViewById(R.id.contenedor);
        }
        //paso7
        public void getItems(final PokemonModel pokemonModel){
            Glide.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokemonModel.getId()+".png").centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(imgItem);
            tvItemPokemon.setText(pokemonModel.getNombre());
            cardContenedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PokemonActivity.class);
                    intent.putExtra("pokemon",pokemonModel);
                    context.startActivity(intent);
                }
            });

        }


        }
    //paso9
    public void agegarLista(ArrayList<PokemonModel> dada){
        lista.addAll(dada);
        notifyDataSetChanged();
    }
}
