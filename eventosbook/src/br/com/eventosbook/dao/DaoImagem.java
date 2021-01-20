package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Imagem;

public interface DaoImagem {

	public void incluir(Imagem pImagem);
	public void alterar(Imagem pImagem);
	public void excluir(Imagem pImagem);
	public List<Imagem>consultar(Imagem pImagem);
	public Imagem getImagem(Imagem pImagem);
}
