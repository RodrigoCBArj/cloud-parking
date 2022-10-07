package br.com.rodrigocbarj.cloudparking.service;

import br.com.rodrigocbarj.cloudparking.model.Parking;
import org.springframework.stereotype.Service;

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
        Parking parking = new Parking(id, "PMA-3213", "PE", "POLO", "PRETO");
        parkingMap.put(id, parking);
    }

    private static Long getUUID() {
        return UUID.randomUUID().getMostSignificantBits();
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }
}