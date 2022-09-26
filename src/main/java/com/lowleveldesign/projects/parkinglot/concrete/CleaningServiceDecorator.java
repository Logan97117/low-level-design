package com.lowleveldesign.projects.parkinglot.concrete;


import com.lowleveldesign.projects.parkinglot.interfaces.Tariff;

public class CleaningServiceDecorator extends BaseTariffDecorator {
    private final int CLEANING_SERVICE_CHARGE = 5;
    public CleaningServiceDecorator(Tariff wrappedTariff) {
        super(wrappedTariff);
    }

    @Override
    public int getBaseTariff() {
        return super.getBaseTariff();
    }

    @Override
    public int getAdditionalTariff() {
        return super.getAdditionalTariff() + this.CLEANING_SERVICE_CHARGE;
    }
}
