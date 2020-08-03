package com.codicefiscale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codicefiscale.entity.Post;

public interface PostRepositoryDao extends JpaRepository<Post, Long> {
	//List<Post> getTuttiPost();
	
}
