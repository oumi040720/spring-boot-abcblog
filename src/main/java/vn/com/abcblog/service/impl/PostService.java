package vn.com.abcblog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.com.abcblog.converter.PostConverter;
import vn.com.abcblog.dto.PostDTO;
import vn.com.abcblog.entity.Post;
import vn.com.abcblog.repository.PostRepository;
import vn.com.abcblog.service.IPostService;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private PostConverter converter;
	
	@Override
	public List<PostDTO> findAll() {
		List<PostDTO> result = new ArrayList<>();
		List<Post> posts = postRepository.findAll();
		
		for (Post post : posts) {
			result.add(converter.convertToDTO(post));
		}
		
		return result;
	}

	@Override
	public List<PostDTO> findAll(Integer page, Integer limit) {
		List<PostDTO> result = new ArrayList<>();
		List<Post> posts = postRepository.findAll(PageRequest.of(page, limit)).getContent();
		
		for (Post post : posts) {
			result.add(converter.convertToDTO(post));
		}
		
		return result;
	}

	@Override
	public PostDTO findOneByID(Long id) {
		return converter.convertToDTO(postRepository.getOne(id));
	}

	@Override
	public PostDTO findOneByPostCode(String postCode) {
		return converter.convertToDTO(postRepository.findByPostCode(postCode));
	}

	@Override
	public Boolean insert(PostDTO postDTO) {
		Post post = converter.convertToEntity(postDTO);
		post.setCreateDate(new Date(System.currentTimeMillis()));
		post.setModifiedDate(new Date(System.currentTimeMillis()));

		Post result = postRepository.save(post);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean update(PostDTO postDTO) {
		Post oldPost = postRepository.getOne(postDTO.getId());
		Post newPost = converter.convertToEntity(postDTO, oldPost);
		newPost.setCreateDate(oldPost.getCreateDate());
		newPost.setModifiedDate(new Date(System.currentTimeMillis()));

		Post result = postRepository.save(newPost);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			postRepository.deleteById(id);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
