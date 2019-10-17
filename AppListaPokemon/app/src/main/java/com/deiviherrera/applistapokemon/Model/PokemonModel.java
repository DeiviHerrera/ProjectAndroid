package com.deiviherrera.applistapokemon.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class PokemonModel implements Parcelable {
    private int id;
    private String nombre;
    private String url;

    public PokemonModel() {
    }

    public PokemonModel(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    protected PokemonModel(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        url = in.readString();
    }

    public static final Creator<PokemonModel> CREATOR = new Creator<PokemonModel>() {
        @Override
        public PokemonModel createFromParcel(Parcel in) {
            return new PokemonModel(in);
        }

        @Override
        public PokemonModel[] newArray(int size) {
            return new PokemonModel[size];
        }
    };

    public int getId() {
        ////paso13
        String[] arrayurl = url.split("/");
        id = Integer.parseInt(arrayurl[arrayurl.length-1]);
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(url);
    }
}
