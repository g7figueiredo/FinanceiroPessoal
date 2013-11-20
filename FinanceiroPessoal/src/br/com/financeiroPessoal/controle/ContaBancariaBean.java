package br.com.financeiroPessoal.controle;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.financeiroPessoal.bean.ContaBancaria;

@ManagedBean(name="contaBancariaBean")
@SessionScoped
public class ContaBancariaBean {
	
	private Map<String, Integer> valuesBanco;
	private Map<String, Integer> valuesTipo;
	private ContaBancaria contaBancaria = new ContaBancaria();

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	
	
	public ContaBancariaBean(){
		valuesTipo = new LinkedHashMap<String, Integer>();
		valuesTipo.put("Conta corrente", 1);
		valuesTipo.put("Conta poupança", 2);
		
		valuesBanco = new LinkedHashMap<String, Integer>();
		valuesBanco.put("237 - Bradesco S/A", 1);
		valuesBanco.put("134 - Caixa Econômica Federal", 2);
		valuesBanco.put("001 - Itáu S/A", 3);
	}

	public Map<String, Integer> getValuesTipo() {
		return valuesTipo;
	}

	public Map<String, Integer> getValuesBanco() {
		return valuesBanco;
	}
	
	
	

}
