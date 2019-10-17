package com.deiviherrera.appfragmen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
   //  <!-- paso3-->

    final BlankFragment fragment1 = new BlankFragment();
    final BlankFragment2 fragment2 = new BlankFragment2();
    final BlankFragment3 fragment3 = new BlankFragment3();
    final FragmentManager fm = getSupportFragmentManager();

    Fragment active = fragment1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //  <!-- paso4-->
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().hide(active)//eliminar el fragment activo osea el fragment 1 q estara activo
                            .show(fragment1).commit(); // no se usó replace q era otra forma
                    active = fragment1;
                    return true;
                case R.id.navigation_dashboard:
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active= fragment2;
                    return true;
                case R.id.navigation_notifications:
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  <!-- paso5-->
        fm.beginTransaction().add(R.id.main_container,
                fragment3,"3").hide(fragment3).commit();//comit para oculatar el fragmento 3
        fm.beginTransaction().add(R.id.main_container,
                fragment2,"3").hide(fragment2).commit();//comit para oculatar el fragmento 2
        fm.beginTransaction().add(R.id.main_container,
                fragment1).commit(); // se muestra solo el 1

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
