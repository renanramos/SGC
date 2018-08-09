package com.sgc.util;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.sgc.model.entity.Conta;

public class UtilSGC {


	private static Locale ptBr = new Locale("pt", "BR");
	private static DateFormatSymbols dfs = DateFormatSymbols.getInstance(ptBr);
	private Map<String, Integer> meses = new HashMap<String, Integer>();	
	public static List<String> mesesList =  Arrays.asList(dfs.getMonths()).subList(0, 12);	

	//efetua o cálculo total das contas do período inicial
	public double calculaTotal(List<Conta> conta){
		double total = 0;
		
		for(Conta c : conta){
			total += c.getValor();
		}				
		return total;
	}

	//obtém o índice do mes através do nome
	public int getMes(String mes){
		for(int i = 0; i < mesesList.size(); i++){			
			meses.put(mesesList.get(i), Integer.valueOf(i)+1);			
		}
		return meses.get(mes);
	}
	
	public List<String> getAllMeses(){
		return mesesList;
	}
		
}
