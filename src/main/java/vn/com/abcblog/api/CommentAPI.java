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

import vn.com.abcblog.dto.CommentDTO;
import vn.com.abcblog.service.ICommentService;

@RestController
public class CommentAPI {

	@Autowired
	private ICommentService commentService;
	
	@GetMapping(value = "/api/comment")
	public List<CommentDTO> findAll() {
		return commentService.findAll();
	}
	
	@GetMapping(value = "/api/comment/list")
	public List<CommentDTO> findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		return commentService.findAll(page - 1, limit);
	}
	
	@GetMapping(value = "/api/comment/id/{id}")
	public CommentDTO findOneByID(@PathVariable("id") Long id) {
		return commentService.findOneByID(id);
	}

	@PostMapping(value = "/api/comment/insert")
	public Boolean insert(@RequestBody CommentDTO commentDTO) {
		return commentService.insert(commentDTO);
	}
	
	@PutMapping(value = "/api/comment/update/id/{id}")
	public Boolean update(@RequestBody CommentDTO commentDTO, @PathVariable("id") Long id) {
		commentDTO.setId(id);
		
		return commentService.insert(commentDTO);
	}
	
	@DeleteMapping(value = "/api/comment/delete/id/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return commentService.delete(id);
	}
	
}

