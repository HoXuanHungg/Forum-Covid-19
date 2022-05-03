package com.dg3.forum.forum.repository;

import com.dg3.forum.forum.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
   /**
    * 
    * @param thread_pk
    * @return List information posts
    */
    @Modifying
    @Transactional
    @Query(value = "select * from image where thread_pk = :thread_pk", nativeQuery = true)
    List<Image> findByThread_pk(Long thread_pk);
    
 /**
  *  
  * @return list image for comment
  */
    @Query(value = "select * from image where enable_image = true and image_thread is null", nativeQuery = true)
    List<Image> ListImageComment();
    
    /**
     * delete image comment
     * @param image_pk
     */
    @Modifying
    @Transactional
    @Query(value = "delete from image where image_pk = :image_pk and image_comment is not null", nativeQuery = true)
    void deleteImageComment(@Param("image_pk") Long image_pk);

	
    
	
}
