<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>                                               
<html>                                                        
  <head>                                                        
    <title>Bootstrap Example</title>                            
    <meta charset='utf-8'>                                      
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>                                     
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>  
  </head>
  <body> 
  	<header>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <ul class="navbar-nav">
		      <li class="nav-item">
		        <a class="nav-link active" href="/day05_FC/home.jsp">Home</a>
		      </li>
		     <li class="nav-item">
		        <a class="nav-link" href="memberRegister.do">회원등록</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="memberList.do">회원리스트</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="memberList.do">Docker</a>
		      </li>
		    </ul>
		  </div>
		</nav>
	</header>                                          
