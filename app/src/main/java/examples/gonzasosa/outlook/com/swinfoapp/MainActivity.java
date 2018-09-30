package examples.gonzasosa.outlook.com.swinfoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import examples.gonzasosa.outlook.com.swinfoapp.Fragments.FilmFragment;
import examples.gonzasosa.outlook.com.swinfoapp.Fragments.ShipsFragment;
import examples.gonzasosa.outlook.com.swinfoapp.Fragments.SpeciesFragment;
import examples.gonzasosa.outlook.com.swinfoapp.Fragments.VehicleFragment;

public class MainActivity extends AppCompatActivity {
    public final static String clave = "contenido";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);
        RelativeLayout r1 = findViewById(R.id.planetas);
        RelativeLayout r2 = findViewById(R.id.personajes);
        RelativeLayout r3 = findViewById(R.id.naves);
        RelativeLayout r4 = findViewById(R.id.peliculas);
        RelativeLayout r5 = findViewById(R.id.vehiculos);
        RelativeLayout r6 = findViewById(R.id.especies);

        r1.setOnClickListener((view)->{
            Intent nuevo = new Intent(this,Main2Activity.class);
            nuevo.putExtra(clave,1);
            startActivity(nuevo);
        });
        r2.setOnClickListener((view)->{
            Intent nuevo = new Intent(this,Main2Activity.class);
            nuevo.putExtra(clave,2);
            startActivity(nuevo);
        });
        r3.setOnClickListener((view)->{
            Intent nuevo = new Intent(this,Main2Activity.class);
            nuevo.putExtra(clave,3);
            startActivity(nuevo);
        });
        r4.setOnClickListener((view)->{
            Intent nuevo = new Intent(this,Main2Activity.class);
            nuevo.putExtra(clave,4);
            startActivity(nuevo);
        });
        r5.setOnClickListener((view)->{
            Intent nuevo = new Intent(this,Main2Activity.class);
            nuevo.putExtra(clave,5);
            startActivity(nuevo);
        });
        r6.setOnClickListener((view)->{
            Intent nuevo = new Intent(this,Main2Activity.class);
            nuevo.putExtra(clave,6);
            startActivity(nuevo);
        });
    }

}
