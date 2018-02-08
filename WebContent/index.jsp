<%@page import="com.aliandro.gn.model.GuessNumberGame"%>
<%@page import="com.aliandro.gn.controller.GuessNumberServlet"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! int acessos = 0; %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Inicial</title>
</head>
<body>
		
		
		<% 
		
		GuessNumberGame game = (GuessNumberGame) session.getAttribute("game");
		
		if ( game == null ){
			game = new GuessNumberGame();
			session.setAttribute("game", game);
		}
		
		String errorMsg = (String) request.getAttribute("errorMsg");
		
		if( errorMsg != null ){
			out.println(errorMsg + "<br/>");
		}
		
		Integer limiteInferior = game.getLimiteInferior();
		Integer limiteSuperior = game.getLimiteSuperior();
		
		out.println("Tentativa numero: " + acessos++  + "<br/>");
		
		%>
		
	
	Digite um numero entre <%= game.getLimiteInferior()%> e <%= game.getLimiteSuperior() %>	
	<form method="post" action="guess">
		<input type="text" name="palpite" />
		<input type="submit" value="Palpite!" />
	</form>

</body>
</html>