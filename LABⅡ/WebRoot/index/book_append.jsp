<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
		<meta charset="GB18030">
		<title>添加图书</title>
		<link href="index/menu/style.css" media="screen" rel="stylesheet" type="text/css" />
		<link href="index/menu/iconic.css" media="screen" rel="stylesheet" type="text/css" />
		<link href="index/tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
		
		<script src="index/menu/prefix-free.js"></script>
		<script src="index/tablecloth/tablecloth.js" type="text/javascript"></script>
		<style>
			
			body{
				margin:0;
				padding:0;
				font:70% Arial, Helvetica, sans-serif; 
				color:#555;
				line-height:150%;
				text-align:left;
			}
			a{
				text-decoration:none;
				color:#057fac;
			}
			a:hover{
				text-decoration:none;
				color:#999;
			}
			h1{
				font-size:140%;
				margin:0 20px;
				line-height:80px;	
			}
			h2{
				font-size:120%;
			}
			#container{
				margin:0 auto;
				width:680px;
				background:#fff;
				padding-bottom:20px;
			}
			#content{margin:0 20px;}
			p.sig{	
				margin:0 auto;
				width:680px;
				padding:1em 0;
			}
			form{
				margin:1em 0;
				padding:.2em 20px;
				background:#eee;
			}
		</style>
	</head>
	
	<body>
	
	<div class="wrap">
	
	<nav>
		<ul class="menu">
			<li><a href="<%=basePath%>home"><span class="iconic home"></span> 主页</a></li>
			<li><a href="<%=basePath%>search"><span class="iconic magnifying-glass"></span>图书查询</a>
			</li>
			<li><a href="<%=basePath%>mm"><span class="iconic map-pin"></span> 图书管理</a>
				<ul>
					<li><a href="<%=basePath%>add_book">添加图书</a></li>
					<li><a href="<%=basePath%>add_author">添加作者</a></li>
					<li><a href="<%=basePath%>delete">删除图书</a></li>
					<li><a href="<%=basePath%>modify">修改图书信息</a></li>
				</ul>
			</li>
			<li><a href="<%=basePath%>contact"><span class="iconic mail"></span> 联系我们</a>
			</li>

			<li><a href="<%=basePath%>about"><span class="iconic plus-alt"></span> 关于我们</a>
			</li>
		</ul>
		<div class="clearfix"></div>
	</nav>
	</div>
	<div id="container">
	<div id="content">
		<br><br>
		<table>
			<tr>
				<td>&nbsp;</td>
				<th>ISBN</th>
				<th>Title</th>
				<th>Publisher</th>
				<th>PublishDate</th>
				<th>Price</th>
				<th>AuthorID</th>
			</tr>																																		
		</table>		
	</div>
	</div>
	
	</body>

</html>