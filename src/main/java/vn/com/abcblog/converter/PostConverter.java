package vn.com.abcblog.converter;

import org.springframework.stereotype.Component;

import vn.com.abcblog.dto.PostDTO;
import vn.com.abcblog.entity.Post;

@Component
public class PostConverter {
	
	public PostDTO convertToDTO(Post post) {
		PostDTO dto = new PostDTO();
		dto.setId(post.getId());
		dto.setCreateBy(post.getCreateBy());
		dto.setCreateDate(post.getCreateDate());
		dto.setModifiedBy(post.getModifiedBy());
		dto.setModifiedDate(post.getModifiedDate());
		dto.setThumbnail(post.getThumbnail());
		dto.setTitle(post.getTitle());
		dto.setDescription(post.getDescription());
		dto.setContent(post.getContent());
		dto.setPostCode(post.getPostCode());
		dto.setFlagDelete(post.getFlagDelete());
		
		return dto;
	}
	
	public Post convertToEntity(PostDTO postDTO) {
		Post entity = new Post();
		entity.setId(postDTO.getId());
		entity.setCreateBy(postDTO.getCreateBy());
		entity.setCreateDate(postDTO.getCreateDate());
		entity.setModifiedBy(postDTO.getModifiedBy());
		entity.setModifiedDate(postDTO.getModifiedDate());
		entity.setThumbnail(postDTO.getThumbnail());
		entity.setTitle(postDTO.getTitle());
		entity.setDescription(postDTO.getDescription());
		entity.setContent(postDTO.getContent());
		entity.setPostCode(postDTO.getPostCode());
		entity.setFlagDelete(postDTO.getFlagDelete());
		
		return entity;
	}
	
	public Post convertToEntity(PostDTO postDTO, Post entity) {
		entity.setId(postDTO.getId());
		entity.setCreateBy(postDTO.getCreateBy());
		entity.setCreateDate(postDTO.getCreateDate());
		entity.setModifiedBy(postDTO.getModifiedBy());
		entity.setModifiedDate(postDTO.getModifiedDate());
		entity.setThumbnail(postDTO.getThumbnail());
		entity.setTitle(postDTO.getTitle());
		entity.setDescription(postDTO.getDescription());
		entity.setContent(postDTO.getContent());
		entity.setPostCode(postDTO.getPostCode());
		entity.setFlagDelete(postDTO.getFlagDelete());
		
		return entity;
	}
	
}
