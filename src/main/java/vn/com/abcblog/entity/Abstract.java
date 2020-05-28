package vn.com.abcblog.entity;

import java.util.Date;

import javax.persistence.Column;

public class Abstract {

	@Column(name = "id")
	private long id;

	@Column(name = "create_by")
	private String create_by;

	@Column(name = "modified_by")
	private String modified_by;

	@Column(name = "create_date")
	private Date create_date;

	@Column(name = "modified_date")
	private Date modified_date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

}
