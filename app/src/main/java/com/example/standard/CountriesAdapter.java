package com.example.standard;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.PlanksViewHolder> {

    public static String TAG = CountriesAdapter.class.getSimpleName();
    String[] mCountries;
    public CountriesAdapter(String[] countries) {
        mCountries = countries;
    }

    @NonNull
    @Override
    public PlanksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG,"aslam bought a plank from market gave it to alan yu");
        View plank = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plank,parent,false);
        return new PlanksViewHolder(plank);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanksViewHolder holder, int position) {
        Log.i(TAG,"ernest wrote on the plank");
        holder.countryTextView.setText(mCountries[position]);

    }

    @Override
    public int getItemCount() {
        Log.i(TAG,"abhishek counted the no of items in dataset ---");

        return mCountries.length;
    }

    class  PlanksViewHolder extends RecyclerView.ViewHolder {
        TextView countryTextView;
        public PlanksViewHolder(@NonNull View aslamsPlank) {
            super(aslamsPlank);
            Log.i(TAG,"alan yu  received a plank");
            countryTextView = aslamsPlank.findViewById(R.id.tvRow);

        }
    }
}
