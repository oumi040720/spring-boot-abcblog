package vn.com.abcblog.converter;

import org.springframework.stereotype.Component;

import vn.com.abcblog.dto.RoleDTO;
import vn.com.abcblog.entity.Role;

@Component
public class RoleConverter {
	
	public RoleDTO convertToDTO(Role role) {
		RoleDTO dto = new RoleDTO();
		dto.setId(role.getId());
		dto.setCreateBy(role.getCreateBy());
		dto.setCreateDate(role.getCreateDate());
		dto.setModifiedBy(role.getModifiedBy());
		dto.setModifiedDate(role.getModifiedDate());
		dto.setRoleName(role.getRoleName());
		dto.setRoleCode(role.getRoleCode());
		
		return dto;
	}
	
	public Role convertToEntity(RoleDTO roleDTO) {
		Role entity = new Role();
		entity.setId(roleDTO.getId());
		entity.setCreateBy(roleDTO.getCreateBy());
		entity.setCreateDate(roleDTO.getCreateDate());
		entity.setModifiedBy(roleDTO.getModifiedBy());
		entity.setModifiedDate(roleDTO.getModifiedDate());
		entity.setRoleName(roleDTO.getRoleName());
		entity.setRoleCode(roleDTO.getRoleCode());
		
		return entity;
	}
	
	public Role convertToEntity(RoleDTO roleDTO, Role entity) {
		entity.setId(roleDTO.getId());
		entity.setCreateBy(roleDTO.getCreateBy());
		entity.setCreateDate(roleDTO.getCreateDate());
		entity.setModifiedBy(roleDTO.getModifiedBy());
		entity.setModifiedDate(roleDTO.getModifiedDate());
		entity.setRoleName(roleDTO.getRoleName());
		entity.setRoleCode(roleDTO.getRoleCode());
		
		return entity;
	}
	
}
