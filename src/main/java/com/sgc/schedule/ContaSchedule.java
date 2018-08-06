package com.sgc.schedule;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sgc.model.base.service.ContaService;
import com.sgc.model.entity.Conta;

@Component
public class ContaSchedule {

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private ContaService contaService;
	
	/* 
	 * Esta funcao  e executada no primeiro dia de cada mes para verificar quais contas  
	 * estao configuradas como fixas e atualizar o banco. 
	 */	

	@Scheduled(cron="0 0 1 1 * ?",zone="America/Sao_Paulo")
	public void atualizaContasFixas() throws ParseException{
		Date now = new Date();
		String nowString = df.format(now);
		
		List<Conta> contas = contaService.scheduleContasFixas(nowString);
		
		for(Conta conta : contas){
			Date dataProximoMes = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(dataProximoMes);
			
			//adiciona um mes na data de vencimento
			c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
			dataProximoMes = c.getTime();
			
			conta.setDataVencimento(dataProximoMes);
			conta.setDataFim(null);
			conta.setDataInicio(null);
			conta.setDataPagamento(null);
			conta.setParcela(0);			
						
			contaService.create(conta);
		}
		
	}
	
}