package vn.com.abcblog.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.com.abcblog.dto.TagDTO;
import vn.com.abcblog.entity.Tag;
import vn.com.abcblog.service.ICategoryService;
import vn.com.abcblog.service.IPostService;

@Component
public class TagConverter {
	
	@Autowired
	private IPostService postService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private PostConverter postConverter;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	public TagDTO convertToDTO(Tag tag) {
		TagDTO dto = new TagDTO();
		dto.setId(tag.getId());
		dto.setCreateBy(tag.getCreateBy());
		dto.setCreateDate(tag.getCreateDate());
		dto.setModifiedBy(tag.getModifiedBy());
		dto.setModifiedDate(tag.getModifiedDate());
		dto.setPostID(tag.getPost().getId());
		dto.setCategoryID(tag.getCategory().getId());
		
		return dto;
	}
	
	public Tag convertToEntity(TagDTO tagDTO) {
		Tag entity = new Tag();
		entity.setId(tagDTO.getId());
		entity.setCreateBy(tagDTO.getCreateBy());
		entity.setCreateDate(tagDTO.getCreateDate());
		entity.setModifiedBy(tagDTO.getModifiedBy());
		entity.setModifiedDate(tagDTO.getModifiedDate());
		entity.setPost(postConverter.convertToEntity(postService.findOneByID(tagDTO.getPostID())));
		entity.setCategory(categoryConverter.convertToEntity(categoryService.findOneByID(tagDTO.getCategoryID())));
		
		return entity;
	}
	
	public Tag convertToEntity(TagDTO tagDTO, Tag entity) {
		entity.setId(tagDTO.getId());
		entity.setCreateBy(tagDTO.getCreateBy());
		entity.setCreateDate(tagDTO.getCreateDate());
		entity.setModifiedBy(tagDTO.getModifiedBy());
		entity.setModifiedDate(tagDTO.getModifiedDate());
		entity.setPost(postConverter.convertToEntity(postService.findOneByID(tagDTO.getPostID())));
		entity.setCategory(categoryConverter.convertToEntity(categoryService.findOneByID(tagDTO.getCategoryID())));
		
		return entity;
	}
	
}
