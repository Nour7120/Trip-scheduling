package com.example.rhelTest.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station, Long>{

    @Query("SELECT t FROM Station t WHERE t.name = ?1")
    Optional<Station> findStationByName(String name);
}