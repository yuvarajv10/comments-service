package com.comment.service.demo.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comment.service.demo.entity.CommentsEntity;
import com.comment.service.demo.exceptionhandler.RecordNotFoundException;
import com.comment.service.demo.repository.CommentsRepository;
import com.comment.service.demo.service.CommentsService;

/**
 * User's comment related business logic will be here.
 * 
 * @author yuvaraj
 *
 */
@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;

	/**
	 * Fetching all comments.
	 * 
	 * @return comments list.
	 */
	@Override
	public List<CommentsEntity> listComments() {
		final List<CommentsEntity> listUserComments = commentsRepository.findAll();
		if (listUserComments.isEmpty()) {
			throw new RecordNotFoundException("Comment", "comment", "list");
		}
		return listUserComments;
	}

	/**
	 * Add new comment.
	 * 
	 * @param user new comments.
	 * @return
	 * @return status code.
	 */
	@Override
	@Transactional
	public void addComment(CommentsEntity comment) {
		commentsRepository.saveAndFlush(comment);
	}

	/**
	 * Update comment detail by comment id.
	 * 
	 * @param comment comment.
	 * @return status code.
	 */
	@Override
	@Transactional
	public void updateComment(CommentsEntity comment) {
		CommentsEntity commentEntity = getComment(comment.getId());
		commentEntity.setTitle(comment.getTitle());
		commentEntity.setComment(comment.getComment());
		commentsRepository.save(commentEntity);
	}

	/**
	 * Delete comment detail by comment id.
	 * 
	 * @param commentId
	 * @return status code.
	 */
	@Override
	@Transactional
	public void removeComment(final Long commentId) {
		CommentsEntity commentEntity = getComment(commentId);
		commentsRepository.delete(commentEntity);
	}

	/**
	 * fetching comment detail by comment id.
	 * 
	 * @param commentId comment Id.
	 * @return comment detail.
	 */
	@Override
	public CommentsEntity getComment(final Long commentId) {
		return commentsRepository.findById(commentId)
				.orElseThrow(() -> new RecordNotFoundException("Comment", "comment", commentId));
	}

}
