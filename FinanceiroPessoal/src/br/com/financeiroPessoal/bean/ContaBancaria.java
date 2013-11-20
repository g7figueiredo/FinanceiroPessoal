package br.com.financeiroPessoal.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ContaBancaria {
	
	private int codConta;
	private String nrConta;
	private String digConta;
	private String nrAgencia;
	private String digAgencia;
	private String tipoConta;
	private double chequeEspecial;
	private int codBanco;
	private String cpf;
	
	
	
	public int getCodConta() {
		return codConta;
	}
	public void setCodConta(int codConta) {
		this.codConta = codConta;
	}
	public String getNrConta() {
		return nrConta;
	}
	public void setNrConta(String nrConta) {
		this.nrConta = nrConta;
	}
	public String getDigConta() {
		return digConta;
	}
	public void setDigConta(String digConta) {
		this.digConta = digConta;
	}
	public String getNrAgencia() {
		return nrAgencia;
	}
	public void setNrAgencia(String nrAgencia) {
		this.nrAgencia = nrAgencia;
	}
	public String getDigAgencia() {
		return digAgencia;
	}
	public void setDigAgencia(String digAgencia) {
		this.digAgencia = digAgencia;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	public double getChequeEspecial() {
		return chequeEspecial;
	}
	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
	public int getCodBanco() {
		return codBanco;
	}
	public void setCodBanco(int codBanco) {
		this.codBanco = codBanco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	

}
