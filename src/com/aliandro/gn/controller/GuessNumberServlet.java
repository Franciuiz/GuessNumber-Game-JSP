package com.aliandro.gn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aliandro.gn.model.GuessNumberGame;

@WebServlet(urlPatterns={"/guess"}, loadOnStartup=1)
public class GuessNumberServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String palpiteStr = request.getParameter("palpite");
		
		try {
			Integer palpite = Integer.parseInt(palpiteStr);
			
			HttpSession session = request.getSession();
			GuessNumberGame game = (GuessNumberGame) session.getAttribute("game");
			
			//Programação defensiva!
			if ( game == null ){
				game = new GuessNumberGame();
				session.setAttribute("game", game);
			}
			
			//chamando a lógica de negócio
			Boolean ganhou = game.realizarPalpite(palpite);
		
		
			if ( ganhou ){
				session.removeAttribute("game");
				response.sendRedirect("parabens.html"); 
			} else {
				response.sendRedirect("index.jsp");
			}
			
			
		} catch ( Exception exception ){
			request.setAttribute("errorMsg", exception.getLocalizedMessage());
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	
	}
	
}






