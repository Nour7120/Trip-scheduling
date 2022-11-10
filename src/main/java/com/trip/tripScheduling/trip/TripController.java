package com.trip.tripScheduling.trip;
import com.trip.tripScheduling.station.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trip")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public List<Trip> getTrips() {
        return tripService.getTrips();
    }

    @PostMapping
    public void storeTrip(@RequestBody Trip trip) {
        tripService.storeTrip(trip);
    }

    @PutMapping(path = "{tripId}")
    public void updateTrip(@PathVariable("tripId") long id,
                           @RequestParam(required = false) LocalDateTime startTime,
                           @RequestParam(required = false) LocalDateTime endTime,
                           @RequestParam(required = false) Station fromStation,
                           @RequestParam(required = false) Station toStation) {
        tripService.updateTrip(id, startTime, endTime, fromStation, toStation);
    }

    @DeleteMapping(path = "{tripId}")
    public void deleteTrip(@PathVariable("tripId") long id) {
        tripService.deleteTrip(id);
    }
}
