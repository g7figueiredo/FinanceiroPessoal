package br.com.financeiroPessoal.controle;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.financeiroPessoal.bean.Favorecido;
import br.com.financeiroPessoal.dao.FornecedorDao;
import br.com.financeiroPessoal.exception.DaoException;


@ManagedBean(name="favorecidoBean")
@SessionScoped
public class FavorecidoBean implements Serializable{
	
	private Map<Integer, String> valuesCusto;
	private List<Favorecido> lista;
	private Favorecido favorecido = new Favorecido();
	
	public String inicio(){
		return "index";
	}
	
	
	public Favorecido getFornecedor() {
		return favorecido;
	}
	public void setFornecedor(Favorecido fornecedor) {
		this.favorecido = fornecedor;
	}

	public FavorecidoBean(){
		valuesCusto = new LinkedHashMap<Integer, String>();
        valuesCusto.put(1, "Educação");
        valuesCusto.put(2, "Diversos");
        valuesCusto.put(3, "Alimentação e Mantimentos");
        valuesCusto.put(4, "Namorada");
        valuesCusto.put(5, "Saneamento Básico");
	}
	
	
	public Map<Integer, String> getValuesCusto() {
		return valuesCusto;
	}
	
	public String inserir(ActionEvent actionEvent) {
		try{
			if(this.favorecido.getCodigo() != 0){
				new FornecedorDao().editar(this.favorecido);
				FacesContext context = FacesContext.getCurrentInstance();  
		        context.addMessage(null, new FacesMessage("Sucesso", "Dados atualizados!"));
			}else{
				new FornecedorDao().inserir(this.favorecido);
				FacesContext context = FacesContext.getCurrentInstance();  
		        context.addMessage(null, new FacesMessage("Sucesso", "Dados armazenados!"));
			}
			
			this.favorecido = null;
			this.lista = null;
		}catch(DaoException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Favorecido> getLista() throws DaoException{
		if(this.lista == null){
			FornecedorDao dao = new FornecedorDao();
			this.lista = dao.listar();
		}
		return this.lista;
	}
	
	public String editar() throws DaoException{
//		if(this.fornecedor != null){
//			FornecedorDao dao = new FornecedorDao();
//			dao.editar(this.fornecedor);
//		}
		return "fornecedor";
		
	}
	
	public String excluir() throws DaoException{
		FornecedorDao dao = new FornecedorDao();
		dao.excluir(this.favorecido);
		
		this.favorecido = null;
		this.lista = null;
		return null;
		
	}

}
