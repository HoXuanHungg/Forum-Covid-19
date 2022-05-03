package com.dg3.forum.forum.service;

import com.dg3.forum.forum.dto.CommentImagedto;
import com.dg3.forum.forum.entity.Image;

import java.util.List;

public interface ImageService {
    /*
    * Create image posts
    * */
    Image createImagePosts(Image image);

    /*
    * Create image comment
    * */
    Image createImageComment(Image image);

    /*
    * List information image posts
    * */
    List<Image> listAllImagePosts(Long thread_pk);
    
    /**
     * List all image Comment
     * @return list image comment
     */
    List<Image> listAllImageComment();
    
    /**
     * delete image comment
     * @param image_pk
     */
    void deleteImageComment(Long image_pk);
    

	/**
	 * check exist id of image
	 * @param image_pk
	 * @return true or false
	 */
	public boolean existById(Long image_pk);
    
}
