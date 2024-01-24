package com.app.Trainbooking.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Trainbooking.entity.User;
import com.app.Trainbooking.enumclass.SeatSection;

public interface UserRepo extends JpaRepository<User, UUID> {

	void deleteByReceiptId(UUID id);

	List<User> findBySeatSection(SeatSection section);

}
