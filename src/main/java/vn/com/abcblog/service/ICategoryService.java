package vn.com.abcblog.service;

import java.util.List;

import vn.com.abcblog.dto.CategoryDTO;

public interface ICategoryService {

	public List<CategoryDTO> findAll();
	
	public List<CategoryDTO> findAll(Integer page, Integer linmit);
	
	public CategoryDTO findOneByID(Long id);
	
	public CategoryDTO findOneByCategoryCode(String categoryCode);
	
	public Boolean insert(CategoryDTO categoryDTO);
	
	public Boolean update(CategoryDTO categoryDTO);
	
	public Boolean delete(Long id);
	
}
