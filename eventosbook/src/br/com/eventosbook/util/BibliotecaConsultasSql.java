package br.com.eventosbook.util;

public class BibliotecaConsultasSql {
	
	private BibliotecaConsultasSql() {}
	
	private static BibliotecaConsultasSql aBibliotecaConsultasSql = new BibliotecaConsultasSql();
	
	public static BibliotecaConsultasSql getInstance(){
		if(BibliotecaConsultasSql.aBibliotecaConsultasSql == null){
			BibliotecaConsultasSql.aBibliotecaConsultasSql = new BibliotecaConsultasSql();
		}
		
		return BibliotecaConsultasSql.aBibliotecaConsultasSql;
	}
	
	
	public StringBuilder consultarItemCheckListPorTipoEvento(){
		StringBuilder query = new StringBuilder();
		query.append("SELECT");
		query.append(" eventosbook.item.id_item,");
		query.append(" eventosbook.item.descricao,");
		query.append(" eventosbook.item.fk_categoria,");
		query.append(" eventosbook.item.fk_subcategoria");
		query.append(" FROM eventosbook.item");
		query.append(" INNER JOIN eventosbook.item_tipo_evento");
		query.append(" ON eventosbook.item.id_item = eventosbook.item_tipo_evento.fk_item");
		query.append(" where eventosbook.item_tipo_evento.fk_tipo_evento = ?");
		
		return query;
	}
	
	
	public StringBuilder consultarCheckListPorEvento(){
		StringBuilder query = new StringBuilder();
		query.append("SELECT");
		query.append(" eventosbook.checklist.id_checklist,");
		query.append(" eventosbook.checklist.status,");
		query.append(" eventosbook.checklist.fk_evento,");
		query.append(" eventosbook.checklist.fk_item");
		query.append(" FROM");
		query.append(" eventosbook.checklist");
		query.append(" WHERE eventosbook.checklist.fk_evento = ?");
		
		return query;
	
	}
	
	public StringBuilder consultarItemCheckListPorEvento(){
		StringBuilder query = new StringBuilder();
		query.append("SELECT");
		query.append(" eventosbook.item.id_item,");
		query.append(" eventosbook.item.descricao,");
		query.append(" eventosbook.item.fk_categoria,");
		query.append(" eventosbook.item.fk_subcategoria,");
		query.append(" eventosbook.checklist.status");
		query.append(" FROM eventosbook.item");
		query.append(" INNER JOIN eventosbook.checklist");
		query.append(" ON eventosbook.item.id_item = eventosbook.checklist.fk_item");
		query.append(" WHERE eventosbook.checklist.fk_evento = ?");
		
		return query;
	}
	
	public StringBuilder consultarFornecedorPorItem(){
		StringBuilder query = new StringBuilder();
		query.append("SELECT");
		query.append(" eventosbook.fornecedor.id_fornecedor,");
		query.append(" eventosbook.fornecedor.descricao,");
		query.append(" eventosbook.fornecedor.horario_atendimento,");
		query.append(" eventosbook.fornecedor.nome,");
		query.append(" eventosbook.fornecedor.numero_documento,");
		query.append(" eventosbook.fornecedor.fk_usuario");
		query.append(" FROM eventosbook.fornecedor");
		query.append(" INNER JOIN eventosbook.fornecedor_categoria");
		query.append(" ON eventosbook.fornecedor.id_fornecedor = eventosbook.fornecedor_categoria.fk_fornecedor");
		query.append(" WHERE 1=1 ");
		
		return query;
	}
	
	
	public StringBuilder consultarContratantePorUsuario(){
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT");
		query.append(" eventosbook.contratante.id_contratante,");
		query.append(" eventosbook.contratante.cpf,");
		query.append(" eventosbook.contratante.data_nascimento,");
		query.append(" eventosbook.contratante.nome,");
		query.append(" eventosbook.contratante.sexo,");
		query.append(" eventosbook.contratante.fk_usuario");
		query.append(" FROM eventosbook.contratante");
		query.append(" INNER JOIN eventosbook.usuario");
		query.append(" ON eventosbook.contratante.fk_usuario = eventosbook.usuario.id_usuario");
		query.append(" WHERE eventosbook.usuario.id_usuario = ? AND eventosbook.usuario.email = ?");
		
		return query;
		
		
	}
	
	public StringBuilder validaCadastroPorEmail(){
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT");
		query.append(" eventosbook.email.id_email,");
		query.append(" eventosbook.email.data_criacao,");
		query.append(" eventosbook.email.ativo,");
		query.append(" eventosbook.email.fk_usuario,");
		query.append(" eventosbook.email.chave,");
		query.append(" eventosbook.email.url");
		query.append(" FROM eventosbook.email");
		query.append(" INNER JOIN eventosbook.usuario");
		query.append(" ON eventosbook.email.fk_usuario = eventosbook.usuario.id_usuario");
		query.append(" WHERE eventosbook.email.chave = ? AND eventosbook.email.fk_usuario = ? ");
		
		return query;
		
	}
	
	public StringBuilder consultarEventoPorContratante(){
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT");
		query.append(" eventosbook.evento.id_evento,");
		query.append(" eventosbook.evento.data_criacao,");
		query.append(" eventosbook.evento.data_evento,");
		query.append(" eventosbook.evento.data_ult_atualizacao,");
		query.append(" eventosbook.evento.descricao,");
		query.append(" eventosbook.evento.horario_evento,");
		query.append(" eventosbook.evento.fk_contratante,");
		query.append(" eventosbook.evento.fk_tipo_evento");
		query.append(" FROM eventosbook.evento");
		query.append(" INNER JOIN eventosbook.contratante");
		query.append(" ON eventosbook.evento.fk_contratante = eventosbook.contratante.id_contratante");
		query.append(" WHERE eventosbook.evento.fk_contratante = ? ORDER BY eventosbook.evento.data_evento");
		
		return query;
			
	}
	
	public StringBuilder consultarDetalharEventoPorContratante(){
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT");
		query.append(" eventosbook.evento.id_evento,");
		query.append(" eventosbook.evento.data_criacao,");
		query.append(" eventosbook.evento.data_evento,");
		query.append(" eventosbook.evento.data_ult_atualizacao,");
		query.append(" eventosbook.evento.descricao,");
		query.append(" eventosbook.evento.horario_evento,");
		query.append(" eventosbook.evento.fk_contratante,");
		query.append(" eventosbook.evento.fk_tipo_evento");
		query.append(" FROM eventosbook.evento");
		query.append(" INNER JOIN eventosbook.contratante");
		query.append(" ON eventosbook.evento.fk_contratante = eventosbook.contratante.id_contratante");
		query.append(" WHERE eventosbook.evento.fk_contratante = ? AND eventosbook.evento.id_evento = ?");
		
		return query;
			
	}
	
	public StringBuilder consultarFornecedorPorUsuario(){
		StringBuilder query = new StringBuilder();
		query.append("SELECT");
		query.append(" eventosbook.fornecedor.id_fornecedor,");
		query.append(" eventosbook.fornecedor.descricao,");
		query.append(" eventosbook.fornecedor.horario_atendimento,");
		query.append(" eventosbook.fornecedor.nome,");
		query.append(" eventosbook.fornecedor.numero_documento,");
		query.append(" eventosbook.fornecedor.fk_usuario,");
		query.append(" eventosbook.fornecedor.nota");
		query.append(" FROM eventosbook.fornecedor");
		query.append(" INNER JOIN eventosbook.usuario");
		query.append(" ON eventosbook.fornecedor.fk_usuario = eventosbook.usuario.id_usuario");
		query.append(" WHERE eventosbook.usuario.id_usuario = ? AND eventosbook.usuario.email = ? ");
		
		return query;
	}
	






}
