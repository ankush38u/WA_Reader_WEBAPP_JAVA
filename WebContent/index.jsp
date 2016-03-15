<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>WhatsApp Reader</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="asset/js/jquery.min.js"></script>
<script type="text/javascript" src="asset/js/bootstrap.min.js"></script>
<link href="asset/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="asset/css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="asset/img/favicon.ico"><!--  for webpage image icon -->

<style type="text/css">
body {
	background: url('asset/img/mainbg.jpg') center;
	background-size: 100% 100%;
}
</style>
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
		if (username != null) {
			RequestDispatcher rd = request.getRequestDispatcher("chat.jsp");
			rd.forward(request, response);
		}
	%>
	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-ex-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>WhatsApp Reader</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#">Chat</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Help</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="cover">
		<div class="navbar">
			<div class="section">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<form class="form-horizontal" action="LoginControllerServlet"
								method="post" role="form">
								<div class="form-group">
									<div class="col-sm-2">
										<label for="inputUsername" class="control-label">Username</label>
									</div>
									<div class="col-sm-10">
										<input type="text" name="inputUsername" class="form-control"
											id="inputUsername" placeholder="Username">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-2">
										<label for="inputPassword" class="control-label">Password</label>
									</div>
									<div class="col-sm-10">
										<input type="password" name="inputPassword"
											class="form-control" id="inputPassword"
											placeholder="Password">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div class="checkbox">
											<label> <input type="checkbox" name="checkbox">Remember
												me
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">Sign in</button>
									</div>
								</div>
							</form>
							<%!String msg = null;%>
							<%
								msg = (String) request.getAttribute("msg");
								if (msg != null) {
									System.out.print(msg);
							%>

							<div class="col-sm-12"><%=msg%></div>

							<%
								}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="cover-image" style="background-image: url(asset/img/mainbg.jpg);"></div> -->
	</div>
	<footer class="section" style="background: rgba(35, 81, 81, 0.7)">
	<div class="container" style="background-color: rgba(35, 81, 81, 0.7)">
		<div class="row">
			<div class="col-sm-6" style="color: #fff">
				<h1>About us:</h1>
				<p>
					WhatsApp Reader is a Educational project designed <br>and
					developed by Ankush Chugh.
				</p>
			</div>
			<div class="col-sm-6">
				<p class="text-info text-right">
					<br> <br>
				</p>
				<div class="row">
					<div class="col-md-12 hidden-lg hidden-md hidden-sm text-left">
						<a href="#"><i
							class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a> <a href="#"><i
							class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a> <a href="#"><i
							class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a> <a href="#"><i
							class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 hidden-xs text-right">
						<a href="#"><img src="asset/img/fb.png" style="width: 30px"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>