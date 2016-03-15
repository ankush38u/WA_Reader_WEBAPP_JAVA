package com.electricdroid.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.electricdroid.beans.*;
import com.electricdroid.util.HibernateUtil;

public class GetMessage {

 
 
 
 
 
	public static String getMessage(Session hibernateSession, Integer msgId) {
		//this method is being used to get last message of each chat by msgId
		if(msgId!= null){
		Message m = (Message) hibernateSession.get(Message.class, msgId);
		if (m.getMedia_wa_type() == 1) {
			return "Media File!";
		}
		if(m.getData()!=null &&  m.getData().length()>20){
			//if msg is very big it affects layout
			return m.getData().substring(0,20);
		}
		else return m.getData();
		} else return "Message not read yet!";
	
		}

	public static List<Message> getMessage(Session hibernateSession, String jid) {
		// jid is used to find one complete chat for a person
		
      //   List<Message> list = hibernateSession.createQuery("select s from Message as s where s.key_remote_jid="+jid).list();
        Criteria ct= hibernateSession.createCriteria(Message.class);
        Criterion cond = Restrictions.eq("key_remote_jid", jid);
        ct.add(cond);
        List<Message> list = ct.list();
		
		
		return list;
	}
	
	public static String getMessages(Session hibernateSession,FindContact findContact, String jid) {
		// jid is used to find one complete chat for a person
		
      //   List<Message> list = hibernateSession.createQuery("select s from Message as s where s.key_remote_jid="+jid).list();
        Criteria ct= hibernateSession.createCriteria(Message.class);
        Criterion cond = Restrictions.eq("key_remote_jid", jid);
        ct.add(cond);
        List<Message> msgList = ct.list();
        Iterator<Message> itrMsg=msgList.iterator();
	    Message m=null;
        StringBuffer  sb= new StringBuffer();
        Transaction tx= hibernateSession.beginTransaction();
      
     
        while(itrMsg.hasNext()){
		 m= itrMsg.next();
		sb.append("<div class=\"clearfix\" id=\"ajaxChanger\" >"
				+ "<div class=\" "+ GetMessage.getMsgSentOrReceive(m.getKey_from_me()) +" \"> "); //incoming outgoing defining div
		
								if(m.getKey_from_me() ==0 && m.getKey_remote_jid().contains("@g.us")){  
									//if(message not from me and is of a group)
									//To show name of group members
									sb.append("	<span style=\"font-family: 'Roboto-Medium'; color: #b4c74b;\" title=\" "+ findContact.getDisplayName(m.getRemote_resource()) +" \">"+ findContact.getDisplayName(m.getRemote_resource()) +"</span><br/>");
									}     
							
								
								if(m.getData() !=null){
								sb.append("<span > "+m.getData()+"</span>");
								
								}

								//if()
								
								if((m.getMedia_url() != null) ){  
									if(m.getMedia_mime_type()!=null && m.getMedia_mime_type().contains("image/")){
										//do sumthing for image display
									sb.append("<img src=\"  "+m.getMedia_url()+" \" alt=\"Sorry!Whatsapp doesnt catch media for Long!\" style=\"max-height: 180px; max-width: 180px;\" />");
									}
									if(m.getMedia_mime_type()!=null && m.getMedia_mime_type().contains("video/")){
										//do sumthing for video display
										sb.append("<video width=\"320\" height=\"240\" controls>" +
												"<source src=\" "+ m.getMedia_url() +" \" type=\" "+ m.getMedia_mime_type() +"  \">Your browser does not support the video tag.</video>");
										
										
									}
												}                            
											
											
									sb.append("<span class=\"time\"> "+ new Date(m.getTimestamp()).getHours()+":"+ new Date(m.getTimestamp()).getMinutes() );
																					
											 if(m.getTimestamp() > 0){ //ie msg received or sent successfully
												
											sb.append("	<img src=\"asset/img/received.png\" width=\"13\" height=\"9\"></span>");
									  	}   else  {
										     	sb.append("<img src=\"asset/img/pending.png\" width=\"13\" height=\"9\"></span>");
											  } 
										
									sb.append("</div>  </div>"); //2 div close for clearfix and incoming from or outgoing to class 
	  
	    
		} //while close
        sb.append("</div>");
		return sb.toString();
	}

	public static String getMsgSentOrReceive(int key_from_me) {
		if (key_from_me == 1) {
			return "outgoing to";
		} else
			return "incoming from";
	}

}
