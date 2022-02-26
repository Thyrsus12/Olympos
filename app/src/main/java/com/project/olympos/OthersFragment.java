package com.project.olympos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OthersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OthersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Being> others;
    RecyclerView recyclerOthers;

    public OthersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OthersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OthersFragment newInstance(String param1, String param2) {
        OthersFragment fragment = new OthersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_others, container, false);
        View vista = inflater.inflate(R.layout.fragment_others, container, false);
        others = new ArrayList<>();
        recyclerOthers = vista.findViewById(R.id.rvGods);
        recyclerOthers.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RVothersAdapter adaptador = new RVothersAdapter(others, getContext(), this);
        recyclerOthers.setAdapter(adaptador);

        fillGodsArray();

        return vista;
    }

    private void fillGodsArray() {
        others.add(new Being(getResources().getDrawable(R.drawable.aeolus_x), "Eolo"));
        others.add(new Being(getResources().getDrawable(R.drawable.asteria_x), "Asteria"));
        others.add(new Being(getResources().getDrawable(R.drawable.chaos_x), "Caos"));
        others.add(new Being(getResources().getDrawable(R.drawable.chiron_x), "Chiron"));
        others.add(new Being(getResources().getDrawable(R.drawable.circe_x), "Circe"));
        others.add(new Being(getResources().getDrawable(R.drawable.cronos_x), "Cronos"));
        others.add(new Being(getResources().getDrawable(R.drawable.daphne_x), "Dafne"));
        others.add(new Being(getResources().getDrawable(R.drawable.erebus_x), "Érebo"));
        others.add(new Being(getResources().getDrawable(R.drawable.gaia_x), "Gaia"));
        others.add(new Being(getResources().getDrawable(R.drawable.hecate_x), "Hécate"));
        others.add(new Being(getResources().getDrawable(R.drawable.hypnos_x), "Hipnos"));
        others.add(new Being(getResources().getDrawable(R.drawable.medusa_x), "Medusa"));
        others.add(new Being(getResources().getDrawable(R.drawable.nyx_x), "Nix"));
        others.add(new Being(getResources().getDrawable(R.drawable.moirai), "Las moiras"));
        others.add(new Being(getResources().getDrawable(R.drawable.pan_x), "Pan"));
        others.add(new Being(getResources().getDrawable(R.drawable.thanatos_x), "Tánatos"));
        others.add(new Being(getResources().getDrawable(R.drawable.sirens_x), "Sirenas"));
        others.add(new Being(getResources().getDrawable(R.drawable.themis_x), "Temis"));
        others.add(new Being(getResources().getDrawable(R.drawable.rhea_x), "Rea"));
        others.add(new Being(getResources().getDrawable(R.drawable.styx_x), "Estigia"));
        others.add(new Being(getResources().getDrawable(R.drawable.pythia_x), "Pítia"));
        others.add(new Being(getResources().getDrawable(R.drawable.urano_x), "Urano"));

    }

    public void openArticle(int position, String name, Drawable image) {
        Intent intent = new Intent(getActivity(), Article.class);
        intent.putExtra("name", name);
        intent.putExtra("image", (Parcelable) image);
        startActivity(intent);
    }
}