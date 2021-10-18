package com.szp.basic.web.base;

import java.util.Date;

public interface BasePO {

	Long getId();

	void setCreator(Long creator);

	Long getCreator();

	void setModifier(Long modifier);

	Long getModifier();

	void setDeleted(Boolean deleted);

	Boolean getDeleted();

	void setCreatedTime(Date createdTime);

	Date getCreatedTime();

	void setUpdatedTime(Date updatedTime);

	Date getUpdatedTime();
}
