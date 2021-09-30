package com.richieoscar.hagglexapp.ui.view.dashboard.slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.richieoscar.hagglexapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {

    List<SliderItems> items;

    public SliderAdapter(Context context, List<SliderItems> items) {
        this.items = items;
    }

    void addImage(SliderItems item){
        items.add(item);
        notifyDataSetChanged();
    }


    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel, null);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        SliderItems item = items.get(position);
        viewHolder.imageView.setImageResource(item.getImage());

    }

    @Override
    public int getCount() {
        return items.size();
    }

    public class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;
        public SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item);
        }
    }
}
