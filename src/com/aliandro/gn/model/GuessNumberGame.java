package com.aliandro.gn.model;

import java.util.Random;

public class GuessNumberGame {

	private Integer desafio;
	private Integer limiteInferior;
	private Integer limiteSuperior;
	
	public GuessNumberGame() {
		this.limiteInferior = 0;
		this.limiteSuperior = 1000;
		
		Random random = new Random();
		this.desafio = random.nextInt(this.limiteSuperior);
	}
	
	public Boolean realizarPalpite(Integer palpite){
		
		if( palpite == null || palpite > limiteSuperior 
							|| palpite < limiteInferior ){
			throw new IllegalArgumentException("Por favor, forneça um valor entre "
					+ limiteInferior + " e " + limiteSuperior + "!");
		}
		
		if ( desafio.equals(palpite) ){
			return true;
		}
		
		if ( palpite > desafio ){
			this.limiteSuperior = palpite;
		} else {
			this.limiteInferior = palpite;
		}
		return false;
	}

	public Integer getLimiteInferior() {
		return limiteInferior;
	}

	public Integer getLimiteSuperior() {
		return limiteSuperior;
	}
	
	
	//so pra conferir os dados
	public Integer getDesafio() {
		return desafio;
	}
		
}











