package com.anncode.mifragmentdinamico;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by anahisalgado on 10/10/15.
 */
class DescargaImagen extends AsyncTask<HashMap<String, ImageView>, Void, HashMap<Bitmap, ImageView>> {


    @Override
    protected HashMap<Bitmap, ImageView> doInBackground(HashMap<String, ImageView>... urlImagenView) {
        // lo que se ejecuta en background

        URL imageUrl = null;
        HttpURLConnection conn = null;
        String url = "";
        ImageView imgFoto = null;

        //Obtener url y view
        // Get a set of the entries
        Set set = urlImagenView[0].entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            url = me.getKey().toString();
            imgFoto = (ImageView) me.getValue();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }


        Bitmap imagen = null;
        try {

            imageUrl = new URL(url);
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();

            BitmapFactory.Options options = new BitmapFactory.Options();
            //options.inSampleSize = 2; // el factor de escala a minimizar la imagen, siempre es potencia de 2

            imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);


        } catch (IOException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();

        }

        HashMap<Bitmap, ImageView> imagenBitmapView = new HashMap<>();
        imagenBitmapView.put(imagen, imgFoto);
        return imagenBitmapView;

    }


    @Override
    protected void onPostExecute(HashMap<Bitmap, ImageView> imagenBitmapView) {
        super.onPostExecute(imagenBitmapView);
        // el callback cuando terminó de ejecutarse el background
        Bitmap bitmap = null;
        ImageView imgFoto = null;
        //Obtener bitmap y imagenView
        // Get a set of the entries
        Set set = imagenBitmapView.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            bitmap = (Bitmap) me.getKey();
            imgFoto = (ImageView) me.getValue();

        }

        imgFoto.setImageBitmap(bitmap);
    }
}
