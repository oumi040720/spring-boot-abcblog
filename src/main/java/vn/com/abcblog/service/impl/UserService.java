package vn.com.abcblog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.com.abcblog.converter.UserConverter;
import vn.com.abcblog.dto.UserDTO;
import vn.com.abcblog.entity.User;
import vn.com.abcblog.repository.UserRepository;
import vn.com.abcblog.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter converter;
	
	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<>();
		List<User> users = userRepository.findAll();
		
		for (User user : users) {
			result.add(converter.convertToDTO(user));
		}
		
		return result;
	}

	@Override
	public List<UserDTO> findAll(Integer page, Integer limit) {
		List<UserDTO> result = new ArrayList<>();
		List<User> users = userRepository.findAll(PageRequest.of(page, limit)).getContent();
		
		for (User user : users) {
			result.add(converter.convertToDTO(user));
		}
		
		return result;
	}
	
	@Override
	public UserDTO findOneByID(Long id) {
		return converter.convertToDTO(userRepository.getOne(id));
	}
	
	@Override
	public UserDTO findOneByUsername(String username) {
		return converter.convertToDTO(userRepository.findByUsername(username));
	}
	
	@Override
	public Boolean insert(UserDTO userDTO) {
		User user = converter.convertToEntity(userDTO);
		user.setCreateDate(new Date(System.currentTimeMillis()));
		user.setModifiedDate(new Date(System.currentTimeMillis()));
		
		User result = userRepository.save(user);
		if (result != null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Boolean update(UserDTO userDTO) {
		User oldUser = userRepository.getOne(userDTO.getId());
		User newUser = converter.convertToEntity(userDTO, oldUser);
		newUser.setCreateDate(userDTO.getCreateDate());
		newUser.setModifiedDate(new Date(System.currentTimeMillis()));
		
		User result = userRepository.save(newUser);
		if (result != null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Boolean delete(Long id) {
		try {
			userRepository.deleteById(id);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
