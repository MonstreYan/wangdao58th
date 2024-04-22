package com.cskaoyan.th58.rent;

public class HouseOwner implements HouseRent{
    @Override
    public double rent() {
        double v = 2100.0;
        System.out.println(v);
        return v;
    }
}
