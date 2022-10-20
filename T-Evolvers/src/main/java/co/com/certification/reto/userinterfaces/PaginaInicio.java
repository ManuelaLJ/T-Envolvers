package co.com.certification.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicio {
    public static final Target SCROLL_POPULAR = Target.the("scroll").
            located(By.xpath("//ul[@id='home-page-tabs']"));
    public static final Target BEST_SELLERS = Target.the("best sellers").
            located(By.xpath("//a[@class='blockbestsellers']"));
    public static final Target BOTON_PRODUCTO = Target.the("Boton producto").
            locatedBy("(//a[@class='product_img_link'])[{0}]");
    public static final Target BOTON_CARRO = Target.the("Boton agregar a carrito").
            locatedBy("(//a[@title='Add to cart'])[{0}]");
    public static final Target BOTON_CONTINUAR = Target.the("Boton continuar compra").
            located(By.xpath(" //span[@title='Continue shopping']"));
    public static final Target BOTON_PROCEDER = Target.the("Boton proceder pago").
            located(By.xpath("//a[@title='Proceed to checkout']"));
    public static final Target SELECT_PRECIO = Target.the("Precio por producto").
            locatedBy("(//span[@itemprop='price'])[{0}]");

}
