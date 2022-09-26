package com.lowleveldesign.projects.parkinglot.concrete;


import com.lowleveldesign.projects.parkinglot.interfaces.Tariff;

public class EVServiceDecorator extends BaseTariffDecorator {
    private final int EV_CHARGE = 10;
    public EVServiceDecorator(Tariff wrappedTariff) {
        super(wrappedTariff);
    }

    @Override
    public int getBaseTariff() {
        return super.getBaseTariff();
    }

    @Override
    public int getAdditionalTariff() {
        return this.EV_CHARGE + super.getAdditionalTariff();
    }
}
