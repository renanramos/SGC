package com.sgc.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sgc.model.base.service.ContaService;
import com.sgc.model.entity.Conta;
import com.sgc.util.UtilSGC;

@Controller
public class ContaController {

	@Autowired
	private ContaService contaService;	
	
	private Date dataInicial;
	private Date dataFim;
	
	private Conta conta = new Conta();
	private UtilSGC util = new UtilSGC();
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value = "conta", method = RequestMethod.GET)
	public ModelAndView findAllContas(HttpSession session){		
		double total = 0;
		ModelAndView mv = new ModelAndView("conta/contaList");
		
		List<Conta> contas = contaService.readByAll();
		
		if (!contas.isEmpty()){
			total = util.calculaTotal(contas);
		}
		
		mv.addObject("contas", contas);		
		mv.addObject("total", total);
		
		return mv;
	}
	
	@RequestMapping(value = "conta/{id}/view", method = RequestMethod.GET)
	public ModelAndView viewConta(@PathVariable Long id, HttpSession session){
		ModelAndView mv = new ModelAndView("conta/contaView");		
		conta = contaService.readById(id);
		mv.addObject("conta", conta);
		return mv;
	}
	
	@RequestMapping(value = "conta/novo")
	public ModelAndView novaConta(){
		ModelAndView mv = new ModelAndView("conta/contaForm");
		return mv;
	}
	
	@RequestMapping(value = "conta/novo", method = RequestMethod.POST)
	public String saveConta(@ModelAttribute("conta") Conta conta, BindingResult result, HttpSession session){
		if (conta != null){			
			if(conta.getParcela() == null){conta.setParcela(0);};
			if(conta.getParcela() > 1){
				Conta contaParcela = new Conta();
				for(int i = 0; i < conta.getParcela(); i++){
					contaParcela.setDescricao(conta.getDescricao());
					contaParcela.setValor(conta.getValor());
					contaParcela.setParcela(i);
					contaParcela.setFixa(conta.isFixa());
					contaParcela.setDataInicio(conta.getDataInicio());
					contaParcela.setDataFim(conta.getDataFim());					
					
					Date d = null; 
					
					if (conta.getDataVencimento() == null){
						d = new Date();
					}else{
						d = conta.getDataInicio();
					}							
					
					Calendar c = Calendar.getInstance();
					c.setTime(d);
					
					c.set(Calendar.MONTH, c.get(Calendar.MONTH) + i);
					
					contaParcela.setDataVencimento(c.getTime());
					contaService.create(contaParcela);					
				}
			}else{				
				contaService.create(conta);
			}
		}
		return "redirect:/conta/filtro";
	}
	
	@RequestMapping(value = "conta/{id}/excluir", method = RequestMethod.GET)
	public String excluiConta(@PathVariable Long id, HttpSession session){
		contaService.delete(id);
		return "redirect:/conta/filtro";
	}
	
	@RequestMapping(value = "conta/{id}/editar", method = RequestMethod.GET)
	public ModelAndView editarConta(@PathVariable Long id, HttpSession session){
		ModelAndView mv = new ModelAndView("conta/contaForm");
		Conta conta = contaService.readById(id);
		mv.addObject("conta", conta);			
		return mv;
	}
		
	@RequestMapping(value = "conta/{id}/editar", method = RequestMethod.POST)
	public String updateConta(@ModelAttribute Conta conta, HttpSession session){
		if (conta != null){
			contaService.update(conta);
		}
		return "redirect:/conta/filtro";
	}
	
	@RequestMapping(value = "conta/filtro")
	public ModelAndView filtraContas(@RequestParam(required=false, name="dataInicial") Date dataInicial, @RequestParam(required=false, name="dataFim") Date dataFim, HttpSession session){
		double total = 0;
		Calendar calendar = Calendar.getInstance();
		
		List<Conta> contas = null;		
		
		ModelAndView mv = new ModelAndView("conta/contaList");
		
		if ((dataInicial != null) && (dataFim != null)){
			
			contas = contaService.readByPeriodo(dataInicial, dataFim);
						
		}else{			
			
			calendar.setTime(new Date());
			
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			dataInicial = calendar.getTime();	
			
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			dataFim = calendar.getTime();			
			
			contas = contaService.readByPeriodo(dataInicial, dataFim);
			
		}
		
		if (!contas.isEmpty()){
			total = util.calculaTotal(contas);
		}
		
		mv.addObject("meses", util.getAllMeses());
		mv.addObject("contas", contas);
		mv.addObject("total", total);
		mv.addObject("mesSelecionado", "Escolha um mes...");
				
		return mv;
	}
	
	@RequestMapping(value = "conta/mes")
	public ModelAndView filtraPorMes(@RequestParam(required=false, name="mes") String mes, HttpSession session){
		ModelAndView mv = new ModelAndView("conta/contaList");
		List<Conta> contas = null;
		
		double total = 0;
		int pos = util.getMes(mes);
				
		Calendar c = Calendar.getInstance();
		c.set(c.getWeekYear(), pos-1, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		dataInicial = c.getTime();
		
		c.set(c.getWeekYear(), pos-1, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		dataFim = c.getTime();
				
		contas = contaService.readByPeriodo(dataInicial, dataFim);
		
		if (!contas.isEmpty()){
			total = util.calculaTotal(contas);
		}
				
		mv.addObject("meses", util.getAllMeses());
		mv.addObject("contas", contas);
		mv.addObject("total", total);
		mv.addObject("mesSelecionado", mes);
		
		return mv;
	}
	
	@RequestMapping(value = "conta/{id}/pagar")
	public String efetuaPagamento(@PathVariable Long id, HttpSession session){			
		Conta conta = contaService.readById(id);
		conta.setDataPagamento(new Date());
		contaService.update(conta);
		return "redirect:/conta/filtro";
	}
}
