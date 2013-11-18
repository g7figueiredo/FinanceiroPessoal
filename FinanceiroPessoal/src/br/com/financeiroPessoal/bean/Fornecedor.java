package br.com.financeiroPessoal.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Fornecedor {
	
	private int codigo;
	private String nomeRazao;
	private String ramoAtividade;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeRazao() {
		return nomeRazao;
	}
	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	
	

}
