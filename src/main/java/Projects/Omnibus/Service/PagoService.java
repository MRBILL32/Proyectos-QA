package Projects.Omnibus.Service;

import Projects.Omnibus.Model.Pago;
import Projects.Omnibus.Model.Pasajero;
import Projects.Omnibus.Model.Viaje;
import Projects.Omnibus.Repository.PagoRepository;
import Projects.Omnibus.Repository.PasajeroRepository;
import Projects.Omnibus.Repository.ViajeRepository;

import java.time.LocalDateTime;

public class PagoService {

    private final PasajeroRepository pasrepo;
    private final ViajeRepository viarepo;
    private final PagoRepository pagrepo;

    public PagoService(PagoRepository pagrepo, PasajeroRepository pasrepo, ViajeRepository viarepo) {
        this.pagrepo = pagrepo;
        this.pasrepo = pasrepo;
        this.viarepo = viarepo;
    }

    //Validar: Saldo insuficiente
    public void cobrar(Long pasajeroId, Long viajeId)
    {
        Pasajero p = pasrepo.findById(pasajeroId);
        Viaje v = viarepo.findById(viajeId);

        if(p.getSaldo() < v.getPrecio())
        {
            throw new RuntimeException("Insufficient balance");
        }

        p.setSaldo(p.getSaldo()-v.getPrecio());

        Pago pago = new Pago();
        pago.setPasajero(p);
        pago.setViaje(v);
        pago.setMonto(p.getSaldo());
        pago.setFecha(LocalDateTime.now());

        pagrepo.save(pago);
        pasrepo.save(p);
    }
}
