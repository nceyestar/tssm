/* ----------------------------------------------------------------------------------------
 * 说明：唐诗数据查询服务
 * 作者：朱军
 * 时间：2015.5.29
 ----------------------------------------------------------------------------------------- */

package com.zj.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zj.entity.Poetries;
import com.zj.entity.Poets;
import com.zj.service.PoetService;

public class PoetDao implements PoetService
{
	public SqlSessionFactory sqlMapper=null;
	public SqlSession session=null;

	public PoetDao()
	{
		String Resource="com/zj/map/MyBatisConfig.xml";
		Reader reader=null;
		try {

			reader=Resources.getResourceAsReader(Resource);
			sqlMapper=new SqlSessionFactoryBuilder().build(reader);
			System.out.println(sqlMapper);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
		


	/* -------------------------------------------------------------------------------------- 
 * 功能:根据作者姓名查询诗人诗词
 * ---------------------------------------------------------------------------------------- */
	public List findTsByAuthor(String author) 
	{
		
		session=sqlMapper.openSession();
		List <Poetries>myList=session.selectList("findTsByAuthor",author);
		System.out.println(myList.size());
		session.close();
		return myList;
		}
	
	
	/* -------------------------------------------------------------------------------------- 
	 * 功能:根据诗词标题查询诗词
	 * ---------------------------------------------------------------------------------------- */
	public List findByTitle(String title)
	{
		session = sqlMapper.openSession();
		Poetries tmpV=null;
		List<Poetries> myList=null;
		myList=	session.selectList("findTsByTitle","%" +title +"%"); // 模糊查询
		if (myList.size()>0)
		{
			tmpV=myList.get(0);
			String tmpAuthor=tmpV.getPoets().getName();
		}
		session.close();
 	   return myList;
		
	}
	
	
	/* -------------------------------------------------------------------------------------- 
	 * 功能:根据诗词内容查询诗人诗词
	 * ---------------------------------------------------------------------------------------- */
	public List findTsByContent(String content)
	{
		session = sqlMapper.openSession();
		List myList=session.selectList("findTsByContext","%"+content+"%"); // 模糊查询

		session.close();
		return myList;
		
	}
	
	/* -------------------------------------------------------------------------------------- 
	 * 功能:根据诗人id查询诗人姓名
	 * ---------------------------------------------------------------------------------------- */
	public String findAuthorById(int authorID)
	{
		System.out.println(sqlMapper);
		session = sqlMapper.openSession();
		Poets tmpPoets=null;
		tmpPoets=session.selectOne("findAuthorById",authorID); 

		if(tmpPoets!=null)
		{
		   return tmpPoets.getName();
		}
		else
		{
			return null;
		}
	}
	
	
	/* -------------------------------------------------------------------------------------- 
	 * 功能:根据诗人姓名查ID
	 * ---------------------------------------------------------------------------------------- */
	public int findAuthorIdByName(String author)
	{
		session = sqlMapper.openSession();
		Poets tmpPoets=null;
		tmpPoets=session.selectOne("findAuthorIdByName","'" + author + "'"); 
		
		if(tmpPoets!=null)
		{
			return tmpPoets.getId();
		}
		else
		{
			return 0;
		}
	}
	
	

}
