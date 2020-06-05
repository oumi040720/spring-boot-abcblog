package vn.com.abcblog.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.com.abcblog.dto.CommentDTO;
import vn.com.abcblog.entity.Comment;
import vn.com.abcblog.service.IPostService;

@Component
public class CommentConverter {
	
	@Autowired
	private IPostService postService;
	
	@Autowired
	private PostConverter postConverter;
	
	public CommentDTO convertToDTO(Comment comment) {
		CommentDTO dto = new CommentDTO();
		dto.setId(comment.getId());
		dto.setCreateBy(comment.getCreateBy());
		dto.setCreateDate(comment.getCreateDate());
		dto.setModifiedBy(comment.getModifiedBy());
		dto.setModifiedDate(comment.getModifiedDate());
		dto.setContent(comment.getContent());
		dto.setFlagDelete(comment.getFlagDelete());
		dto.setPostID(comment.getPost().getId());
		
		return dto;
	}
	
	public Comment convertToEntity(CommentDTO commentDTO) {
		Comment entity = new Comment();
		entity.setId(commentDTO.getId());
		entity.setCreateBy(commentDTO.getCreateBy());
		entity.setCreateDate(commentDTO.getCreateDate());
		entity.setModifiedBy(commentDTO.getModifiedBy());
		entity.setModifiedDate(commentDTO.getModifiedDate());
		entity.setContent(commentDTO.getContent());
		entity.setFlagDelete(commentDTO.getFlagDelete());
		entity.setPost(postConverter.convertToEntity(postService.findOneByID(commentDTO.getPostID())));
		
		return entity;
	}
	
	public Comment convertToEntity(CommentDTO commentDTO, Comment entity) {
		entity.setId(commentDTO.getId());
		entity.setCreateBy(commentDTO.getCreateBy());
		entity.setCreateDate(commentDTO.getCreateDate());
		entity.setModifiedBy(commentDTO.getModifiedBy());
		entity.setModifiedDate(commentDTO.getModifiedDate());
		entity.setContent(commentDTO.getContent());
		entity.setFlagDelete(commentDTO.getFlagDelete());
		entity.setPost(postConverter.convertToEntity(postService.findOneByID(commentDTO.getPostID())));
		
		return entity;
	}
	
}
