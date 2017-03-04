package com.sgc.model.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.sgc.model.BaseEntity;

public class Conta extends BaseEntity{

	private String descricao;
	
	@NumberFormat(style=Style.CURRENCY)
	private Double valor;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataFim;
	
	private Integer parcela;	
	
	private String observacao;	
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getParcela() {
		return parcela;
	}

	public boolean fixa;	
	
	public boolean isFixa() {
		return fixa;
	}

	public void setFixa(boolean fixa) {
		this.fixa = fixa;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public String toString() {
		return "Conta [descricao=" + descricao + ", valor=" + valor + ", dataPagamento=" + dataPagamento
				+ ", dataVencimento=" + dataVencimento + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
				+ ", parcela=" + parcela + ", fixa=" + fixa + "]";
	}	
	
}
