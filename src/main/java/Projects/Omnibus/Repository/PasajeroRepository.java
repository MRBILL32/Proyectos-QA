package Projects.Omnibus.Repository;

import Projects.Omnibus.Model.Pasajero;

public interface PasajeroRepository {
    Pasajero findById(Long id);
    void save(Pasajero pasajero);
}
