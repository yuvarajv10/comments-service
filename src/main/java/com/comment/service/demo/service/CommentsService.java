package com.comment.service.demo.service;

import java.util.List;
import com.comment.service.demo.entity.CommentsEntity;

/**
 * Users comment related services.
 * 
 * @author yuvaraj
 *
 */
public interface CommentsService {

	/**
	 * Fetching all comments.
	 * 
	 * @return comments list.
	 */
	List<CommentsEntity> listComments();

	/**
	 * Add new comment.
	 * 
	 * @param user new comments.
	 * @return
	 * @return status code.
	 */
	void addComment(CommentsEntity comment);

	/**
	 * Update comment detail by comment id.
	 * 
	 * @param comment comment.
	 * @return status code.
	 */
	void updateComment(CommentsEntity comment);

	/**
	 * Delete comment detail by comment id.
	 * 
	 * @param commentId
	 * @return status code.
	 */
	void removeComment(Long commentId);

	/**
	 * fetching comment detail by comment id.
	 * 
	 * @param commentId comment Id.
	 * @return comment detail.
	 */
	CommentsEntity getComment(Long commentId);

}
