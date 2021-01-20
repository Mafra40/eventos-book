package br.com.eventosbook.constante.sql;

import br.com.eventosbook.util.BibliotecaConsultasSql;

public class ConstantesSQL {
	
	public static final String QUERY_ITEM_CHECK_LIST_POR_TIPO_EVENTO = BibliotecaConsultasSql.getInstance().consultarItemCheckListPorTipoEvento().toString();
	
	public static final String QUERY_CHECK_LIST_POR_EVENTO = BibliotecaConsultasSql.getInstance().consultarCheckListPorEvento().toString();
	
	public static final String QUERY_ITEM_CHECK_LIST_POR_EVENTO = BibliotecaConsultasSql.getInstance().consultarItemCheckListPorEvento().toString();
	
	public static final String QUERY_FORNECEDOR_POR_ITEM = BibliotecaConsultasSql.getInstance().consultarFornecedorPorItem().toString();

	public static final String QUERY_CONSULTAR_CONTRATANTE_POR_USUARIO = BibliotecaConsultasSql.getInstance().consultarContratantePorUsuario().toString();
	
	public static final String QUERY_CONSULTAR_VALIDA_CADASTRO_POR_EMAIL = BibliotecaConsultasSql.getInstance().validaCadastroPorEmail().toString();
	
	public static final String QUERY_CONSULTAR_EVENTO_POR_CONTRATANTE = BibliotecaConsultasSql.getInstance().consultarEventoPorContratante().toString();
	
	public static final String QUERY_DETALHAR_EVENTO_POR_CONTRATANTE = BibliotecaConsultasSql.getInstance().consultarDetalharEventoPorContratante().toString();
	
	public static final String QUERY_CONSULTAR_FORNECEDOR_POR_USUARIO = BibliotecaConsultasSql.getInstance().consultarFornecedorPorUsuario().toString();
	
}
