package co.com.certification.reto.taks;

import co.com.certification.reto.models.Productos;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.ValueOf;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.pdfbox.contentstream.operator.graphics.MoveTo;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.com.certification.reto.userinterfaces.CarritoCompras.*;
import static co.com.certification.reto.userinterfaces.PaginaInicio.*;


public class AgregarProductos implements Task {

    List<Productos> productos;
    private int cantProductos;

    public AgregarProductos(List<Productos> productos) {
        this.productos = productos;
        this.cantProductos = Integer.parseInt(productos.get(0).getCantProductos());
    }

    @Override

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SCROLL_POPULAR));

        for (int i = 1; i <= cantProductos; i++) {
            int a = i*2;
            if (i < cantProductos) {
                actor.attemptsTo(
                        WaitUntil.the(SELECT_PRECIO.of(String.valueOf(a)), WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(SELECT_PRECIO.of(String.valueOf(a))),
                        WaitUntil.the(BOTON_CARRO.of(String.valueOf(i)), WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds(),
                        Click.on(BOTON_CARRO.of(String.valueOf(i))),
                        WaitUntil.the(BOTON_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BOTON_CONTINUAR)
                );

            } else if (i == cantProductos) {
                actor.attemptsTo(
                        WaitUntil.the(SELECT_PRECIO.of(String.valueOf(a)), WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(SELECT_PRECIO.of(String.valueOf(a))),
                        WaitUntil.the(BOTON_CARRO.of(String.valueOf(i)), WebElementStateMatchers.isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BOTON_CARRO.of(String.valueOf(i))),
                        WaitUntil.the(BOTON_PROCEDER, WebElementStateMatchers.isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BOTON_PROCEDER)
                );

            }
        }
        actor.attemptsTo(
                WaitUntil.the(SELECT_PRECIO_UNITARIO.of("1"), WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds()
        );

    }

    public static AgregarProductos agregarProductos(List<Productos> productos) {
        return Tasks.instrumented(AgregarProductos.class, productos);
    }
}
