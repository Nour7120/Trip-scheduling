package com.trip.tripScheduling.trip;

import com.example.rhelTest.station.Station;
import jakarta.persistence.*;


@Entity
@Table
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tripId;
    private String startTime;
    private String endTime;
    @ManyToOne(
            cascade = CascadeType.ALL // Solve the error of "object references an unsaved transient instance"
            /*
            indicates that when we persist, remove, refresh or merge this entity "Station" all the
            entities held in this field "Trip" would be persisted, removed, deleted or updated.
             */
    )
    @JoinColumn(name = "fromStationID", referencedColumnName = "stationId")
    private Station fromStation;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "toStationID2", referencedColumnName = "stationId")
    private Station toStation;

    public Trip() {
    }

    public Trip(String startTime, String endTime, Station fromStation, Station toStation) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public long getTripId() {
        return tripId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Station getFromStation() {
        return fromStation;
    }

    public void setFromStation(Station fromStation) {
        this.fromStation = fromStation;
    }

    public Station getToStation() {
        return toStation;
    }

    public void setToStation(Station toStation) {
        this.toStation = toStation;
    }
}
