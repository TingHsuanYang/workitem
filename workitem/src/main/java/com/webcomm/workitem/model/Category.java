package com.webcomm.workitem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySeq")
	@SequenceGenerator(name = "categorySeq", sequenceName = "CATEGORY_SEQ")
	@Column(name = "PK_CATEGORY", length = 20)
	private Long pkCategory;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OrderBy("createDate DESC")
	private Set<CategoryDetail> categoryDetail;

	/* 分類名稱 */
	@NotEmpty(message = "分類名稱不能為空")
	@Length(max = 100, message = "分類名稱長度不得超過100字")
	@Column(name = "DESCRIPTION", length = 300)
	private String description;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", updatable = false)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	public Long getPkCategory() {
		return pkCategory;
	}

	public void setPkCategory(Long pkCategory) {
		this.pkCategory = pkCategory;
	}

	public Set<CategoryDetail> getCategoryDetail() {
		return categoryDetail;
	}

	public void setCategoryDetail(Set<CategoryDetail> categoryDetail) {
		this.categoryDetail = categoryDetail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
