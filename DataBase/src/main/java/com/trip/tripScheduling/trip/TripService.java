package com.trip.tripScheduling.trip;
import com.trip.tripScheduling.station.Station;
import com.trip.tripScheduling.station.StationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final StationRepository stationRepository;

    @Autowired
    public TripService(TripRepository tripRepository, StationRepository stationRepository) {
        this.tripRepository = tripRepository;
        this.stationRepository =stationRepository;
    }

    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    public void storeTrip(Trip trip) {
        tripRepository.save(trip);
    }

    @Transactional
    public void updateTrip(long id, LocalDateTime startTime, LocalDateTime endTime, String fromStation, String toStation) {
        Trip trip = tripRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Sorry, this Trip isn't found!")
        );
        if (startTime.equals(null)) trip.setStartTime(startTime);
        if (!endTime.equals(null)) trip.setEndTime(endTime);
        if (fromStation != "") {
            Station station = stationRepository.findStationByName(fromStation);
            if(station == null)
                trip.setFromStation(new Station(fromStation));
            else
                trip.setFromStation(station);
        }
        if (toStation != "") {
            Station station = stationRepository.findStationByName(toStation);
            if(station == null)
                trip.setToStation(new Station(toStation));
            else
                trip.setToStation(station);
        }
    }

    public void deleteTrip(long id) {
        boolean exists = tripRepository.existsById(id);
        if (exists) {
            tripRepository.deleteById(id);
        } else throw new IllegalStateException("Sorry, there is no Trip with this id to delete!");
    }
}
