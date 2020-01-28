package com.indah.lagibelajarfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnChange, btnToAnothetFragment;
    private AnotherFragment anotherFragment;
    private FragmentLain fragmentLain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChange = findViewById(R.id.btn_chance);
        anotherFragment = new AnotherFragment();
        fragmentLain = new FragmentLain();
        btnToAnothetFragment = findViewById(R.id.btn_to_another_fragment);

        FragmentManager Fmanager = getSupportFragmentManager();
        FragmentTransaction ft = Fmanager.beginTransaction();
        ft.add(R.id.FrameFragment, anotherFragment);
        ft.add(R.id.FrameFragment, fragmentLain);
        ft.commit();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                //ft.replace(R.id.FrameFragment, anotherFragment);
                if(anotherFragment.isAdded()){
                    ft.show(anotherFragment);
                    ft.remove(fragmentLain);
                    Toast.makeText(getApplicationContext(), "Fragment Sudah Ditambahkan Sebelumnya", Toast.LENGTH_LONG).show();
                }
                else {
                    ft.replace(R.id.FrameFragment, anotherFragment);
                }
                ft.addToBackStack("Fragment Lain");
                ft.commit();

                btnToAnothetFragment.setVisibility(View.VISIBLE);
                btnChange.setVisibility(View.GONE);
            }
        });

        btnToAnothetFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameFragment, fragmentLain);
                ft.commit();

                btnToAnothetFragment.setVisibility(View.GONE);
                btnChange.setVisibility(View.VISIBLE);
            }
        });

    }
}
