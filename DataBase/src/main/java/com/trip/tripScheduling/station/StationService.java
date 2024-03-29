package com.trip.tripScheduling.station;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StationService {

    private final StationRepository stationRepository;
    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }


    public List<Station> getStations() {
        return stationRepository.findAll();
    }

    public void storeStation(Station station) {
        Station stationOptional = stationRepository.findStationByName(station.getName());
        if (stationOptional != null)
        {
            throw new IllegalStateException("Sorry, this Station is already stored!");
        }
        stationRepository.save(station);
    }

    @Transactional
    public void updateStation(long id, String name) {
        Station station = stationRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Sorry, this Station isn't found!")
        );
        Station optionalStation = stationRepository.findStationByName(name);
        if (optionalStation != null)
        {
            throw new IllegalStateException("Sorry, this Station is already stored!");
        }
        station.setName(name);
    }

    public void deleteStation(long id) {
        boolean exists = stationRepository.existsById(id);
        if (exists)
        {
            stationRepository.deleteById(id);
        }
        else throw new IllegalStateException("Sorry, there is no Station with this id to delete!");
    }
}
