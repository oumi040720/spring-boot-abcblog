package vn.com.abcblog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.abcblog.converter.RoleConverter;
import vn.com.abcblog.dto.RoleDTO;
import vn.com.abcblog.entity.Role;
import vn.com.abcblog.repository.RoleRepository;
import vn.com.abcblog.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter converter;
	
	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> result = new ArrayList<>();
		List<Role> roles = roleRepository.findAll();
		
		for (Role role : roles) {
			result.add(converter.convertToDTO(role));
		}
		
		return result;
	}

	@Override
	public RoleDTO findOneByID(Long id) {
		return converter.convertToDTO(roleRepository.getOne(id));
	}

	@Override
	public RoleDTO findOneByRoleCode(String roleCode) {
		return converter.convertToDTO(roleRepository.findByRoleCode(roleCode));
	}

	@Override
	public Boolean insert(RoleDTO roleDTO) {
		Role role = converter.convertToEntity(roleDTO);
		role.setCreateDate(new Date(System.currentTimeMillis()));
		role.setModifiedDate(new Date(System.currentTimeMillis()));
		
		Role result = roleRepository.save(role);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean update(RoleDTO roleDTO) {
		Role oldRole = roleRepository.getOne(roleDTO.getId());
		Role newRole = converter.convertToEntity(roleDTO, oldRole);
		newRole.setCreateDate(oldRole.getCreateDate());
		newRole.setModifiedDate(new Date(System.currentTimeMillis()));
		
		Role result = roleRepository.save(newRole);
		if (result != null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Boolean delete(Long id) {
		try {
			roleRepository.deleteById(id);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
