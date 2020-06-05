package vn.com.abcblog.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.com.abcblog.dto.UserDTO;
import vn.com.abcblog.entity.User;
import vn.com.abcblog.service.IRoleService;

@Component
public class UserConverter {

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private RoleConverter roleConverter;
	
	public UserDTO convertToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setCreateBy(user.getCreateBy());
		dto.setCreateDate(user.getCreateDate());
		dto.setModifiedBy(user.getModifiedBy());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setFullname(user.getFullname());
		dto.setGender(user.getGender());
		dto.setBirthday(user.getBirthday());
		dto.setEmail(user.getEmail());
		dto.setAddress(user.getAddress());
		dto.setPhone(user.getPhone());
		dto.setAvatar(user.getAvatar());
		dto.setFlagDelete(user.getFlagDelete());
		dto.setRoleID(user.getRole().getId());
		
		return dto;
	}
	
	public User convertToEntity(UserDTO userDTO) {
		User entity = new User();
		entity.setId(userDTO.getId());
		entity.setCreateBy(userDTO.getCreateBy());
		entity.setCreateDate(userDTO.getCreateDate());
		entity.setModifiedBy(userDTO.getModifiedBy());
		entity.setUsername(userDTO.getUsername());
		entity.setPassword(userDTO.getPassword());
		entity.setFullname(userDTO.getFullname());
		entity.setGender(userDTO.getGender());
		entity.setBirthday(userDTO.getBirthday());
		entity.setEmail(userDTO.getEmail());
		entity.setAddress(userDTO.getAddress());
		entity.setPhone(userDTO.getPhone());
		entity.setAvatar(userDTO.getAvatar());
		entity.setFlagDelete(userDTO.getFlagDelete());
		entity.setRole(roleConverter.convertToEntity(roleService.findOneByID(userDTO.getRoleID())));
		
		return entity;
	}
	
	public User convertToEntity(UserDTO userDTO, User entity) {
		entity.setId(userDTO.getId());
		entity.setCreateBy(userDTO.getCreateBy());
		entity.setCreateDate(userDTO.getCreateDate());
		entity.setModifiedBy(userDTO.getModifiedBy());
		entity.setUsername(userDTO.getUsername());
		entity.setPassword(userDTO.getPassword());
		entity.setFullname(userDTO.getFullname());
		entity.setGender(userDTO.getGender());
		entity.setBirthday(userDTO.getBirthday());
		entity.setEmail(userDTO.getEmail());
		entity.setAddress(userDTO.getAddress());
		entity.setPhone(userDTO.getPhone());
		entity.setAvatar(userDTO.getAvatar());
		entity.setFlagDelete(userDTO.getFlagDelete());
		entity.setRole(roleConverter.convertToEntity(roleService.findOneByID(userDTO.getRoleID())));
		
		return entity;
	}
	
}
