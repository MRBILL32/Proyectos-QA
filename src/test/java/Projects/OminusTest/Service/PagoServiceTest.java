package Projects.OminusTest.Service;

import Projects.Omnibus.Model.Pago;
import Projects.Omnibus.Model.Pasajero;
import Projects.Omnibus.Model.Viaje;
import Projects.Omnibus.Repository.PagoRepository;
import Projects.Omnibus.Repository.PasajeroRepository;
import Projects.Omnibus.Repository.ViajeRepository;
import Projects.Omnibus.Service.PagoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PagoServiceTest {

    @Mock
    PasajeroRepository pasrepo;

    @Mock
    ViajeRepository viarepo;

    @Mock
    PagoRepository pagrepo;

    @InjectMocks
    PagoService pagoserv;

    @Test
    void ShouldChargeCorrectly(){
        Pasajero pasajero = new Pasajero(1L,"Juan",10.0);
        Viaje viaje = new Viaje(1L,"Ruta A",5.0);

        when(pasrepo.findById(1L)).thenReturn(pasajero);
        when(viarepo.findById(1L)).thenReturn(viaje);

        pagoserv.cobrar(1L,1L);
        verify(pagrepo).save(any(Pago.class));
        verify(pasrepo).save(pasajero);

        assertEquals(5.0, pasajero.getSaldo(),
                () -> "❌ ERROR: Insufficient balance " + pasajero.getSaldo());

        System.out.println("✔ Test Passed: Collection OK");

    }

}
