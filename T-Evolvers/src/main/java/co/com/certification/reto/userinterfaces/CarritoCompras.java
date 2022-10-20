package co.com.certification.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoCompras {
    public static final Target SCROLL_UNIDAD = Target.the("Scroll en unidad").
            located(By.xpath("//th[@class='cart_unit item']"));
    public static final Target BOTON_AGREGAR = Target.the("Agregar mas productos").
            locatedBy("(//a//span//i[@class='icon-plus'])[{0}]");
    public static final Target SELECT_PRECIO_UNITARIO = Target.the("Precio unitario").
            locatedBy("(//td[@data-title=\"Unit price\"]//span//span)[{0}]");
    public static final Target CANTIDAD = Target.the("validar cantidad").
            locatedBy("(//td/input[@type='text'])[{0}]");
    public static final Target TOTAL_SHIPPING = Target.the("total shipping").
            located(By.xpath("//tr//td[@id=\"total_shipping\"]"));
    public static final Target TOTAL_PRODUCTO = Target.the("precio unitario * cantidad").
            locatedBy("(//td[@class=\"cart_total\"]/span)[{0}]");
    public static final Target TOTAL = Target.the("total products + total shipping").
            located(By.xpath("//span[@id= 'total_price']"));
}
