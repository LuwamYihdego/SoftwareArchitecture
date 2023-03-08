package esb;

public class ShippingRoute {

    public String shippingRouteByAmount(Order order) {
        if (order.getAmount() > 175)
            return "nextdayshippingchannel";
        else
            return "normalshippingchannel";

    }

    public String shippingRouteByLocation(Order order){
        if(order.isInternational()){
            return "internationalshippingchannel";
        } else
            return "domesticshippingchannel";
    }
}
