package com.dg3.forum.forum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg3.forum.forum.entity.Image;
import com.dg3.forum.forum.repository.ImageRepository;
import com.dg3.forum.forum.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image createImagePosts(Image image) {
        image.setComment_pk(null);
        image.setImage_comment(null);
        image.setEnable_image(true);

        return imageRepository.save(image);
    }

    @Override
    public Image createImageComment(Image image) {
        image.setThread_pk(null);
        image.setImage_thread(null);
        image.setEnable_image(true);

        return imageRepository.save(image);
    }

    @Override
    public List<Image> listAllImagePosts(Long thread_pk) {
        return imageRepository.findByThread_pk(thread_pk);
    }

	@Override
	public List<Image> listAllImageComment() {
		
		return imageRepository.ListImageComment();
	}

	@Override
	public void deleteImageComment(Long image_pk) {
		imageRepository.deleteImageComment(image_pk);
		
	}
	/**
	 * check exist of image
	 * @param image_pk
	 * @return true or false
	 */
	@Override
	public boolean existById(Long image_pk) {
		return imageRepository.existsById(image_pk);
	}
}
