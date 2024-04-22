package com.cskaoyan.th58.rent;

//房屋中介 房东报价的基础上 + 10%手续费
public class HouseProxy implements HouseRent{

//    HouseOwner houseOwner;

    HouseRent houseRent;

    public HouseProxy(HouseRent houseRent) {
        this.houseRent = houseRent;
    }

    //中介的报价就是在原有基础上增加10%
    @Override
    public double rent() {

        double v = 1.1 * houseRent.rent();
        System.out.println(v);
        return v;
    }
}
