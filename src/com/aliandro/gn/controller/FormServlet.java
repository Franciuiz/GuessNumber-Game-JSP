package com.aliandro.gn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aliandro.gn.model.GuessNumberGame;

@WebServlet("/index")
public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; encoding=UTF-8"); 
		
		PrintWriter writer = response.getWriter();

		writer.write("<html>");
		writer.write("<body>");
		
		HttpSession session = request.getSession(true);
		GuessNumberGame game = (GuessNumberGame) session.getAttribute("game");
		
		if ( game == null ){
			game = new GuessNumberGame();
			session.setAttribute("game", game);
		}
		
		String errorMsg = (String) request.getAttribute("errorMsg");
		
		if( errorMsg != null ){
			writer.write(errorMsg + "<br/>");
		}
		
		Integer limiteInferior = game.getLimiteInferior();
		Integer limiteSuperior = game.getLimiteSuperior();
		
		writer.write("Forneça um número entre " + limiteInferior + " e " 
					+ limiteSuperior + ": ");
		
		RequestDispatcher rd = request.getRequestDispatcher("form.html");
		rd.include(request, response);
		
		writer.write("</body>");
		writer.write("</html>");
		
	}

}




