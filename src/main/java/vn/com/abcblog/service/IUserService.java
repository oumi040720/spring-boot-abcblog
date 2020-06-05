package vn.com.abcblog.service;

import java.util.List;

import vn.com.abcblog.dto.UserDTO;

public interface IUserService {

	public List<UserDTO> findAll();
	
	public List<UserDTO> findAll(Integer page, Integer limit);
	
	public UserDTO findOneByID(Long id);
	
	public UserDTO findOneByUsername(String username);
	
	public Boolean insert(UserDTO userDTO);
	
	public Boolean update(UserDTO userDTO);

	public Boolean delete(Long id);
	
}
