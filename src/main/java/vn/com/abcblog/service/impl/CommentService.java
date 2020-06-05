package vn.com.abcblog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.com.abcblog.converter.CommentConverter;
import vn.com.abcblog.dto.CommentDTO;
import vn.com.abcblog.entity.Comment;
import vn.com.abcblog.repository.CommentRepository;
import vn.com.abcblog.service.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private CommentConverter converter;
	
	@Override
	public List<CommentDTO> findAll() {
		List<CommentDTO> result = new ArrayList<>();
		List<Comment> comments = commentRepository.findAll();
		
		for (Comment comment : comments) {
			result.add(converter.convertToDTO(comment));
		}
		
		return result;
	}

	@Override
	public List<CommentDTO> findAll(Integer page, Integer limit) {
		List<CommentDTO> result = new ArrayList<>();
		List<Comment> comments = commentRepository.findAll(PageRequest.of(page, limit)).getContent();
		
		for (Comment comment : comments) {
			result.add(converter.convertToDTO(comment));
		}
		
		return result;
	}

	@Override
	public CommentDTO findOneByID(Long id) {
		return converter.convertToDTO(commentRepository.getOne(id));
	}

	@Override
	public Boolean insert(CommentDTO commentDTO) {
		Comment comment = converter.convertToEntity(commentDTO);
		comment.setCreateDate(new Date(System.currentTimeMillis()));
		comment.setModifiedDate(new Date(System.currentTimeMillis()));
		
		Comment result = commentRepository.save(comment);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean update(CommentDTO commentDTO) {
		Comment oldComment = commentRepository.getOne(commentDTO.getId());
		Comment newComment = converter.convertToEntity(commentDTO, oldComment);
		newComment.setCreateDate(oldComment.getCreateDate());
		newComment.setModifiedDate(new Date(System.currentTimeMillis()));
		
		Comment result = commentRepository.save(newComment);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			commentRepository.deleteById(id);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
