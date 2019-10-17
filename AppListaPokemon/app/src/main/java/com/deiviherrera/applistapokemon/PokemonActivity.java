package com.deiviherrera.applistapokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.deiviherrera.applistapokemon.Model.PokemonModel;

public class PokemonActivity extends AppCompatActivity {
    //paso14
    private ImageView imgPokemon;
    private TextView tvPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        imgPokemon = findViewById(R.id.imgPokemon);
        tvPokemon = findViewById(R.id.tvPokemon);
    }

    protected void onStart(){
        super.onStart();

        PokemonModel objPokemon = getIntent().getParcelableExtra("pokemon");
        tvPokemon.setText(objPokemon.getNombre());
        Glide.with(this).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+objPokemon.getId()+".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgPokemon);
    }
}
