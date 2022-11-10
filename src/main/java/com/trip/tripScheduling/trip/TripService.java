package com.trip.tripScheduling.trip;
import com.trip.tripScheduling.station.Station;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    public void storeTrip(Trip trip) {
        tripRepository.save(trip);
    }

    @Transactional
    public void updateTrip(long id, LocalDateTime startTime, LocalDateTime endTime, Station fromStation, Station toStation) {
        Trip trip = tripRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Sorry, this Trip isn't found!")
        );
        if (startTime != null) trip.setStartTime(startTime);
        if (endTime != null) trip.setEndTime(endTime);
        if (fromStation != null) trip.setFromStation(fromStation);
        if (toStation != null) trip.setToStation(toStation);
    }

    public void deleteTrip(long id) {
        boolean exists = tripRepository.existsById(id);
        if (exists) {
            tripRepository.deleteById(id);
        } else throw new IllegalStateException("Sorry, there is no Trip with this id to delete!");
    }
}
