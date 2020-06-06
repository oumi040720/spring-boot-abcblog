package vn.com.abcblog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.com.abcblog.converter.TagConverter;
import vn.com.abcblog.dto.TagDTO;
import vn.com.abcblog.entity.Tag;
import vn.com.abcblog.repository.TagRepository;
import vn.com.abcblog.service.ITagService;

@Service
public class TagService implements ITagService {

	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private TagConverter converter;
	
	@Override
	public List<TagDTO> findAll() {
		List<TagDTO> result = new ArrayList<>();
		List<Tag> tags = tagRepository.findAll();
		
		for (Tag tag : tags) {
			result.add(converter.convertToDTO(tag));
		}
		
		return result;
	}

	@Override
	public List<TagDTO> findAll(Integer page, Integer limit) {
		List<TagDTO> result = new ArrayList<>();
		List<Tag> tags = tagRepository.findAll(PageRequest.of(page, limit)).getContent();
		
		for (Tag tag : tags) {
			result.add(converter.convertToDTO(tag));
		}
		
		return result;
	}

	@Override
	public TagDTO findOneByID(Long id) {
		return converter.convertToDTO(tagRepository.getOne(id));
	}

	@Override
	public Boolean insert(TagDTO tagDTO) {
		Tag tag = converter.convertToEntity(tagDTO);
		tag.setCreateDate(new Date(System.currentTimeMillis()));
		tag.setModifiedDate(new Date(System.currentTimeMillis()));
		
		Tag result = tagRepository.save(tag);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean update(TagDTO tagDTO) {
		Tag oldTag = tagRepository.getOne(tagDTO.getId());
		Tag newTag = converter.convertToEntity(tagDTO, oldTag);
		newTag.setCreateDate(oldTag.getCreateDate());
		newTag.setModifiedDate(new Date(System.currentTimeMillis()));
		
		Tag result = tagRepository.save(newTag);
		if (result != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			tagRepository.deleteById(id);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
