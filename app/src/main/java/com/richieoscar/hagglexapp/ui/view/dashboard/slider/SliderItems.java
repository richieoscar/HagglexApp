package com.richieoscar.hagglexapp.ui.view.dashboard.slider;

import android.transition.Slide;

import com.richieoscar.hagglexapp.R;

import java.util.ArrayList;
import java.util.List;

public class SliderItems {
    int image;

    public SliderItems(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

   public static List<SliderItems> images(){
       ArrayList<SliderItems> sliderItems = new ArrayList<>();
       sliderItems.add(new SliderItems(R.drawable.market));
        sliderItems.add(new SliderItems(R.drawable.mask_slide));
        sliderItems.add(new SliderItems(R.drawable.haggle));
        sliderItems.add(new SliderItems(R.drawable.market));
        return sliderItems;
    }
}
