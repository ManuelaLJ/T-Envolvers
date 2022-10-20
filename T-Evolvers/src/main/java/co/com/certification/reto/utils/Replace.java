package co.com.certification.reto.utils;

import java.text.DecimalFormat;

public class Replace {

    double suma = 0;

    public double precio(String precio, String cantidad, String total) {
        double precios = Double.parseDouble(precio.replace("$", ""));
        double totales = Double.parseDouble(total.replace("$", ""));
        double precio_producto=0;

        precio_producto = precios * Double.parseDouble(cantidad);

        if(precio_producto == totales) {
            suma += precio_producto;
        }else {
            suma = 0;
        }

        return suma;
    }

    public boolean comparacion( String shipping, String total_price){

        double shippings = Double.parseDouble(shipping.replace("$", ""));
        double total_prices = Double.parseDouble(total_price.replace("$", ""));
        suma = Math.round(suma * 100) / 100d;
        suma+= shippings;

        if (suma == total_prices){
            return true;
        }else {
            return false;
        }
    }
}
