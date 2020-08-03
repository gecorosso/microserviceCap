package com.codicefiscale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.PostRepositoryDao;
import com.codicefiscale.entity.Post;

@Service
public class PostServiceImpl implements PostService {
    @Autowired PostRepositoryDao postRepositoryDao;
	
	@Override
	public List<Post> getTuttiPost() {
		postRepositoryDao.findAll();
		return null;
	}

	@Override
	public Post insertTuttiPost(Post postObj) {
		Post insPost = postRepositoryDao.save(postObj);
		return insPost;
	}

	
}
