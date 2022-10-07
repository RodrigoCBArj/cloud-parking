package br.com.rodrigocbarj.cloudparking.controller;

import br.com.rodrigocbarj.cloudparking.controller.dto.ParkingDTO;
import br.com.rodrigocbarj.cloudparking.controller.mapper.ParkingMapper;
import br.com.rodrigocbarj.cloudparking.model.Parking;
import br.com.rodrigocbarj.cloudparking.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        return ResponseEntity.ok(parkingMapper.toParkingDTOList(parkingList));
    }
}
