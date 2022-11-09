package com.example.rhelTest.station;

import com.example.rhelTest.trip.Trip;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;
    private String name;
    @OneToMany(mappedBy = "fromStation", cascade = CascadeType.ALL)
    private List<Trip> tripsFromStation;
    @OneToMany(mappedBy = "toStation", cascade = CascadeType.ALL)
    private List<Trip> tripsToStation;

    public Station() {
    }

    public Station(String name) {
        this.name = name;
    }

    public Long getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}