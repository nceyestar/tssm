/* ----------------------------------------------------------------------------------------
 * 说明：唐诗明细表对应类
 * 作者：朱军
 * 时间：2015.5.29
 ----------------------------------------------------------------------------------------- */

package com.zj.entity;

import java.sql.Timestamp;


public class Poetries implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Poets poets;
	private String content;
	private String title;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Poets getPoets() {
		return poets;
	}
	public void setPoets(Poets poets) {
		this.poets = poets;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}