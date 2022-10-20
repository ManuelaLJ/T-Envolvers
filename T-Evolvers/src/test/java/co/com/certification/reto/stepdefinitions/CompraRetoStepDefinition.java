package co.com.certification.reto.stepdefinitions;

import co.com.certification.reto.models.Productos;
import co.com.certification.reto.questions.ValidacionCompra;
import co.com.certification.reto.taks.AgregarProductos;
import co.com.certification.reto.taks.Carrito;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class CompraRetoStepDefinition {
    @Managed(driver = "chrome")
    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
        OnStage.theActorCalled("Manuela");
    }

    @Dado("^que el usurio ingresa a la pagina principal$")
    public void queElUsurioIngresaALaPaginaPrincipal() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("http://automationpractice.com/"));
    }

    @Cuando("^el usuario selecciona los productos y agrega varias cantidades$")
    public void elUsuarioSeleccionaLosProductosYAgregaVariasCantidades(List<Productos> productos) {
        System.out.println("Llega msdlfmlsdfknsd{ }j+bo");
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarProductos
                .agregarProductos(productos));
        OnStage.theActorInTheSpotlight().attemptsTo(Carrito.carrito(productos));
    }

    @Entonces("^deberia ver que el precio total coincida con la suma de los valores de los productos$")
    public void deberiaVerQueElPrecioTotalCoincidaConLaSumaDeLosValoresDeLosProductos() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidacionCompra.validacionCompra(), Matchers.is(true)));
    }

}
