package com.manjurulhoque.qrcodescanner;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.manjurulhoque.qrcodescanner.fragments.GenerateFragment;
import com.manjurulhoque.qrcodescanner.fragments.ScanFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new ScanFragment());
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_scan:
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame, new ScanFragment());
                    transaction.commit();
                    return true;
                case R.id.navigation_generate:
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.content_frame, new GenerateFragment());
                    transaction2.commit();
                    return true;
            }
            return false;
        }
    };
}
