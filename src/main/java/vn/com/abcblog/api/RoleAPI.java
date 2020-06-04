package vn.com.abcblog.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.com.abcblog.dto.RoleDTO;
import vn.com.abcblog.service.IRoleService;

@RestController
public class RoleAPI {

	@Autowired
	private IRoleService roleService;
	
	@GetMapping(value = "/api/role")
	public List<RoleDTO> findAll() {
		return roleService.findAll();
	}

	@GetMapping(value = "/api/role/id/{id}")
	public RoleDTO findOneByID(@PathVariable("id") Long id) {
		return roleService.findOneByID(id);
	}

	@GetMapping(value = "/api/role/role_code/{roleCode}")
	public RoleDTO findOneByID(@PathVariable("roleCode") String roleCode) {
		return roleService.findOneByRoleCode(roleCode);
	}

	@PostMapping(value = "/api/role/insert")
	public Boolean insert(@RequestBody RoleDTO roleDTO) {
		return roleService.insert(roleDTO);
	}

	@PutMapping(value = "/api/role/update/id/{id}")
	public Boolean update(@RequestBody RoleDTO roleDTO, @PathVariable("id") Long id) {
		roleDTO.setId(id);
		
		return roleService.update(roleDTO);
	}

	@DeleteMapping(value = "/api/role/delete/id/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return roleService.delete(id);
	}

}
