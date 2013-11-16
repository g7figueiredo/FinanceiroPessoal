package br.com.financeiroPessoal.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Fornecedor {
	
	private int codigo;
	private int codCentroCusto;
	private String nomeRazao;
	private String descCentroCusto;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodCentroCusto() {
		return codCentroCusto;
	}
	public void setCodCentroCusto(int codCentroCusto) {
		this.codCentroCusto = codCentroCusto;
	}
	public String getNomeRazao() {
		return nomeRazao;
	}
	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}
	public String getDescCentroCusto() {
		return descCentroCusto;
	}
	public void setDescCentroCusto(String descCentroCusto) {
		this.descCentroCusto = descCentroCusto;
	}
	
	
	
	

}
