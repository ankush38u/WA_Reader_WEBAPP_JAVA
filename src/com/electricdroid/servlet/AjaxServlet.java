package com.electricdroid.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.electricdroid.dao.FindContact;
import com.electricdroid.dao.GetMessage;
import com.electricdroid.util.HibernateUtil;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {

	PrintWriter out;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doThis(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doThis(request, response);
	}

	private void doThis(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String jid = request.getParameter("id");
		String username = (String) request.getSession()
				.getAttribute("username");
		FindContact findContact = null;
		if (username != null) {
			SessionFactory sf = HibernateUtil.getMsgstoreSF(username);
			findContact = FindContact.getFindContactSinglton(username);
			Session s = null;
			if (sf != null) {
				System.out.print("found db");
				s = sf.openSession();
			}
			String msgs = GetMessage.getMessages(s, findContact, jid);
			// this returns msgs with layout html
			s.close();
			HibernateUtil.shutdownMSG();
			try {
				response.getWriter().write(msgs);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
