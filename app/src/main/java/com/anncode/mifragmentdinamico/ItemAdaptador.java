package com.anncode.mifragmentdinamico;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.Image;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by anahisalgado on 07/10/15.
 */
public class ItemAdaptador extends ArrayAdapter<Persona> {

    Context context;
    Persona[] personas;
    int resource;


    public ItemAdaptador(Context context, int resource, Persona[] personas) {
        super(context, resource, personas);
        this.context    = context;
        this.resource   = resource;
        this.personas   = personas;
    }

    ImageView imgFoto;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View v = inflater.inflate(resource, null);

        imgFoto   = (ImageView) v.findViewById(R.id.imgFoto);
        HashMap<String, ImageView> urlImagenView = new HashMap<>();
        urlImagenView.put(personas[position].getFoto(), imgFoto);
        new DescargaImagen().execute(urlImagenView);

        TextView tvNombre   = (TextView) v.findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView) v.findViewById(R.id.tvTelefono);

        tvNombre.setText(personas[position].getNombre());
        tvTelefono.setText(personas[position].getTelefono());

        return v;
    }








}
