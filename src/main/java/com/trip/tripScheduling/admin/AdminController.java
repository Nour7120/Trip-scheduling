package com.example.rhelTest.admin;

import com.example.rhelTest.station.Station;
import com.example.rhelTest.trip.Trip;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/updateTrip/{id}")
    public void updateTrip(@PathVariable("id") long id,
                           @RequestParam(required = false) String startTime,
                           @RequestParam(required = false) String endTime,
                           @RequestParam(required = false) Station fromStation,
                           @RequestParam(required = false) Station toStation
    ) {
        adminService.updateTrip(id, startTime, endTime, fromStation, toStation);
    }

}
