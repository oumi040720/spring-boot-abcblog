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

import vn.com.abcblog.dto.PostDTO;
import vn.com.abcblog.service.IPostService;

@RestController
public class PostAPI {

	@Autowired
	private IPostService postService;
	
	@GetMapping(value = "/api/post")
	public List<PostDTO> findAll() {
		return postService.findAll();
	}
	
	@GetMapping(value = "/api/post/list")
	public List<PostDTO> findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		return postService.findAll(page - 1, limit);
	}
	
	@GetMapping(value = "/api/post/id/{id}")
	public PostDTO findOneByID(@PathVariable("id") Long id) {
		return postService.findOneByID(id);
	}
	
	@GetMapping(value = "/api/post/post_code/{postCode}")
	public PostDTO findOneByPostCode(@PathVariable("postCode") String postCode) {
		return postService.findOneByPostCode(postCode);
	}
	
	@PostMapping(value = "/api/post/insert")
	public Boolean insert(@RequestBody PostDTO postDTO) {
		return postService.insert(postDTO);
	}
	
	@PutMapping(value = "/api/post/update/id/{id}")
	public Boolean update(@RequestBody PostDTO postDTO, @PathVariable("id") Long id) {
		postDTO.setId(id);
		
		return postService.update(postDTO);
	}
	
	@DeleteMapping(value = "/api/post/delete/id/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return postService.delete(id);
	}
	
}
