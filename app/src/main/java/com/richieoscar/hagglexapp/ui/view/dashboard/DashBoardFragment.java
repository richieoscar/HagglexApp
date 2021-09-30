package com.richieoscar.hagglexapp.ui.view.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.richieoscar.hagglexapp.R;
import com.richieoscar.hagglexapp.databinding.FragmentDashBoardBinding;
import com.richieoscar.hagglexapp.ui.view.dashboard.slider.SliderAdapter;
import com.richieoscar.hagglexapp.ui.view.dashboard.slider.SliderItems;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class DashBoardFragment extends Fragment {

   FragmentDashBoardBinding binding;
   SliderAdapter sliderAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(inflater, container,false);

        initializeSlider();
        return binding.getRoot();
    }

    void initializeSlider(){
        SliderView sliderView = binding.sliderview;
        sliderAdapter = new SliderAdapter(getContext(),SliderItems.images());
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.NONE);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
    }
}