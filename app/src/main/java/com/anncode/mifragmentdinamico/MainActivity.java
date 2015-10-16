package com.anncode.mifragmentdinamico;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.conn.params.ConnPerRoute;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persona[] personas = {
                new Persona("Anahi Salgado", "55555-7777", "@anncode", "anahi.anndroid@gmail.com", "http://icons.iconarchive.com/icons/creativeflip/starwars-longshadow-flat/128/Leia-icon.png"),
                new Persona("Valentin Geovani", "9999-2222", "@valentin", "valentin@gmail.com", "http://icons.iconarchive.com/icons/creativeflip/starwars-longshadow-flat/128/C3PO-icon.png"),
                new Persona("Isaac Octavio", "7777-1111", "@isaac", "isaac@gmail.com", "http://icons.iconarchive.com/icons/creativeflip/starwars-longshadow-flat/128/R2D2-icon.png"),
                new Persona("Enrique Aguilar", "4444-3333", "@enrique", "enrique@gmail.com", "http://icons.iconarchive.com/icons/creativeflip/starwars-longshadow-flat/128/Darth-Vader-icon.png"),
                new Persona("Rubén Urrutia", "2222-8888", "@ruben", "ruben@gmail.com", "http://icons.iconarchive.com/icons/creativeflip/starwars-longshadow-flat/128/Yoda-icon.png")
        };

        final ListView lstLista = (ListView) findViewById(R.id.lstLista);
        lstLista.setAdapter(new ItemAdaptador(this, R.layout.item_lista_layout, personas));
        lstLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Persona persona = (Persona) lstLista.getAdapter().getItem(position);

                TextView tvDetalleNombre    = (TextView) findViewById(R.id.tvDetalleNombre);
                TextView tvDetalleTelefono  = (TextView) findViewById(R.id.tvDetalleTelefono);
                TextView tvDetalleCorreo    = (TextView) findViewById(R.id.tvDetalleCorreo);
                TextView tvDetalleTwitter   = (TextView) findViewById(R.id.tvDetalleTwitter);
                ImageView imgFotoDetalle    = (ImageView) findViewById(R.id.imgFotoDetalle);
                HashMap<String, ImageView> urlImagenView = new HashMap<String, ImageView>();
                urlImagenView.put(persona.getFoto(), imgFotoDetalle);
                new DescargaImagen().execute(urlImagenView);

                tvDetalleNombre     .setText(persona.getNombre());
                tvDetalleTelefono   .setText(persona.getTelefono());
                tvDetalleCorreo     .setText(persona.getCorreo());
                tvDetalleTwitter    .setText(persona.getTwitter());

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
