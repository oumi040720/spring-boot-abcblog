package vn.com.abcblog.entity.id;

import java.io.Serializable;

import javax.persistence.Column;

public class TagID implements Serializable {

	private static final long serialVersionUID = -8703214312806302689L;

	@Column(name = "post_id")
	private Long post_id;

	@Column(name = "category_id")
	private Long category_id;

	public TagID() {
	}
	
	public TagID(Long post_id, Long category_id) {
		this.post_id = post_id;
		this.category_id = category_id;
	}

	public Long getPost_id() {
		return post_id;
	}

	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
