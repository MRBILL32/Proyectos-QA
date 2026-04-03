package Projects.OminusTest.Cucumber;

import Projects.Omnibus.Model.Pago;
import Projects.Omnibus.Model.Pasajero;
import Projects.Omnibus.Model.Viaje;
import Projects.Omnibus.Repository.PagoRepository;
import Projects.Omnibus.Repository.PasajeroRepository;
import Projects.Omnibus.Repository.ViajeRepository;
import Projects.Omnibus.Service.PagoService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PagoSteps {

    PasajeroRepository pasajeroRepo = mock(PasajeroRepository.class);
    ViajeRepository viajeRepo = mock(ViajeRepository.class);
    PagoRepository pagoRepo = mock(PagoRepository.class);

    PagoService pagoService =
            new PagoService(pagoRepo,pasajeroRepo,viajeRepo);

    Pasajero pasajero;
    Viaje viaje;

    @Given("un pasajero con saldo {double}")
    public void pasajeroConSaldo(double saldo) {
        pasajero = new Pasajero(1L, "Juan", saldo);
        when(pasajeroRepo.findById(1L)).thenReturn(pasajero);
    }

    @Given("n viaje con precio {double}")
    public void viajeConPrecio(double precio)
    {
        viaje = new Viaje(1L, "Ruta A", precio);
        when(viajeRepo.findById(1L)).thenReturn(viaje);
    }

    @When("el pasajero paga el viaje")
    public void pagarViaje() {
        pagoService.cobrar(1L, 1L);
    }

    @Then("el pago se realiza correctamente")
    public void validarPago() {
        verify(pagoRepo).save(any(Pago.class));
    }


}
