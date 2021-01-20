package br.com.eventosbook.util;


import java.util.ArrayList;
import java.util.List;

public class BibliotecaTipoSelect {
	
	private String aChave;
	private String aValor;
	private String aDescricao;
	private String aSelected = "";
	
	

	private List<BibliotecaTipoSelect> aColecao = new ArrayList<BibliotecaTipoSelect>();
	
	public BibliotecaTipoSelect() {
	}
	
	public BibliotecaTipoSelect(String pChave, String pValor , String pDescricao) {
		this.aChave = pChave;
		this.aValor = pValor;
		this.aDescricao  = pDescricao; 
	}



	public  void add(String pChave, String pValor , String pDescricao){
		
		this.aColecao.add( new BibliotecaTipoSelect(pChave, pValor, pDescricao));
	}
	
	/**Deixa um campo selecionado.
	 * 
	 * @param pChave
	 */
	public void setSelecionado(String pValor){
		if(this.getColecao().size() != 0){
			for (int i = 0; i < this.getColecao().size(); i++) {
				if (this.getColecao().get(i).getValor().equals(pValor)){
					this.getColecao().get(i).setSelected("selected");
				}else {
					this.getColecao().get(i).setSelected(""); //remove de todos caso já esteja selecionado.
				}
			}
		}
	}

	public List<BibliotecaTipoSelect> getColecao(){
		return this.aColecao;
	}
	
	public void setColecao(List<BibliotecaTipoSelect> pColecao){
		this.aColecao = pColecao;
	}

	public String getChave() {
		return aChave;
	}



	public void setChave(String aChave) {
		this.aChave = aChave;
	}



	public String getValor() {
		return aValor;
	}



	public void setValor(String aValor) {
		this.aValor = aValor;
	}

	public String getDescricao() {
		return aDescricao;
	}

	public void setDescricao(String aDescricao) {
		this.aDescricao = aDescricao;
	}
	
	public String getSelected() {
		return aSelected;
	}

	public void setSelected(String aSelected) {
		this.aSelected = aSelected;
	}
	
	
	
}

