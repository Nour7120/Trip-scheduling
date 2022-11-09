package com.example.rhelTest.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/station")
public class StationController {

    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public List<Station> getStations() {
        return stationService.getStations();
    }

    @PostMapping
    public void storeStation(@RequestBody Station station) {
        stationService.storeStation(station);
    }

    @PutMapping(path = "{stationId}")
    public void updateStation(@PathVariable("stationId") long id, @RequestParam(required = false) String name) {
        stationService.updateStation(id, name);
    }

    @DeleteMapping(path = "{stationId}")
    public void deleteStation(@PathVariable("stationId") long id) {
        stationService.deleteStation(id);
    }
}
