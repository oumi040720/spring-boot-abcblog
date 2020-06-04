package vn.com.abcblog.service;

import java.util.List;

import vn.com.abcblog.dto.RoleDTO;

public interface IRoleService {

	public List<RoleDTO> findAll();
	
	public RoleDTO findOneByID(Long id);
	
	public RoleDTO findOneByRoleCode(String roleCode);
	
	public Boolean insert(RoleDTO roleDTO);
	
	public Boolean update(RoleDTO roleDTO);
	
	public Boolean delete(Long id);
	
}
