package vn.com.abcblog.service;

import java.util.List;

import vn.com.abcblog.dto.TagDTO;

public interface ITagService {

	public List<TagDTO> findAll();
	
	public List<TagDTO> findAll(Integer page, Integer limit);
	
	public TagDTO findOneByID(Long id);
	
	public Boolean insert(TagDTO tagDTO);
	
	public Boolean update(TagDTO tagDTO);

	public Boolean delete(Long id);
	
}
