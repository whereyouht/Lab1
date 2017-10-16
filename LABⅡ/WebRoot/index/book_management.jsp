<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
		<meta charset="utf-8">
		<title>图书管理</title>
		<link href="index/menu/style.css" media="screen" rel="stylesheet" type="text/css" />
		<link href="index/menu/iconic.css" media="screen" rel="stylesheet" type="text/css" />
		<link href="index/tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
		
		<script src="index/menu/prefix-free.js"></script>
		<script src="index/tablecloth/tablecloth.js" type="text/javascript"></script>
		<script src="http://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
		<script>
			$(document).ready(function(){
				$('#add_author_button').click(function(){
					window.open("<%=basePath%>add_author");
				});
			});
		</script>
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
				<th>Title</th>
				<th>ISBN</th>
				<th>AuthorID</th>
				<th>Publisher</th>
				<th>PublishDate</th>
				<th>Price</th>
			</tr>

			
			<s:iterator value="bis" id="bi">
				<%!int i=0;%>
				<s:iterator value="bi" id="bookelement">
					<% i+=1;%>
					<tr>
						<th><%=i%></th>
						<td><s:property value='title'/></td>
						<td><s:property value='isBN'/></td>
						<td><s:property value='authorID'/></td>
						<td><s:property value='publisher'/></td>
						<td><s:property value='publishDate'/></td>
						<td><s:property value='price'/></td>
					</tr>
				</s:iterator>
			</s:iterator>	
			<% i=0;%>	
			<form action="<%=basePath%>mm?addFlag=true" method="post">
				<tr>
					<td><input type="submit" value="+"/></td>
					<td><input type="text"  name="book.title" style="width:100px"/></td>
					<td><input type="text"  name="book.isBN" style="width:100px"/></td>
					<td><input type="text"  name="book.authorID" style="width:50px"/></td>
					<td><input type="text"  name="book.publisher" style="width:100px"/></td>
					<td><input type="text"  name="book.publishDate" style="width:100px"/></td>
					<td><input type="text"  name="book.price" style="width:50px"/></td>
				</tr>
						
			</form>																																		
		</table>
		<br>
		<br>
	<h2>注意：当新增图书的作者不在库中时，需要增加新作者。ISBN不可重复。</h2>
	<button id="add_author_button">
		查看作者
	</button>
	</div>
	</div>
	</body>

</html>