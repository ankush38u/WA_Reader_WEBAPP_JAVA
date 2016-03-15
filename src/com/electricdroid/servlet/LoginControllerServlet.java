package com.electricdroid.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.electricdroid.gsonpojo.Status;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SERVERURL= "http://localhost:7070";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println(request.getParameter("inputUsername"));
System.out.println(request.getParameter("inputPassword"));
System.out.println(request.getParameter("checkbox"));
String inputUsername = request.getParameter("inputUsername");
String inputPassword = request.getParameter("inputPassword");
String checkbox = request.getParameter("checkbox");
Cookie c=null;


String chkUserUrl = SERVERURL+"/WAWebService/rest/WAService/isUserRegistered/" +inputUsername +"/"+inputPassword;
 String responsechk = getResponse(chkUserUrl);
 Gson gson = new Gson();
 Status st = gson.fromJson(responsechk, Status.class);
 
if(st!=null && st.isStatus()){
	HttpSession session= request.getSession();

if(checkbox != null){
	session.setMaxInactiveInterval(0);
}

session.setAttribute("username", inputUsername);
RequestDispatcher rd = request.getRequestDispatcher("/chat.jsp");
rd.forward(request, response);

}else{
	request.setAttribute("msg", "Wrong Username or Password,Please try Again!");
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);

}
	
	
	
	}
	private String getResponse(String url1){
		try {
			URL url = new URL(url1);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			StringBuffer stringBuffer =new StringBuffer("");
			while ((output = br.readLine()) != null) {
				stringBuffer.append(output);

			}
			conn.disconnect();
			return stringBuffer.toString();
		}  catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
