package examples.gonzasosa.outlook.com.swinfoapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import examples.gonzasosa.outlook.com.swinfoapp.Fragments.BaseApiFragment;
import examples.gonzasosa.outlook.com.swinfoapp.Fragments.FilmFragment;
import examples.gonzasosa.outlook.com.swinfoapp.Fragments.PeopleFragment;
import examples.gonzasosa.outlook.com.swinfoapp.Fragments.ShipsFragment;
import examples.gonzasosa.outlook.com.swinfoapp.Fragments.SpeciesFragment;
import examples.gonzasosa.outlook.com.swinfoapp.Fragments.VehicleFragment;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int contenido = getIntent().getExtras().getInt(MainActivity.clave);
        switch (contenido){
            case 1:BaseApiFragment baseApiAdaper = new BaseApiFragment ();
                getSupportFragmentManager()
                        .beginTransaction ()
                        .replace (R.id.container, baseApiAdaper)
                        .setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit ();
                break;
            case 2:PeopleFragment peopleAdapter = new PeopleFragment();
                getSupportFragmentManager()
                        .beginTransaction ()
                        .replace (R.id.container, peopleAdapter)
                        .setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit ();
                break;
            case 3:ShipsFragment shipsAdapter = new ShipsFragment();
                getSupportFragmentManager()
                        .beginTransaction ()
                        .replace (R.id.container, shipsAdapter)
                        .setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit ();
                break;
            case 4:FilmFragment filmAdapter = new FilmFragment();
                getSupportFragmentManager()
                        .beginTransaction ()
                        .replace (R.id.container, filmAdapter)
                        .setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit ();
                break;
            case 5:VehicleFragment vehicleAdapter = new VehicleFragment();
                getSupportFragmentManager()
                        .beginTransaction ()
                        .replace (R.id.container, vehicleAdapter)
                        .setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit ();
                break;
            case 6:SpeciesFragment speciesAdapter = new SpeciesFragment();
                getSupportFragmentManager()
                        .beginTransaction ()
                        .replace (R.id.container, speciesAdapter)
                        .setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit ();
                break;
            default:
        }
    }
}
