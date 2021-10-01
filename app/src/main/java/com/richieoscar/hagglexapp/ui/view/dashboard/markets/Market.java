package com.richieoscar.hagglexapp.ui.view.dashboard.markets;

import com.richieoscar.hagglexapp.R;

import java.util.ArrayList;

public class Market {
    String coinName;
    int image;
    double price;
    int chartImage;

    public String getCoinName() {
        return coinName;
    }

    public int getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public Market(String coinName, int image, double price, int chartImage) {
        this.coinName = coinName;
        this.image = image;
        this.price = price;
        this.chartImage = chartImage;
    }

    public static ArrayList<Market> marketList (){
        ArrayList<Market> markets = new ArrayList<>();
        markets.add(new Market("HaggleX", R.drawable.haggle_coin, 1000, R.drawable.chart));
        markets.add(new Market("Bitcoin", R.drawable.bitimage, 47303, R.drawable.chart));
        markets.add(new Market("Ethereum", R.drawable.etthereum, 3233.52, R.drawable.chart));
        markets.add(new Market("Usdt", R.drawable.usdt, 500, R.drawable.chart));
        markets.add(new Market("Dogecoin", R.drawable.dodgecoin, 0000006, R.drawable.chart));
        markets.add(new Market("Bitcoin", R.drawable.bitimage, 47303, R.drawable.chart));
        return markets;
    }
}
