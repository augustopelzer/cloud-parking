package com.digitalinnovation.parking.controller;

import com.digitalinnovation.parking.controller.dto.ParkingCreateDTO;
import com.digitalinnovation.parking.controller.dto.ParkingDTO;
import com.digitalinnovation.parking.controller.mapper.ParkingMapper;
import com.digitalinnovation.parking.model.Parking;
import com.digitalinnovation.parking.service.ParkingService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper){
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiResponse(description = "Find all parking")
    public ResponseEntity<List<ParkingDTO>> findAll(){

        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @ApiResponse(description = "Find parking by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @ApiResponse(description = "Delete parking by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiResponse(description = "Create parking")
    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @ApiResponse(description = "Update parking")
    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto){
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.update(id, parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiResponse(description = "Exit parking")
    @PostMapping("/{id}")
    public ResponseEntity<ParkingDTO> checkOut(@PathVariable String id){
        var parking = parkingService.checkOut(id);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }
}
