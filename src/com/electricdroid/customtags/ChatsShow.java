package com.electricdroid.customtags;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.electricdroid.beans.ChatList;
import com.electricdroid.dao.FindContact;
import com.electricdroid.dao.GetMessage;
import com.electricdroid.util.HibernateUtil;

public class ChatsShow extends TagSupport {
	StringBuffer sb=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PageContext pageContext;
	private String username;
	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		 this.username = (String) pageContext.getSession().getAttribute("username");
	}
	

	@Override
	public int doStartTag() throws JspException {
		//get this username from session 
		//for now doing hardcode
		
		 String defaultJidForDisplayConvo =null; 
		  FindContact findContact=null;
		  HashMap<String , Integer> hmOfLastMsgId = new HashMap<String, Integer>();
		  if(username!= null){
		  SessionFactory sf = HibernateUtil.getMsgstoreSF(username);
		  Session s=null;
		  if(sf!=null){
		                	 System.out.print("found db");
		                	 s=sf.openSession();
		                 }
		                 Transaction tx= s.beginTransaction();
		             
		        	 	 List<ChatList> chatList = s.createQuery("select s from ChatList as s").list();
		                if(chatList.size()>0){
		                	findContact = FindContact.getFindContactSinglton(username);
		                ListIterator<ChatList> itrc=	(ListIterator<ChatList>) chatList.listIterator();
		                
		                ChatList c=null;
		                while(itrc.hasNext()){
		                
								c= (ChatList)itrc.next();
							//	hmOfLastMsgId.put(c.getKey_remote_jid(), c.getLast_read_message_table_id())
		                	}
		               
		                sb=new StringBuffer();
		                while(itrc.hasPrevious()){
		                	c=itrc.previous();
		                	if(defaultJidForDisplayConvo == null){
		                    	defaultJidForDisplayConvo = c.getKey_remote_jid();
		                    }
		               
		                	     sb.append("<div class=\"contact\" title=\"Last Message: "+ new Date(c.getSort_timestamp()) +"\" "
		                	     		+ "onclick=\"findConvo('"+c.getKey_remote_jid() +"')\">"
		                	     				+ "<span style=\"font-family: 'Roboto-Medium';\">"+findContact.getDisplayName(c.getKey_remote_jid()) +"</span>"
											+ "<span class=\"left\"><a href=\"#\" title=\" "+ c.getKey_remote_jid().substring(0,c.getKey_remote_jid().indexOf("@"))+" \"><img src=\"asset/img/avatar.png\""
													+ " width=\"48\" height=\"48\"></a></span><span class=\"right\"> "+ GetMessage.getMessage(s,c.getLast_read_message_table_id())+"</span>"
													+ "</div>");
	          
		               } //while close
		                }
		                
		                else System.out.print("No element in chatlist");
		                try {
		                	JspWriter out = pageContext.getOut();
		                	pageContext.getResponse().setCharacterEncoding("UTF-8");
		                	pageContext.getResponse().setContentType("UTF-8");
							out.print(sb.toString());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                
		                tx.commit();
		            	s.close();
		            	HibernateUtil.shutdownMSG();
		
		  }
		  else{
RequestDispatcher rd= pageContext.getRequest().getRequestDispatcher("index.jsp");
		  
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
