package co.com.certification.reto.taks;

import co.com.certification.reto.models.Productos;
import co.com.certification.reto.utils.Replace;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.certification.reto.userinterfaces.CarritoCompras.*;
import static co.com.certification.reto.userinterfaces.PaginaInicio.BOTON_CARRO;
import static co.com.certification.reto.userinterfaces.PaginaInicio.SCROLL_POPULAR;

public class Carrito implements Task {
    List<Productos> productos;
    private int cantProductos;
    private int cantUnidades;

    public Carrito(List<Productos> productos) {
        this.productos = productos;
        this.cantProductos = Integer.parseInt(productos.get(0).getCantProductos());
        this.cantUnidades = Integer.parseInt(productos.get(0).getCantUnidades());
    }

    Replace replace = new Replace();
    double precio_total_prod;
    boolean total_compra;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SCROLL_UNIDAD),
                WaitUntil.the(SELECT_PRECIO_UNITARIO.of("1"), WebElementStateMatchers.isVisible()).forNoMoreThan(35).seconds()
        );

        for (int j = 1; j <= cantProductos; j++) {
            for (int i = 1; i < cantUnidades; i++) {
                actor.attemptsTo(
                        WaitUntil.the(BOTON_AGREGAR.of(String.valueOf(j)), WebElementStateMatchers.isVisible()).forNoMoreThan(35).seconds(),
                        Click.on(BOTON_AGREGAR.of(String.valueOf(j)))
                );

            }
        }

        for (int i = 1; i <= cantProductos; i++) {
            precio_total_prod = replace.precio(SELECT_PRECIO_UNITARIO.of(String.valueOf(i)).resolveFor(actor).getText(),
                    CANTIDAD.of(String.valueOf(i)).resolveFor(actor).getValue(),
                    TOTAL_PRODUCTO.of(String.valueOf(i)).resolveFor(actor).getText());
        }

        total_compra = replace.comparacion(TOTAL_SHIPPING.resolveFor(actor).getText(),
                TOTAL.resolveFor(actor).getText());

        actor.remember("Total_Compra", total_compra);
    }

    public static Carrito carrito(List<Productos> productos) {
        return Tasks.instrumented(Carrito.class, productos);
    }
}
