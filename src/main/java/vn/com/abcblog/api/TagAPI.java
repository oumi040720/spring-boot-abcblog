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

import vn.com.abcblog.dto.TagDTO;
import vn.com.abcblog.service.ITagService;

@RestController
public class TagAPI {

	@Autowired
	private ITagService tagService;
	
	@GetMapping(value = "/api/tag")
	public List<TagDTO> findAll() {
		return tagService.findAll();
	}
	
	@GetMapping(value = "/api/tag/list")
	public List<TagDTO> findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		return tagService.findAll(page - 1, limit);
	}
	
	@GetMapping(value = "/api/tag/id/{id}")
	public TagDTO findOneByID(@PathVariable("id") Long id) {
		return tagService.findOneByID(id);
	}
	
	@PostMapping(value = "/api/tag/insert")
	public Boolean insert(@RequestBody TagDTO tagDTO) {
		return tagService.insert(tagDTO);
	}
	
	@PutMapping(value = "/api/tag/update/id/{id}")
	public Boolean update(@RequestBody TagDTO tagDTO, @PathVariable("id") Long id) {
		tagDTO.setId(id);
		
		return tagService.update(tagDTO);
	}
	
	@DeleteMapping(value = "/api/tag/delete/id/{id}")
	public Boolean delete( @PathVariable("id") Long id) {
		return tagService.delete(id);
	}
	
}
