package com.dg3.forum.forum.repository;

import com.dg3.forum.forum.entity.Like;
import com.dg3.forum.forum.entity.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    /*
     * Update medicine
     * */
    @Modifying
    @Transactional
    @Query(value = "update medicine set name_medicine = :name_medicine," +
            "where_production = :where_production," +
            "price = :price, effect = :effect," +
            "details_medicine = :details_medicine " +
            "where medicine_pk = :medicine_pk and dealer_pk = :dealer_pk", nativeQuery = true)
    void updateMedicine (@Param("name_medicine") String name_medicine, @Param("where_production") String where_production,
                         @Param("price") String price, @Param("effect") String effect,
                         @Param("details_medicine") String details_medicine,
                         @Param("medicine_pk") Long medicine_pk, @Param("dealer_pk") Long dealer_pk);

    /*
     * Delete medicine
     */
    @Modifying
    @Transactional
    @Query(value = "delete from medicine where medicine_pk = :medicine_pk", nativeQuery = true)
    void deleteMedicine (@Param("medicine_pk") Long medicine_pk);

    /*
     * Find information by medicine through the main key medicine_pk table medicine
     * */
    @Transactional
    @Query(value = "select * from medicine where medicine_pk = :medicine_pk", nativeQuery = true)
    Medicine getByMedicine_pk(@Param("medicine_pk") Long medicine_pk);

    /*
     * Find information by medicine through the name_medicine table medicine
     * */
    @Transactional
    @Query(value = "select * from medicine where name_medicine = :name_medicine and dealer_pk = :dealer_pk", nativeQuery = true)
    Medicine getByName_medicine(@Param("name_medicine") String name_medicine, @Param("dealer_pk") Long dealer_pk);

    /*
     * List all information medicine by dealer
     * */
    @Transactional
    @Query(value = "select medicine.* from medicine " +
            "inner join users on users.user_pk = medicine.dealer_pk " +
            "where medicine.dealer_pk = :dealer_pk order by name_medicine DESC", nativeQuery = true)
    List<Medicine> listAllByMedicineUser_Dealer(@Param("dealer_pk") Long dealer_pk);

    /*
     *   Show list medicine, sort descending by name medicine
     * */
    @Transactional
    @Query(value = "select * from medicine order by name_medicine DESC", nativeQuery = true)
    Page<Medicine> pageMedicine_Dealer(Pageable pageable);
}
