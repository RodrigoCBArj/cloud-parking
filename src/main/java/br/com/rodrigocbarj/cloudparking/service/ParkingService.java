package br.com.rodrigocbarj.cloudparking.service;

import br.com.rodrigocbarj.cloudparking.exception.ParkingNotFoundException;
import br.com.rodrigocbarj.cloudparking.model.Parking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<Long, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = new Parking(id, "PMA-3213", "PE", "POLO", "PRETO");
        Parking parking1 = new Parking(id1, "AMP-3123", "SP", "GOL", "BRANCO");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }

    private static Long getUUID() {
        return UUID.randomUUID().getMostSignificantBits();
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    public Parking findById(Long id) {
        Parking parking = parkingMap.get(id);

        if (parking == null) throw new ParkingNotFoundException(id);

        return parking;
    }

    public Parking create(Parking parking) {
        Long id = getUUID();
        parking.setId(id);
        parking.setEntryDate(LocalDateTime.now());
        parkingMap.put(id, parking);
        return parking;
    }
}
