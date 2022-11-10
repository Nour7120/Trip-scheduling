package com.trip.tripScheduling.admin;


import com.trip.tripScheduling.station.Station;
import com.trip.tripScheduling.trip.Trip;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(path = "/getAllStations")
    public List<Station> showAllStations() {
        return adminService.showAllStations();
    }

    @GetMapping(path = "/getAllTrips")
    public List<Trip> showAllScheduledTrips() {
        return adminService.showAllScheduledTrips();
    }

    @DeleteMapping(path = "/deleteTrip/{id}")
    public void deleteTrip(@PathVariable("id") long id) {
        adminService.deleteTrip(id);
    }

    @PostMapping(path = "/createTrip")
    public void createTrip(@RequestBody Trip trip) {
        adminService.createTrip(trip);
    }

    @PostMapping(path = "/signIn")
    public void signIn(@RequestBody Admin admin) {
        adminService.signIn(admin);
    }

    @PostMapping(path = "/signUp")
    public void signUp(@RequestBody Admin admin)
    {
        adminService.signUp(admin);
    }

    @PutMapping(path = "/updateTrip/{id}")
    public void updateTrip(@PathVariable("id") long id,
                           @RequestParam(required = false) LocalDateTime startTime,
                           @RequestParam(required = false) LocalDateTime endTime,
                           @RequestParam(required = false) Station fromStation,
                           @RequestParam(required = false) Station toStation
    ) {
        adminService.updateTrip(id, startTime, endTime, fromStation, toStation);
    }

}
