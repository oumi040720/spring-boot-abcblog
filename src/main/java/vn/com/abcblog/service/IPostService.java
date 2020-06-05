package vn.com.abcblog.service;

import java.util.List;

import vn.com.abcblog.dto.PostDTO;

public interface IPostService {

	public List<PostDTO> findAll();
	
	public List<PostDTO> findAll(Integer page, Integer limit);
	
	public PostDTO findOneByID(Long id);
	
	public PostDTO findOneByPostCode(String postCode);
	
	public Boolean insert(PostDTO postDTO);
	
	public Boolean update(PostDTO postDTO);
	
	public Boolean delete(Long id);
	
}
