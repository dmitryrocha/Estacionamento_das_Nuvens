package one.digitalinnovation.estacionamento.service;

import one.digitalinnovation.estacionamento.model.Parking;
import one.digitalinnovation.estacionamento.util.Util;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = Util.getUUID();
        Parking parking = new Parking(id, "PLE-1212", "BA", "Ford Ka", "PRETO");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll() {
        return null;
    }


}
