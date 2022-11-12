package com.trip.tripScheduling.trip;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.trip.tripScheduling.station.Station;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;


@Entity
@Table
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tripId")
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;
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

    public Trip(LocalDateTime startTime, LocalDateTime endTime, Station fromStation, Station toStation) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public long getTripId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
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
