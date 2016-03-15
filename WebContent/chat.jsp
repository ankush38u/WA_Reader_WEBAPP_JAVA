
<%@ taglib prefix="c" uri="/WEB-INF/mytags.tld"%>
<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>WhatsApp Reader</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="asset/js/jquery.min.js"></script>
<script type="text/javascript" src="asset/js/bootstrap.min.js"></script>
<script type="text/javascript" src="asset/js/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="asset/js/myscript.js"></script>
<link href="asset/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="asset/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="asset/css/mycss.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="asset/img/favicon.ico"><!--  for webpage image icon -->

<script>

	function findConvo(jid){
		 $.post("AjaxServlet",
			        {
			        id: jid ,
			        },
			        function(data,status){
			        if(status == "success"){
			            document.getElementById("conversation").innerHTML = data;
			        }
			        });
		 
	} 
	

	
</script>
<style type="text/css">
body {
	background: url('asset/img/background.jpg');
}
</style>
</head>




<body>
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
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-4" style="background: #fff">
					<div id="chatlist">
						<br />
						<c:chats_show></c:chats_show>
					</div>
				</div>
				<!-- These are the closing div for chatlist bootstrap column -->

				<!-- Here we start code for a coversation now -->
				<div class="col-md-8"
					style="background: url('asset/img/chat_bg.jpg')">
					<div id="inner-content-div2">
						<div id="conversation">
							<br /> <br /> <br />


							<c:convo_show></c:convo_show>
<!--  this is my custom tag which load default chat ie chat we had with last person ie called a convo -->
							<br /> <br /> <br />
						</div> 
						<!-- #id conversation close -->

					</div> <!--  Inner content div close used for scroll bar in jquery -->
				</div> <!--  bootstrap col md-8 close -->
			</div> <!--  bootstrap row close -->
		</div> <!--  container close -->
	</div> <!--  section close -->




	<footer class="section" style="background: rgba(35,81,81,0.35)">
	<div class="container" style="background-color: rgba(35, 81, 81, 0.45)">
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