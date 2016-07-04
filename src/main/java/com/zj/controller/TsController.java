/* ----------------------------------------------------------------------------------------
 * 说明：唐诗查询页面控制
 * 作者：朱军
 * 时间：2015.6.29
 ----------------------------------------------------------------------------------------- */

package com.zj.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zj.dao.PoetDao;
import com.zj.entity.Poetries;
import com.zj.service.PoetService;

@Controller
public class TsController {

	// PoetService service;

	@Resource
	HttpServletRequest req;

	@RequestMapping(value = "index")
	public ModelAndView toIndexPage() {

		return new ModelAndView("index.jsp");
	}

/* -------------------------------------------------------------------------------------- 
	  以作者姓名进行查询
  ---------------------------------------------------------------------------------------- */

	@RequestMapping(value = "findByAuthor")
	public ModelAndView toShowTSListPage() throws UnsupportedEncodingException {
		PoetService service = new PoetDao();

		String author = req.getParameter("author");
		String value = new String(author.getBytes("iso8859-1"), "UTF-8");
		List<Poetries> tsList = service.findTsByAuthor(value);
		req.setAttribute("PoetList", tsList);
		return new ModelAndView("showTSList.jsp");
	}

/* ----------------------------------------------------------------------------------------
	 以标题内容为查询方式
  ---------------------------------------------------------------------------------------	 */
	@RequestMapping(value = "findByTitle")
	public ModelAndView toFindTsTitle() throws UnsupportedEncodingException {
		Poetries tmpPoetries = null;
		PoetService service = new PoetDao();

		String title = req.getParameter("title");
		String value = new String(title.getBytes("iso8859-1"), "UTF-8");
		List<Poetries> tsList = service.findByTitle(value);
		req.setAttribute("PoetList", tsList);
		return new ModelAndView("showTSList.jsp");

	}

	/* ---------------------------------------------------------------------------------------- 
	  以内容进行查询
	 ----------------------------------------------------------------------------------------- */
	@RequestMapping(value = "findByContent")
	public ModelAndView tofindTSContent() throws UnsupportedEncodingException {
		Poetries tmpPoetries = null;
		PoetService service = new PoetDao();
		String content = req.getParameter("content");
		String value = new String(content.getBytes("iso8859-1"), "UTF-8");
		List<Poetries> tsList = service.findTsByContent(value);
		req.setAttribute("PoetList", tsList);
		return new ModelAndView("showTSList.jsp");
	}

	/* ---------------------------------------------------------------------------------------------
	  显示唐诗的具体内容
	 ---------------------------------------------------------------------------------------------  */
	@RequestMapping(value = "showTSContent")
	public ModelAndView toshowTSContent() throws UnsupportedEncodingException {
		Poetries tmpPoetries = null;
		PoetService service = new PoetDao();

		String title = req.getParameter("title");
		// String value = new String(title.getBytes("iso8859-1"), "UTF-8");
		List<Poetries> tsList = service.findByTitle(title);
		tmpPoetries = tsList.get(0);
		req.setAttribute("title", tmpPoetries.getTitle());
		req.setAttribute("author", tmpPoetries.getPoets().getName());
		req.setAttribute("content", tmpPoetries.getContent());

		return new ModelAndView("showTSContent.jsp");
	}

}
