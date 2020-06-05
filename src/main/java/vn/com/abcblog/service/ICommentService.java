package vn.com.abcblog.service;

import java.util.List;

import vn.com.abcblog.dto.CommentDTO;

public interface ICommentService {

	public List<CommentDTO> findAll();
	
	public List<CommentDTO> findAll(Integer page, Integer limit);
	
	public CommentDTO findOneByID(Long id);
	
	public Boolean insert(CommentDTO commentDTO);
	
	public Boolean update(CommentDTO commentDTO);

	public Boolean delete(Long id);
	
}
