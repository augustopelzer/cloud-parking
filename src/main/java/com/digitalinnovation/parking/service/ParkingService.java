package com.digitalinnovation.parking.service;

import com.digitalinnovation.parking.exception.ParkingNotFoundException;
import com.digitalinnovation.parking.model.Parking;
import com.digitalinnovation.parking.repository.ParkingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public Parking findById(String id) {
        return parkingRepository.findById(id).orElseThrow(() ->
            new ParkingNotFoundException(id));
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parking.setState(parkingCreate.getState());
        parking.setModel(parkingCreate.getModel());
        parking.setLicense(parkingCreate.getLicense());
        parkingRepository.save(parking);
        return parking;
    }

    public Parking checkOut(String id) {
        //recuperar o estacionado
        Parking parking = findById(id);
        //atualizar a data de saida
        parking.setExitDate(LocalDateTime.now());
        //calcular o valor
        parking.setBill(ParkingCheckout.getBill(parking));
        parkingRepository.save(parking);
        return parking;
    }
}
