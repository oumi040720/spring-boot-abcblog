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

import vn.com.abcblog.dto.UserDTO;
import vn.com.abcblog.service.IUserService;

@RestController
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/api/user")
	public List<UserDTO> findAll() {
		return userService.findAll();
	}
	
	@GetMapping(value = "/api/user/list")
	public List<UserDTO> findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		return userService.findAll(page - 1, limit);
	}
	
	@GetMapping(value = "/api/user/id/{id}")
	public UserDTO findOneByID(@PathVariable("id") Long id) {
		return userService.findOneByID(id);
	}
	
	@GetMapping(value = "/api/user/username/{username}")
	public UserDTO findOneByUsername(@PathVariable("username") String username) {
		return userService.findOneByUsername(username);
	}
	
	@PostMapping(value = "/api/user/insert")
	public Boolean insert(@RequestBody UserDTO userDTO) {
		return userService.insert(userDTO);
	}
	
	@PutMapping(value = "/api/user/update/id/{id}")
	public Boolean update(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
		userDTO.setId(id);
		
		return userService.insert(userDTO);
	}
	
	@DeleteMapping(value = "/api/user/delete/id/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return userService.delete(id);
	}
	
}
