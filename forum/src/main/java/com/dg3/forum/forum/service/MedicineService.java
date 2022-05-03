package com.dg3.forum.forum.service;

import com.dg3.forum.forum.entity.Medicine;

import java.util.List;

public interface MedicineService {
    /*
    * Create medicine
    * */
    Medicine createMedicine (Medicine medicine);

    /*
    * Update medicine
    * */
    void updateMedicine(Medicine medicine);

    /*
    * Delete medicine
    * */
    void deleteMedicine(Long medicine_pk);

    /*
    * Check exist information medicine through primary key medicine_pk
    * */
    Medicine checkExistByMedicine(Long medicine_pk);

    /*
    * Check exist information name medicine
    * */
    Medicine checkExistsByName_Medicine(String name_medicine, Long dealer_pk);

    /*
    * List all information medicine by dealer
    * */
    List<Medicine> listAllMedicine_Dealer(Long dealer_pk);
}
