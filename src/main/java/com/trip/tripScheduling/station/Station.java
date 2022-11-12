package com.trip.tripScheduling.station;

import com.trip.tripScheduling.trip.Trip;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stationId")
    private Long id;
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
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}