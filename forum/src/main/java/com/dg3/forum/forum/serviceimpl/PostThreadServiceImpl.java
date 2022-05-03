package com.dg3.forum.forum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg3.forum.forum.entity.PostThread;
import com.dg3.forum.forum.repository.PostThreadRepository;
import com.dg3.forum.forum.repository.UserstRepository;
import com.dg3.forum.forum.service.PostThreadService;

@Service
public class PostThreadServiceImpl implements PostThreadService {
    @Autowired
    private UserstRepository userstRepository;

    @Autowired
    private PostThreadRepository postThreadRepository;

    /*
     * List all post by user
     * */
    @Override
    public List<PostThread> listAllPost_User (Long user_pk){
        return postThreadRepository.findAll_User(user_pk);
    }

    @Override
    public PostThread savePosts (PostThread postThread){
        boolean enable_post_thread = true;
        boolean approved = false;

        postThread.setEnable_post_thread(enable_post_thread);
        postThread.setApproved(approved);

        return postThreadRepository.save(postThread);
    }

    @Override
    public void updatePosts (PostThread postThread){
        String title_thread = postThread.getTitle_thread();
        String content_of_thread = postThread.getContent_of_thread();
        Long post_topic_pk = postThread.getPost_topic_pk();
        Long thread_pk = postThread.getThread_pk();

        postThreadRepository.updateByPosts(title_thread,content_of_thread,post_topic_pk,thread_pk);
    }

    @Override
    public void deletePosts (Long thread_pk){
        postThreadRepository.deleteByPosts(thread_pk);
    }

    @Override
    public PostThread checkExistByThread_pk (Long thread_pk){
        return postThreadRepository.existByThread_pk(thread_pk);
    }

    @Override
    public List<PostThread> listAllPosts(){
        return postThreadRepository.findByAllPosts();
    }

    @Override
    public void updateApproved(boolean approved, Long thread_pk){
        postThreadRepository.updateApproved(approved, thread_pk);
    }

    @Override
    public void updateEnable_post_thread(boolean enable_post_thread, Long thread_pk){
        postThreadRepository.updateEnable_post_thread(enable_post_thread, thread_pk);
    }

    @Override
    public List<PostThread> showAllPosts_NotApproved() {
        return postThreadRepository.findByAllPosts_NotApproved();
    }

    
    
	@Override
	public int approvedPost(Long thread_pk) {
		if (thread_pk!=null) {
			postThreadRepository.approvedPost(thread_pk);
			return 1;
		}
		return 0;
	}

	@Override
	public PostThread getAnPostThrest(Long thread_pk) {
	 return	postThreadRepository.getAnPostThrest(thread_pk);
		
	}
}
