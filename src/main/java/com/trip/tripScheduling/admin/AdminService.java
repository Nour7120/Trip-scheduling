package com.trip.tripScheduling.admin;
import com.trip.tripScheduling.station.Station;
import com.trip.tripScheduling.station.StationService;
import com.trip.tripScheduling.trip.Trip;
import com.trip.tripScheduling.trip.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public void updateTrip(long id, LocalDateTime startTime, LocalDateTime endTime, Station fromStation, Station toStation)
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
        if (!admin.getEmail().equals(adminObj.getEmail()) || !admin.getPassword().equals(adminObj.getPassword()))
        {
            throw new IllegalStateException("No Admin Credentials Found!");
        }
    }

    public void signUp(Admin admin) {
        boolean adminExists = adminRepository.existsById(1L);
        if(!adminExists)
        {
            adminRepository.save(
                    admin
            );
        }
        else {
            throw new IllegalStateException("Admin Already Exists!");
        }
    }
}
