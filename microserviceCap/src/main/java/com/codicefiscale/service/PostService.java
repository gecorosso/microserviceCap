package com.codicefiscale.service;

import java.util.List;
import com.codicefiscale.entity.*;

public interface PostService  {
	public List<Post> getTuttiPost();
	public Post insertTuttiPost(Post postObj);
	
}
