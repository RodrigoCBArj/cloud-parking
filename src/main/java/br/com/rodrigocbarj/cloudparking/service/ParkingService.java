package br.com.rodrigocbarj.cloudparking.service;

import br.com.rodrigocbarj.cloudparking.exception.ParkingNotFoundException;
import br.com.rodrigocbarj.cloudparking.model.Parking;
import br.com.rodrigocbarj.cloudparking.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    private final ParkingRepository repository;

    public ParkingService(ParkingRepository repository) {
        this.repository = repository;
    }

    public List<Parking> findAll() {
        return repository.findAll();
    }

    public Parking findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ParkingNotFoundException(id));
    }

    public Parking create(Parking incompleteParking) {
        Parking parking = new Parking();
        parking.setLicense(incompleteParking.getLicense());
        parking.setState(incompleteParking.getState());
        parking.setModel(incompleteParking.getModel());
        parking.setColor(incompleteParking.getColor());

        return repository.save(parking);
    }

    public Parking update(Long id, Parking parkingChanges) {
        Parking parking = findById(id);
        parking.setLicense(parkingChanges.getLicense());
        parking.setState(parkingChanges.getState());
        parking.setModel(parkingChanges.getModel());
        parking.setColor(parkingChanges.getColor());

        return repository.save(parking);
    }

    public void delete(Long id) {
        findById(id); // se não existir esse id, não remove.
        repository.deleteById(id);
    }

    public Parking exit(Long id) {
        // TODO:
        // pegar o estacionado
        // atualizar data de saida
        // calcular valor
        return null;
    }
}
