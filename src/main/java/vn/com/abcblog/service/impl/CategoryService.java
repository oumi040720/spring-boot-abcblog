package vn.com.abcblog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.com.abcblog.converter.CategoryConverter;
import vn.com.abcblog.dto.CategoryDTO;
import vn.com.abcblog.entity.Category;
import vn.com.abcblog.repository.CategoryRepository;
import vn.com.abcblog.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter converter;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> result = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll();
		
		for (Category category : categories) {
			result.add(converter.convertToDTO(category));
		}
		
		return result;
	}

	@Override
	public List<CategoryDTO> findAll(Integer page, Integer linmit) {
		List<CategoryDTO> result = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll(PageRequest.of(page, linmit)).getContent();
		
		for (Category category : categories) {
			result.add(converter.convertToDTO(category));
		}
		
		return result;
	}

	@Override
	public CategoryDTO findOneByID(Long id) {
		return converter.convertToDTO(categoryRepository.getOne(id));
	}

	@Override
	public CategoryDTO findOneByCategoryCode(String categoryCode) {
		return converter.convertToDTO(categoryRepository.findByCategoryCode(categoryCode));
	}

	@Override
	public Boolean insert(CategoryDTO categoryDTO) {
		Category category = converter.convertToEntity(categoryDTO);
		category.setCreateDate(new Date(System.currentTimeMillis()));
		category.setModifiedDate(new Date(System.currentTimeMillis()));
		
		Category result = categoryRepository.save(category);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean update(CategoryDTO categoryDTO) {
		Category oldCategory = categoryRepository.getOne(categoryDTO.getId());
		Category newCategory = converter.convertToEntity(categoryDTO, oldCategory);
		newCategory.setCreateDate(categoryDTO.getCreateDate());
		newCategory.setModifiedDate(new Date(System.currentTimeMillis()));
		
		Category result = categoryRepository.save(newCategory);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			categoryRepository.deleteById(id);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
