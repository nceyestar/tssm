/* ----------------------------------------------------------------------------------------
 * 说明：唐诗数据查询服务
 * 作者：朱军
 * 时间：2015.5.29
 ----------------------------------------------------------------------------------------- */

package com.zj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zj.entity.Poetries;
import com.zj.entity.Poets;

@Service
public interface PoetService 
{

	public List findTsByAuthor(String author); 
	public List findByTitle(String title);
	public List findTsByContent(String content);
	public String findAuthorById(int authorID);
	public int findAuthorIdByName(String author);

}
