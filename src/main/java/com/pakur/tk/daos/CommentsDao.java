package com.pakur.tk.daos;

import java.util.List;

import com.pakur.tk.models.WebsiteComments;

public interface CommentsDao {
	
	public void addComments(WebsiteComments websiteComments);
	public List<WebsiteComments> getAllComments();
	public void deleteComments(long id);
	public void updateComments(WebsiteComments websiteComments);

}
