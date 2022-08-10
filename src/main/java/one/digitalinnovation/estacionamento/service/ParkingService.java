package one.digitalinnovation.estacionamento.service;

import one.digitalinnovation.estacionamento.exception.ParkingNotFoundException;
import one.digitalinnovation.estacionamento.model.Parking;
import one.digitalinnovation.estacionamento.util.Util;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id1 = Util.getUUID();
        var id2 = Util.getUUID();
        Parking parking1 = new Parking(id1, "PLE-1212", "BA", "Ford Ka", "PRETO");
        Parking parking2 = new Parking(id2, "PLE-2121", "SP", "Ford Focus", "VERMELHO");
        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }


    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if(parking == null) {
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        parkingCreate.setId(Util.getUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(parkingCreate.getId(), parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        Parking parking = findById(id);
        parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        //TODO - ver quais as diferenças com create e mudar o que for necessário

        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return parking;
    }
}
