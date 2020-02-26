package com.comment.service.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.comment.service.demo.entity.CommentsEntity;
import com.comment.service.demo.service.CommentsService;

/**
 * Comments Controller.
 * 
 * @author yuvaraj
 *
 */
@RestController
@RequestMapping("/commentsApi")
@RestControllerAdvice
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	/**
	 * Fetching all comments.
	 * 
	 * @return comments list.
	 */
	@GetMapping(value = "/allComments")
	public List<CommentsEntity> getAllComments() {
		return commentsService.listComments();
	}

	/**
	 * Add new comment.
	 * 
	 * @param user new comments.
	 * @return status code.
	 */
	@PostMapping(value = "/saveComment")
	public ResponseEntity<?> saveComment(@Valid @RequestBody CommentsEntity comment) {
		commentsService.addComment(comment);
		return ResponseEntity.ok().build();
	}

	/**
	 * Update comment detail by comment id.
	 * 
	 * @param comment comment.
	 * @return status code.
	 */
	@PutMapping(value = "/updateComment")
	public ResponseEntity<?> updateComment(@Valid @RequestBody CommentsEntity comment) {
		commentsService.updateComment(comment);
		return ResponseEntity.ok().build();
	}

	/**
	 * Delete comment detail by comment id.
	 * 
	 * @param commentId
	 * @return status code.
	 */
	@DeleteMapping(value = "/removeComment/{commentId}")
	public ResponseEntity<?> removeComment(@PathVariable(value = "commentId") Long commentId) {
		commentsService.removeComment(commentId);
		return ResponseEntity.ok().build();
	}

	/**
	 * fetching comment detail by comment id.
	 * 
	 * @param commentId comment Id.
	 * @return comment detail.
	 */
	@GetMapping(value = "/getComment/{commentId}")
	public ResponseEntity<CommentsEntity> getComment(@PathVariable(value = "commentId") Long commentId) {
		return new ResponseEntity<>(commentsService.getComment(commentId), HttpStatus.OK);
	}

}
