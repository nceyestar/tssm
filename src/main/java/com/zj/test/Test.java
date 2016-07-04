package com.zj.test;

import com.zj.dao.PoetDao;
import com.zj.entity.Poetries;
import com.zj.service.PoetService;

public class Test {

	public static void main(String[] args) {
		  PoetService  myS=new PoetDao();
		  
		  
		  
/*		  List<Poetries> tmpList=myS.findTsByAuthor("李世民");
		  for(Poetries tmpV:tmpList)
		  {
			  System.out.println(tmpV.getTitle());
			  System.out.println(tmpV.getContent());
			  System.out.println("------------------------");
		  }
		  
		  */
		  
/*		  Poetries tmp=myS.findByTitle("武功");
		  System.out.println(tmp.getContent());
		  System.out.println(tmp.getContent());

		  List<Poets> m=myS.findP();
		  System.out.println(m.size());
*/		  
	}

}
