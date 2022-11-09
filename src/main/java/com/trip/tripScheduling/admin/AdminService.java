package com.trip.tripScheduling.admin;

import com.example.rhelTest.station.Station;
import com.example.rhelTest.station.StationService;
import com.example.rhelTest.trip.Trip;
import com.example.rhelTest.trip.TripService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final TripService tripService;
    private final StationService stationService;
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(TripService tripService, StationService stationService, AdminRepository adminRepository)
    {
        this.tripService = tripService;
        this.stationService = stationService;
        this.adminRepository = adminRepository;
    }

    public void createTrip(Trip trip)
    {
        tripService.storeTrip(trip);
    }

    public void updateTrip(long id, String startTime, String endTime, Station fromStation, Station toStation)
    {
        tripService.updateTrip(id, startTime, endTime, fromStation, toStation);
    }

    public void deleteTrip(long id)
    {
        tripService.deleteTrip(id);
    }

    public List<Trip> showAllScheduledTrips()
    {
        return tripService.getTrips();
    }

    public List<Station> showAllStations()
    {
        return stationService.getStations();
    }

    public void signIn(Admin admin) {
        Admin adminObj = adminRepository.findById(1L).orElseThrow(() -> new IllegalStateException("No Admin Credentials Found!"));
        System.out.println(adminObj.getEmail());
        System.out.println(adminObj.getPassword());
        System.out.println(admin.getEmail());
        System.out.println(admin.getPassword());
        if (!admin.getEmail().equals(adminObj.getEmail()) || !admin.getPassword().equals(adminObj.getPassword()))
        {
            throw new IllegalStateException("No Admin Credentials Found!");
        }
    }
}
