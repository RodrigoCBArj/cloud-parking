package br.com.rodrigocbarj.cloudparking.controller;

import br.com.rodrigocbarj.cloudparking.controller.dto.ParkingCreateDTO;
import br.com.rodrigocbarj.cloudparking.controller.dto.ParkingDTO;
import br.com.rodrigocbarj.cloudparking.controller.mapper.ParkingMapper;
import br.com.rodrigocbarj.cloudparking.model.Parking;
import br.com.rodrigocbarj.cloudparking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService,
                             ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        return ResponseEntity.ok(parkingMapper.toParkingDTOList(parkingList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Long id) {
        Parking parking = parkingService.findById(id);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO createDTO) {
        Parking newParking = parkingService.create(parkingMapper.toParkingByCreate(createDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(parkingMapper.toParkingDTO(newParking));
    }
}
