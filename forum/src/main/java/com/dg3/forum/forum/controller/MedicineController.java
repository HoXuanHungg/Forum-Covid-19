package com.dg3.forum.forum.controller;

import com.dg3.forum.forum.entity.Medicine;
import com.dg3.forum.forum.entity.Message;
import com.dg3.forum.forum.entity.Users;
import com.dg3.forum.forum.service.MedicineService;
import com.dg3.forum.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Message> createMedicine(@RequestBody Medicine medicine){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Users users = userService.findByEmail(userDetails.getUsername());

        Medicine checkMedicine = medicineService.checkExistsByName_Medicine(medicine.getName_medicine(), users.getUser_pk());

        if(checkMedicine == null){
            medicine.setDealer_pk(users.getUser_pk());

            return ResponseEntity.status(HttpStatus.OK).body(
                    new Message("OK", "Create medicine succesfully", medicineService.createMedicine(medicine))
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Message("Failed", "Name medicine exist", "")
            );
        }
    }

    @PutMapping("/update/{medicine_pk}")
    public ResponseEntity<Message> updateMedicine(@RequestBody Medicine medicine, @PathVariable("medicine_pk") Long medicine_pk){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Users users = userService.findByEmail(userDetails.getUsername());

        medicine.setDealer_pk(users.getUser_pk());
        medicine.setMedicine_pk(medicine_pk);

        medicineService.updateMedicine(medicine);

        return ResponseEntity.status(HttpStatus.OK).body(
                new Message("OK", "Update medicine succesfully", "")
        );
    }

    @DeleteMapping("/delete/{medicine_pk}")
    public ResponseEntity<Message> deleteMedicine(@PathVariable("medicine_pk") Long medicine_pk){
        if(medicineService.checkExistByMedicine(medicine_pk) != null){
            medicineService.deleteMedicine(medicine_pk);

            if(medicineService.checkExistByMedicine(medicine_pk) == null){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Message("OK", "Delete medicine succesfully", "")
                );
            } else{
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new Message("Failed", "Delete medicine unsuccesfully", "")
                );
            }
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Message("Failed", "Cannot find medicine to delete", "")
            );
        }
    }

    @GetMapping("/all/medicine")
    public ResponseEntity<Message> listAllMedicine_Dealer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Users users = userService.findByEmail(userDetails.getUsername());

        List<Medicine> list = medicineService.listAllMedicine_Dealer(users.getUser_pk());

        return list.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                   new Message("Failed", "Can't find medicine by " + users.getUsername(),"")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                  new Message("OK", "Find list medicine by " + users.getUsername(), list)
                );
    }
}
