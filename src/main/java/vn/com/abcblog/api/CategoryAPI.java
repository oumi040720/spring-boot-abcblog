package vn.com.abcblog.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.abcblog.dto.CategoryDTO;
import vn.com.abcblog.service.ICategoryService;

@RestController
public class CategoryAPI {

	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping(value = "/api/category")
	public List<CategoryDTO> findAll() {
		return categoryService.findAll();
	}
	
	@GetMapping(value = "/api/category/list")
	public List<CategoryDTO> findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		return categoryService.findAll(page - 1, limit);
	}
	
	@GetMapping(value = "/api/category/id/{id}")
	public CategoryDTO findOneByID(@PathVariable("id") Long id) {
		return categoryService.findOneByID(id);
	}
	
	@GetMapping(value = "/api/category/category_code/{categoryCode}")
	public CategoryDTO findOneByCategoryCode(@PathVariable("categoryCode") String categoryCode) {
		return categoryService.findOneByCategoryCode(categoryCode);
	}
	
	@PostMapping(value = "/api/category/insert")
	public Boolean insert(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.insert(categoryDTO);
	}

	@PutMapping(value = "/api/category/update/id/{id}")
	public Boolean update(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Long id) {
		categoryDTO.setId(id);
		
		return categoryService.insert(categoryDTO);
	}
	
	@DeleteMapping(value = "/api/category/delete/id/{id}")
	public Boolean delete( @PathVariable("id") Long id) {
		return categoryService.delete(id);
	}
	
}
