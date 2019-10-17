package com.deiviherrera.applistapokemon;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.deiviherrera.applistapokemon.Adapter.PokemonAdapter;
import com.deiviherrera.applistapokemon.Model.PokemonModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //paso10
    private RecyclerView recyclerViewPokemon;
    private String url = "https://pokeapi.co/api/v2/pokemon/";
    private boolean carga;
    private String necturl;
    private PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //paso11
        adapter = new PokemonAdapter(this);
        recyclerViewPokemon = findViewById(R.id.rvPokemon);
    }

    //paso12
    @Override
    protected void onStart(){
        super.onStart();
        recyclerViewPokemon.setAdapter(adapter);
        recyclerViewPokemon.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        recyclerViewPokemon.setHasFixedSize(true);
        recyclerViewPokemon.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0){
                    int itemsVisibles = recyclerViewPokemon.getLayoutManager().getChildCount();
                    int itemstotal = recyclerViewPokemon.getLayoutManager().getItemCount();
                    int primerIetemVisible = ((GridLayoutManager)recyclerViewPokemon.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                    if (carga){
                        if (itemsVisibles+primerIetemVisible>=itemstotal){
                            carga=false;
                            getObtenerPokemon(necturl);
                        }
                    }
                }
            }
        });
        getObtenerPokemon(url);
    }

    //paso13
     public void getObtenerPokemon(String urll){
         RequestQueue requestQueue= Volley.newRequestQueue(this);
         JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                 Request.Method.GET, urll, null,
                 new Response.Listener<JSONObject>() {
                     @Override
                     public void onResponse(JSONObject response) {
                         try {
                             necturl = response.getString("next");
                             JSONArray jsonArray = response.getJSONArray("results");
                             if(jsonArray.length() > 0){
                                 ArrayList<PokemonModel> list = new ArrayList<>();
                                 carga = true;
                                 final String url,nombre;
                                 for (int i=0;i < jsonArray.length();i++){
                                     JSONObject jsonObject = jsonArray.getJSONObject(i);
                                     final PokemonModel nuevoPokemon = new PokemonModel(
                                             jsonObject.getString("name"),
                                             jsonObject.getString("url")
                                     );
                                     list.add(nuevoPokemon);
                                 }
                                 adapter.agegarLista(list);
                             }


                         }catch (Exception e){
                             carga = false;
                         }
                     }
                 },
                 new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {

                     }
                 }
         );

         requestQueue.add(jsonObjectRequest);
     }
}
