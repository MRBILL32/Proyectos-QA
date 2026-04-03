package Projects.Omnibus.Repository;

import Projects.Omnibus.Model.Viaje;

public interface ViajeRepository {
    Viaje findById(Long id);
}
