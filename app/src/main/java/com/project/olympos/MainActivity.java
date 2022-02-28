package com.project.olympos;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.transition.AutoTransition;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.olympos.ui.main.SectionsPagerAdapter;
import com.project.olympos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        //credits
        LinearLayout linearLayout = findViewById(R.id.llCredits);
        TextView textViewCredits = findViewById(R.id.tvCredits);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandCredits(linearLayout, textViewCredits);
            }
        });

    }

    private void expandCredits(LinearLayout linearLayout, TextView textViewCredits) {
        if (textViewCredits.getVisibility() == View.VISIBLE) {
            TransitionManager.beginDelayedTransition(linearLayout,
                    new Fade());
            textViewCredits.setVisibility(View.GONE);
        } else {
            TransitionManager.beginDelayedTransition(linearLayout,
                    new AutoTransition());
            textViewCredits.setVisibility(View.VISIBLE);
        }
    }
}