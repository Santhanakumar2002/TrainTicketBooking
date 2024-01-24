package com.app.Trainbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Trainbooking.entity.Receipt;
import com.app.Trainbooking.entity.User;
import com.app.Trainbooking.enumclass.SeatSection;
import com.app.Trainbooking.repository.TrainRepository;
import com.app.Trainbooking.repository.UserRepo;

@Service
public class TrainService {
	@Autowired
    private TrainRepository trainRepository;
	
	@Autowired
    private UserRepo userRepo;

   

public List<Receipt> getAll(){
	
	return  (List<Receipt>) trainRepository.findAll();
}
@Transactional
public String deleteById(UUID id) {
	Receipt recipt =trainRepository.findById(id).orElse(null);
	if(recipt != null) {
		userRepo.deleteByReceiptId(id);
		trainRepository.delete(recipt);
	}
	
	return "deleted successfully";
}

public Receipt modifyUserSeat(Receipt receipt) {
	
	return trainRepository.save(receipt);
}
private String allocateSeat(String section) {
        
        return "1";
    }
	public Receipt submitPurchase(Receipt request) {
	    Receipt receipt = new Receipt();
	    receipt.setFrom(request.getFrom());
	    receipt.setTo(request.getTo());
	    receipt.setPricePaid(request.getPricePaid());
	    receipt = trainRepository.save(receipt);

	    List<User> userList = new ArrayList<>();
	    for (User userRequest : request.getUsers()) {
//	        String seatSection = userRequest.getEmail().endsWith("@example.com") ? "B" : "A";
//	        String seatNumber = allocateSeat(seatSection);
	        User user = new User();
	        
	        user.setFirstName(userRequest.getFirstName());
	        user.setLastName(userRequest.getLastName());
	        user.setEmail(userRequest.getEmail());
	        user.setReceipt(receipt);
	        user.setSeatSection(userRequest.getSeatSection());
	        user.setSeatNumber(userRequest.getSeatNumber());
	        userList.add(user);
	    }
	    userRepo.saveAll(userList); 
	    receipt.setUsers(userList);
	    trainRepository.save(receipt);
	    return receipt;
	}

 
	public Receipt modifyUserSeat(UUID userId, User seatModificationRequest) {
	    User userToUpdate = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

	    // Update seat information
	    userToUpdate.setSeatSection(seatModificationRequest.getSeatSection());

	    userToUpdate.setSeatNumber(seatModificationRequest.getSeatNumber());

	    // Save the modified user
	    userRepo.save(userToUpdate);

	    // Return the updated receipt
	    return userToUpdate.getReceipt();
	}
	public Object getById( UUID userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Receipt receipt = user.getReceipt();
		return receipt;
	}
	public Object getBySection(SeatSection section) {
		 List<User> users = userRepo.findBySeatSection(section);
		return users;
	}
	
	

}


