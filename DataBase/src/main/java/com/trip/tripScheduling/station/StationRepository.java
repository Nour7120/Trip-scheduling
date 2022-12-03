package com.trip.tripScheduling.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    @Query("SELECT t FROM Station t WHERE t.name = ?1")
    Station findStationByName(String name);
}
