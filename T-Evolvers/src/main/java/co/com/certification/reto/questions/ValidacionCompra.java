package co.com.certification.reto.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionCompra implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return actor.recall("Total_Compra");
    }
    public static ValidacionCompra validacionCompra(){
        return new ValidacionCompra();
    }
}
