package com.app.Trainbooking.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Trainbooking.entity.Receipt;
import com.app.Trainbooking.entity.User;
import com.app.Trainbooking.enumclass.SeatSection;
import com.app.Trainbooking.service.TrainService;

@RestController
@RequestMapping("/train")
public class TrainController {
	@Autowired
	private TrainService trainService;

    @PostMapping("/purchase")
    public Receipt yourControllerMethod(@RequestBody Receipt request) {
        return trainService.submitPurchase(request);
    }

   
    @DeleteMapping("/remove/{id}")
    public String deleteByEducationId(@PathVariable("id")UUID id) {
        return trainService.deleteById(id);
    }
    

//    @PutMapping("/modify-user")
//    public Receipt modifyUserSeat(@RequestBody Receipt receipt) {
//        return trainService.modifyUserSeat(receipt);
//    }
//    @GetMapping("/getAllReceipt")
//    public ResponseEntity<List<Receipt>>getallReceipt() {
//    	return ResponseEntity.ok(trainService.getAll());
//    }
    
    @PutMapping("/modify-seat/{userId}")
    public ResponseEntity<Receipt> modifyUserSeat(@PathVariable("userId") UUID userId, @RequestBody User seatModificationRequest) {
        Receipt modifiedReceipt = trainService.modifyUserSeat(userId, seatModificationRequest);
        return ResponseEntity.ok(modifiedReceipt);
    }
    @GetMapping("/get-receipt/{userId}")
    public ResponseEntity<Object> getReceiptForUser(@PathVariable("userId") UUID userId) {
    	return ResponseEntity.ok(trainService.getById(userId));
    	
        
    }
    @GetMapping("/getBySection/{section}")
    public ResponseEntity<Object> getUsersBySection(@PathVariable("section") SeatSection section) {
    	return ResponseEntity.ok(trainService.getBySection(section));
      
    }
    

    
   
}
