/*Arquivo: script.js
 * 
 * Este arquivo contém as principais funções do sistema.
 * 
 * 
 * 21.02.17 - Renan Rodrigues Ramos
 */
//============================================================================ 
//comparaSenha: compara a senha no momento da inserção/atualização do usuário
//============================================================================
function comparaSenha(){
	var senha = $('#password').val();
	var tamSenha = senha.length;
	
	var confirSenha = $('#confirma_password').val();
	var tamConfirSenha = confirSenha.length;
	
	if(confirSenha.substr(0, tamConfirSenha) === senha.substr(0, tamConfirSenha)){
		$('#senhaNaoConfere').css('visibility', 'hidden');
		$('#buttonConfirmaCadastro').removeClass('disabled');
	}else{
		$('#senhaNaoConfere').css('visibility', 'visible');
		$('#buttonConfirmaCadastro').addClass('disabled');
	};	
};


//=============================================================================== 
//atualTotal: atualiza o valor final total de acordo com as parcelas mencionadas
//===============================================================================
function atualTotal(){
	var parcela = $('#parcela').val();
	console.log(parcela)
	if(parcela != 0){
		total = (parcela) * $('#valor').val();
		$('#total').empty();
		$('#total').append('R$ ' + total);
	}
};


//=============================================================================== 
//atualTotal: atualiza o valor final total de acordo com as parcelas mencionadas
//===============================================================================
function atualizaParcelas(){
	moment.locale('pt-BR');
	
	var total = 0;
	var parcela = $('#parcela').val();
	var dataVenc = $('#dataVencimento').val();
	var data = dataVenc.split("-");
	var parcelaMes = 0;    
		
	$("#dataInicio").attr("value", $('#dataVencimento').val());
	
	if(parcela != 0){

		data = moment(dataVenc,'YYYY-MM-DD');
		data.format("YYYY-MM-DD");
		parcelaMes = parcela - 1;
		data.add(parcelaMes, 'months');
		data.format('YYYY-MM-DD');
		$("#dataFim").attr("value", data.format('YYYY-MM-DD'));
		
		total = parcela * $('#valor').val();
		$('#total').empty();
		$('#total').append('R$ ' + total.toFixed(2));
	}	
};


//=============================================================================== 
//função principal
//===============================================================================
$(document).ready(function(){
	moment.locale('pt-BR');
	
	$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
	
	//=============================================================================== 
	//Quando carregar a página, verifica cada linha da tabela e 
	//atribui uma classe diferente para 
	//===============================================================================
	var dataAtual = new Date();
	var dataVenc = "";
	var dataPaga = "";
	
	dataAtual = moment(dataAtual,'YYYY-MM-DD');
	
	$('table tr#listaContas').each(function(indice){
		
    	dataPaga = $(this).find("#dataPag").val();	    
		dataVenc = $(this).find("#dataVenc").val();		
				
		if (dataPaga == ""){		
			if (diferencaDias(dataVenc) <= 7){	
				$(this).addClass('danger');
			}else if (diferencaDias(dataVenc) <= 10){
				$(this).addClass('warning');
			}else{
				$(this).addClass('activate');
			}
		}else{
			$(this).find('#labelPagar').removeClass('label-warning');
			$(this).find('#labelPagar').addClass('label-success');
			
			$(this).find('#iconPagar').addClass('glyphicon-refresh');
			$(this).find('#iconPagar').addClass('glyphicon-ok-circle');
		}
		
	});
	
	//=============================================================================== 
	//retorna a data convertida para o tipo Date
	//===============================================================================
	function converteData(data){
		return new Date(data);
	}
	
	//=============================================================================== 
	//faz o calculo de diferença de dias entre duas datas
	//===============================================================================
	function diferencaDias(data){
		var diferencaTempo = Math.abs(converteData(dataVenc).getTime() - new Date());
		var diffDias = Math.ceil(diferencaTempo / (1000 * 3600 * 24));
		return diffDias;
	}
		
	//=============================================================================== 
	//corrige pontuação nos vampos de valores 
	//===============================================================================
	$('#valor').each(function(){
		var val = $(this).val().replace(',','.');
		$(this).val(val);
	});
	
});












