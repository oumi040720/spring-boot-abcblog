package vn.com.abcblog.converter;

import org.springframework.stereotype.Component;

import vn.com.abcblog.dto.CategoryDTO;
import vn.com.abcblog.entity.Category;

@Component
public class CategoryConverter {
	
	public CategoryDTO convertToDTO(Category category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setCreateBy(category.getCreateBy());
		dto.setCreateDate(category.getCreateDate());
		dto.setModifiedBy(category.getModifiedBy());
		dto.setModifiedDate(category.getModifiedDate());
		dto.setCategoryName(category.getCategoryName());
		dto.setCategoryCode(category.getCategoryCode());
		
		return dto;
	}
	
	public Category convertToEntity(CategoryDTO categoryDTO) {
		Category entity = new Category();
		entity.setId(categoryDTO.getId());
		entity.setCreateBy(categoryDTO.getCreateBy());
		entity.setCreateDate(categoryDTO.getCreateDate());
		entity.setModifiedBy(categoryDTO.getModifiedBy());
		entity.setModifiedDate(categoryDTO.getModifiedDate());
		entity.setCategoryName(categoryDTO.getCategoryName());
		entity.setCategoryCode(categoryDTO.getCategoryCode());
		
		return entity;
	}
	
	public Category convertToEntity(CategoryDTO categoryDTO, Category entity) {
		entity.setId(categoryDTO.getId());
		entity.setCreateBy(categoryDTO.getCreateBy());
		entity.setCreateDate(categoryDTO.getCreateDate());
		entity.setModifiedBy(categoryDTO.getModifiedBy());
		entity.setModifiedDate(categoryDTO.getModifiedDate());
		entity.setCategoryName(categoryDTO.getCategoryName());
		entity.setCategoryCode(categoryDTO.getCategoryCode());
		
		return entity;
	}
	
}
