package com.electricdroid.customtags;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.electricdroid.beans.Message;
import com.electricdroid.dao.FindContact;
import com.electricdroid.dao.GetMessage;
import com.electricdroid.util.HibernateUtil;

public class ConvoShow extends TagSupport{
	private PageContext pageContext;
	private StringBuilder sb ;
	private String LastDate;
	private String username;
	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		this.username= (String)pageContext.getSession().getAttribute("username");
	}
	
	@Override
	public int doStartTag() throws JspException {
		//get this username from session 
		//for now doing hardcode
		
		  FindContact findContact=null;
          if(username!=null){
		  SessionFactory sf = HibernateUtil.getMsgstoreSF(username);
		  findContact = FindContact.getFindContactSinglton(username);
		  Session s=null;
		  if(sf!=null){
		                	 System.out.print("found db");
		                	 s=sf.openSession();
		                 }
		          String msgs=   GetMessage.getMessages(s, findContact, "917597647234-1434100182@g.us");
		          //this returns msgs with layout html
		s.close();
		HibernateUtil.shutdownMSG();
			 try {
					pageContext.getOut().print(msgs);
				} catch (IOException e) {
					e.printStackTrace();
				}
             
}else{
	RequestDispatcher rd=  pageContext.getRequest().getRequestDispatcher("index.jsp");
	  
	  try {
		rd.forward(pageContext.getRequest(), pageContext.getResponse());
	} catch (ServletException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  }
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		
		
		return EVAL_PAGE;
	}
}
