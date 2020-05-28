package vn.com.abcblog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends Abstract {

	@Column(name = "content")
	private String content;

	@Column(name = "flag_delete")
	private Boolean flagDelete;

	@Column(name = "post_id")
	private Long post_id;

	@OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
	private List<Post> posts;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getFlagDelete() {
		return flagDelete;
	}

	public void setFlagDelete(Boolean flagDelete) {
		this.flagDelete = flagDelete;
	}

	public Long getPost_id() {
		return post_id;
	}

	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
