package com.richieoscar.hagglexapp.ui.view.dashboard.markets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.richieoscar.hagglexapp.R;

import java.util.ArrayList;

public class MarketsAdapter extends RecyclerView.Adapter<MarketsAdapter.MarketViewHolder> {
    private  ArrayList<Market> marketArrayList;
   private Context context;

    public MarketsAdapter(ArrayList<Market> marketArrayList, Context context) {
        this.marketArrayList = marketArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false);

        return new MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketViewHolder holder, int position) {
        holder.bind(marketArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return marketArrayList.size();
    }

    public class MarketViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        ImageView coinImage;
        ImageView chartImage;
        public MarketViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.coin_name);
            price= itemView.findViewById(R.id.coin_price);
            coinImage = itemView.findViewById(R.id.coin_image);
            chartImage = itemView.findViewById(R.id.chart_image);
        }

        void bind(Market market){
            name.setText(market.getCoinName());
            price.setText(String.valueOf(market.getPrice()));
            coinImage.setImageResource(market.getImage());
            chartImage = itemView.findViewById(R.id.chart_image);
        }
    }
}
