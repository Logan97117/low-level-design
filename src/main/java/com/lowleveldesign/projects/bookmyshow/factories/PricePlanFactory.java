package com.lowleveldesign.projects.bookmyshow.factories;

import com.lowleveldesign.projects.bookmyshow.enums.PricePlan;
import com.lowleveldesign.projects.bookmyshow.models.Seat;
import java.util.List;

public class PricePlanFactory {
    public static void initialiseSeatsAsPerPricePlan(List<Seat> seats, PricePlan pricePlan) {
        switch(pricePlan) {
            case DEFAULT: {
                //code for default initialisation
            }
        }
    }
}
