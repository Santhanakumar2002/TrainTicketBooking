package com.app.Trainbooking.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Trainbooking.entity.Receipt;
@Repository
public interface TrainRepository extends JpaRepository<Receipt, UUID> {

}
