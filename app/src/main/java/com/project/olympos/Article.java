package com.project.olympos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.transition.AutoTransition;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class Article extends AppCompatActivity {

    //Bundle propierties
    String name;

    //Gerneral propierties
    Context context;
    ImageView imageView;
    TextView tvResume;

    //Specific propierties (initialized in extractArticleValues())
    Drawable drawable;
    String resume, url;

    //Expandable CardView1
    String title1, subtitle1, myth1;
    ImageButton arrow;
    LinearLayout hiddenView;
    CardView cardView;
    TextView tvTitle, tvSubtitle, tvMyth;
    //Expandable CardView2
    String title2, subtitle2, myth2;
    ImageButton arrow2;
    LinearLayout hiddenView2;
    CardView cardView2;
    TextView tvTitle2, tvSubtitle2, tvMyth2;

    //AlertDialog
    View alertView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        //Bundle propierties
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");

        //Gerneral propierties
        context = this;
        imageView = findViewById(R.id.imageView);
        tvResume = findViewById(R.id.tvResume);
        TextView tvMoreInfo = findViewById(R.id.tvMoreInfo);

        //Expandable CardView1
        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.arrow_button);
        hiddenView = findViewById(R.id.hidden_view);
        tvTitle = findViewById(R.id.tvTitle);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvMyth = findViewById(R.id.tvMyth);
        //Expandable CardView2
        cardView2 = findViewById(R.id.base_cardview2);
        arrow2 = findViewById(R.id.arrow_button2);
        hiddenView2 = findViewById(R.id.hidden_view2);
        tvTitle2 = findViewById(R.id.tvTitle2);
        tvSubtitle2 = findViewById(R.id.tvSubtitle2);
        tvMyth2 = findViewById(R.id.tvMyth2);
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font>" + name + "</font>"));

        extractArticleValues();

        //---AlertDialog that show big image---
        alertView = getLayoutInflater().inflate(R.layout.alert_dialog_image, null);
        ImageView imageViewAlert = alertView.findViewById(R.id.imageViewAlert);
        imageViewAlert.setImageDrawable(drawable);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cleanViewAnyChartPattern();
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                builder.setView(alertView);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        //------

        //TextView that open Wiki
        tvMoreInfo.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandMythCardView(hiddenView, cardView, arrow);
            }
        });

        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandMythCardView(hiddenView2, cardView2, arrow2);
            }
        });

    }
    
    private void expandMythCardView(LinearLayout hiddenView, CardView cardView, ImageButton arrow) {

        // If the CardView is already expanded, set its visibility
        //  to gone and change the expand less icon to expand more.
        if (hiddenView.getVisibility() == View.VISIBLE) {
            // The transition of the hiddenView is carried out
            //  by the TransitionManager class (Transition: Fade()).
            // Class to create a default transition.
            TransitionManager.beginDelayedTransition(cardView,
                    new Fade());
            hiddenView.setVisibility(View.GONE);
            arrow.setImageResource(R.drawable.vd_expand_more);
        }

        // If the CardView is not expanded, set its visibility
        // to visible and change the expand more icon to expand less.
        else {
            TransitionManager.beginDelayedTransition(cardView,
                    new AutoTransition());
            hiddenView.setVisibility(View.VISIBLE);
            arrow.setImageResource(R.drawable.vd_expand_less);
        }
    }

    private void cleanViewAnyChartPattern() {
        //VIEW CLEANER
        if (alertView != null) {
            ViewGroup parent = (ViewGroup) alertView.getParent();
            if (parent != null) {
                parent.removeView(alertView);
            }
        }
        try {
            alertView = getLayoutInflater().inflate(R.layout.alert_dialog_image, (ViewGroup) alertView.getParent());
        } catch (InflateException e) {
            e.printStackTrace();
        }
    }

    private void setArticleValues() {
        imageView.setImageDrawable(drawable);
        tvResume.setText(resume);
        tvTitle.setText(title1);
        tvSubtitle.setText(subtitle1);
        tvMyth.setText(myth1);
        tvTitle2.setText(title2);
        tvSubtitle2.setText(subtitle2);
        tvMyth2.setText(myth2);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void extractArticleValues() {
        switch (name) {
            /*-----GODS-----*/
            case "Zeus":
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                resume = getString(R.string.zeus_resume);
                url = "https://es.wikipedia.org/wiki/Zeus";
                title1 = getString(R.string.zeus_myth1_title);
                subtitle1 = getString(R.string.zeus_myth1_subtitle);
                myth1 = getString(R.string.zeus_myth1_text);
                title2 = getString(R.string.zeus_myth2_title);
                subtitle2 = getString(R.string.zeus_myth2_subtitle);
                myth2 = getString(R.string.zeus_myth2_text);
                setArticleValues();
                break;
            case "Hades":
                drawable = getResources().getDrawable(R.drawable.hades_x);
                resume = getString(R.string.hades_resume);
                url = "https://es.wikipedia.org/wiki/Hades";
                title1 = getString(R.string.hades_myth1_title);
                subtitle1 = getString(R.string.hades_myth1_subtitle);
                myth1 = getString(R.string.hades_myth1_text);
                title2 = getString(R.string.hades_myth2_title);
                subtitle2 = getString(R.string.hades_myth2_subtitle);
                myth2 = getString(R.string.hades_myth2_text);
                setArticleValues();
                break;
            case "Hestia":
                drawable = getResources().getDrawable(R.drawable.hestia_x);
                resume = getString(R.string.hestia_resume);
                url = "https://es.wikipedia.org/wiki/Hestia";
                title1 = getString(R.string.hestia_myth1_title);
                subtitle1 = getString(R.string.hestia_myth1_subtitle);
                myth1 = getString(R.string.hestia_myth1_text);
                title2 = getString(R.string.hestia_myth2_title);
                subtitle2 = getString(R.string.hestia_myth2_subtitle);
                myth2 = getString(R.string.hestia_myth2_text);
                setArticleValues();
                break;
            case "Hera":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hera_x));
                drawable = getResources().getDrawable(R.drawable.hera_x);
                break;
            case "Poseidón":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.poseidon_x));
                drawable = getResources().getDrawable(R.drawable.poseidon_x);
                break;
            case "Demeter":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.demeter_x));
                drawable = getResources().getDrawable(R.drawable.demeter_x);
                break;
            case "Afrodita":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aphrodite_x));
                drawable = getResources().getDrawable(R.drawable.aphrodite_x);
                break;
            case "Apolo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.apollo_x));
                drawable = getResources().getDrawable(R.drawable.apollo_x);
                break;
            case "Ares":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ares_x));
                drawable = getResources().getDrawable(R.drawable.ares_x);
                break;
            case "Artemisa":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.artemis_x));
                drawable = getResources().getDrawable(R.drawable.artemis_x);
                break;
            case "Atenea":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.athenea_x));
                drawable = getResources().getDrawable(R.drawable.athenea_x);
                break;
            case "Dioniso":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dionysus_x));
                drawable = getResources().getDrawable(R.drawable.dionysus_x);
                break;
            case "Helios":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.helios_x));
                drawable = getResources().getDrawable(R.drawable.helios_x);
                break;
            case "Hefesto":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hephaestus_x));
                drawable = getResources().getDrawable(R.drawable.hephaestus_x);
                break;
            case "Hermes":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hermes_x));
                drawable = getResources().getDrawable(R.drawable.hermes_x);
                break;
            case "Anfitrite":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.amphitrite_x));
                drawable = getResources().getDrawable(R.drawable.amphitrite_x);
                break;
            case "Eos":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eos_x));
                drawable = getResources().getDrawable(R.drawable.eos_x);
                break;
            case "Eris":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eris_x));
                drawable = getResources().getDrawable(R.drawable.eris_x);
                break;
            case "Eros":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eros_x));
                drawable = getResources().getDrawable(R.drawable.eros_x);
                break;
            case "Hebe":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hebe_x));
                drawable = getResources().getDrawable(R.drawable.hebe_x);
                break;
            case "Iris":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.iris_x));
                drawable = getResources().getDrawable(R.drawable.iris_x);
                break;
            case "Perséfone":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.persephone_x));
                drawable = getResources().getDrawable(R.drawable.persephone_x);
                break;
            case "Morfeo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.morpheus_x));
                drawable = getResources().getDrawable(R.drawable.morpheus_x);
                break;
            case "Nike":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.nike_x));
                drawable = getResources().getDrawable(R.drawable.nike_x);
                break;
            case "Kione":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.khione_x));
                drawable = getResources().getDrawable(R.drawable.khione_x);
                break;
            case "Melinoe":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.melinoe_x));
                drawable = getResources().getDrawable(R.drawable.melinoe_x);
                break;
            case "Selene":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.selene_x));
                drawable = getResources().getDrawable(R.drawable.selene_x);
                break;
            case "Nemesis":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.nemesis_x));
                drawable = getResources().getDrawable(R.drawable.nemesis_x);
                break;
            case "Tyche":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tyche_x));
                drawable = getResources().getDrawable(R.drawable.tyche_x);
                break;
                /*-----OTHERS-----*/
            case "Eolo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aeolus_x));
                drawable = getResources().getDrawable(R.drawable.aeolus_x);
                break;
            default:
                break;
        }

    }
}