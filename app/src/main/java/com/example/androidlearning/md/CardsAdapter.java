package com.example.androidlearning.md;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import com.example.androidlearning.R;

/**
 * Created by fcwl on 5/22/2015.
 */
public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CountryViewHolder> {

    private List<CountryData> countryDataList;
    private Context mContext;

    public CardsAdapter(List<CountryData> countryDataList, Context context) {
        this.countryDataList = countryDataList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return countryDataList.size();
    }

    @Override
    public void onBindViewHolder(CountryViewHolder countryViewHolder, int i) {
        System.out.println("------------ onBindViewHolder ------------");
        CountryData cd = countryDataList.get(i);
        countryViewHolder.name.setText(cd.getName());
        countryViewHolder.countryDetails.setText(cd.getCountryDetails());
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        System.out.println("------------ onCreateViewHolder ------------");
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.activity_cardview, viewGroup, false);
        return new CountryViewHolder(itemView);
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView countryDetails;

        public CountryViewHolder(View v) {
            super(v);
            System.out.println("------------ CountryViewHolder ------------");
            name = (TextView) v.findViewById(R.id.countryName);
            countryDetails = (TextView) v.findViewById(R.id.countryDetails);
            System.out.println("----- name ----" + name.getText() +
                    "--- countryDetails ----" + countryDetails.getText());
        }
    }

}
