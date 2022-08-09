package one.digitalinnovation.estacionamento.controller;

import one.digitalinnovation.estacionamento.dto.ParkingDTO;
import one.digitalinnovation.estacionamento.mapper.ParkingMapper;
import one.digitalinnovation.estacionamento.model.Parking;
import one.digitalinnovation.estacionamento.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService service;
    private final ParkingMapper mapper;

    public ParkingController(ParkingService service, ParkingMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @GetMapping
    public List<ParkingDTO> findAll() {
        List<Parking> parkingList = service.findAll();
        return mapper.toParkingDTOList(parkingList);

    }
}
