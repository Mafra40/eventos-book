package br.com.eventosbook.constante;

public class Constantes {
	
	/**Sempre que trocar de ambiente configurar.
	 * 
	 * PROPRIEDADE SISTEMA
	 */
	public static final String NOME_APLICACAO = "localhost:8181/eventosbook"; 
			//"eventosbook.com.br"; // "localhost:8080/eventosbook";
	public static final String URL_CONTEXTO  = "http://"+NOME_APLICACAO+"/";
	public static final String URL_CAMPO_SEPARADOR = "/";
	public static final String URL_CAMINHO_ABSOLUTO = URL_CONTEXTO;
	public static final String PATH_PROJECT = "br.com.eventosbook";
	
	/*Configura��o de diret�rio */
	public static final String UPLOAD_PATH = System.getenv("OPENSHIFT_DATA_DIR")+"uploads";  //"C:\\UPLOAD";
	public static final String URL_CAMINHO_IMAGEM = "static"; //representa "static/rodr6/fotoGaleria_V3X6PqCW.jpg"
	public static final String NM_ATT_ARR_IMAGENS = "imagensUploaded";  
	public static final String CAMPO_SEPARADOR_UP = "/"; // local = "\\" remoto ="/"
	
	/**
	 * Parametros do Servidor de email
	 */
	public static final String EMAIL_HOST =  "smtp.googlemail.com";
	public static final String EMAIL_REMETENTE = "eventosbookemail@gmail.com";
	public static final String EMAIL_SENHA = "eventos123";
	public static final Boolean EMAIL_SSL = true;
	public static final Boolean EMAIL_DEBUG = true;
	public static final int EMAIL_PORTA = 465;
	
	public static final int TAMANHO_SENHA_USUARIO = 8;
	
	/**
	 * SIGLAS
	 */
	public static final Character SIGLA_TIPO_USUARIO_CONTRATANTE = 'C';
	public static final Character SIGLA_TIPO_USUARIO_FORNECEDOR = 'F';
	public static final Character SIGLA_TIPO_USUARIO_PRODUTOR = 'P';
	public static final Character SIGLA_TIPO_USUARIO_ADMINISTRADOR = 'A';
	public static final Character SIGLA_SITUACAO_USUARIO_ATIVO = 'A';
	public static final Character SIGLA_SITUACAO_USUARIO_INATIVO = 'I';
	
	public static final String SIGLA_AFIRMACAO = "S";
	public static final String SIGLA_NEGACAO = "N";
	
	/**
	 * 
	 * Mascara
	 */
	public static final String MASCARA_DATA_USA =  "yyyy-MM-dddd";
	public static final String MASCARA_DATA_PT_BR =  "dd/MM/yyyy";
	public static final String MASCARA_HORA_MINUTO =  "HH:mm";
	
	
	
	/**
	 * LINKS DO SISTEMA
	 */
	
	/*Controladores */
	public static final String LINK_FORNECEDOR_CONTROLADOR = "fornecedor";
	public static final String LINK_CONTRATANTE_CONTROLADOR = "contratante";
	public static final String LINK_USUARIO_CONTROLADOR = "usuario";
	public static final String LINK_IMAGEM_CONTROLADOR = "imagem";
	public static final String LINK_ORCAMENTO_CONTROLADOR = "orcamento";
	public static final String LINK_CIDADE_CONTROLADOR = "cidade";
	public static final String LINK_AJAX_CONTROLADOR = "ajax";
	public static final String LINK_PRODUTOR_CONTROLADOR = "produtor";
	public static final String LINK_LOGIN = "/";
	public static final String LINK_SAIR = "logout";
	public static final String LINK_LOGIN_INVALIDO = "loginInvalido";
	public static final String LINK_EFETUAR_LOGIN = "efetuarLogin";
	public static final String LINK_AREA_CONTRATANTE = "areaContratante";
	public static final String LINK_AREA_FORNECEDOR = "areaFornecedor";
	public static final String LINK_AREA_PRODUTOR = "areaProdutor";
	public static final String LINK_HOME_CONTRATANTE = "homeContratante";
	public static final String LINK_HOME_FORNECEDOR = "homeFornecedor";
	public static final String LINK_HOME_PRODUTOR= "homeProdutor";
	public static final String LINK_RECUPERACAO_CONTA= "recuperarConta";
	public static final String LINK_EFETUAR_RECUPERACAO_CONTA = "efetuarRecuperacaoConta";
	public static final String LINK_ALTERACAO_SENHA = "alterarSenha";
	public static final String LINK_EFETUAR_ALTERACAO_SENHA = "efetuaralteracaosenha";
	public static final String LINK_ALTERACAO_SENHAS_USUARIOS = "alteracaosenha";
	public static final String LINK_EFETUAR_ALTERACAO_SENHAS_USUARIO = "efetuarAlteracaoSenhasUsuarios";
	public static final String LINK_CADASTRAR_CONTRATANTE = "cadastro";
	public static final String LINK_SOLICITAR_ORCAMENTO = "solicitarOrcamento";
	public static final String LINK_ADD_MEUS_FORNECEDORES = "addMeusFornecedores";
	public static final String LINK_EXIBIR_MEUS_FORNECEDORES = "meusFornecedores";
	public static final String LINK_EXIBIR_ORCAMENTO = "meusOrcamentos";
	public static final String LINK_CADASTRAR_FORNECEDOR = "cadastro";
	public static final String LINK_EFETUAR_CADASTRO_CONTRATANTE = "efetuarCadastroContratante";
	public static final String LINK_EFETUAR_CADASTRO_FORNECEDOR = "efetuarCadastroFornecedor";
	public static final String LINK_CADASTRO_USUARIO_COM_SUCESSO = "cadastroRealizadoComSucesso";
	public static final String LINK_CADASTRO_USUARIO_SEM_SUCESSO = "cadastroRealizadoSemSucesso";
	public static final String LINK_ALTERACAO_CONTRATANTE = "perfil";
	public static final String LINK_ALTERACAO_FORNECEDOR = "perfil";
	public static final String LINK_FORNECEDOR_GALERIA_IMAGENS = "imagens";
	public static final String LINK_FORNECEDOR_IMAGENS = "galeria";
	public static final String LINK_UPLOAD_FOTO_IMAGEM = "uploadFotos";
	public static final String LINK_EFETUAR_IMAGEM_PRINCIPAL = "efetuarImagemPrincipal";
	public static final String LINK_CONSULTA_CIDADES_ESTADO = "consultaCidadesPorEstado";
	public static final String LINK_FORNECEDOR_REMOVER_IMAGENS = "removerImagem";
	public static final String LINK_FORNECEDOR_DETALHAMENTO = "detalhamento";
	public static final String LINK_EFETUAR_ALTERACAO_FORNECEDOR = "efetuarAlteracaoFornecedor";
	public static final String LINK_FORNECEDOR_EFETUAR_INCLUSAO_IMAGEM = "efetuarInclusaoImagem";
	public static final String LINK_EFETUAR_ALTERACAO_CONTRATANTE = "efetuarAlteracaoContratante";
	public static final String LINK_MEU_EVENTO = "meusEventos";
	public static final String LINK_CADASTRAR_EVENTO = "cadastrarEvento";
	public static final String LINK_EFETUAR_CADASTRO_EVENTO = "efetuarCadastroEvento";
	public static final String LINK_ALTERACAO_EVENTO = "alteracaoEvento";
	public static final String LINK_EFETUAR_ALTERACAO_EVENTO = "efetuarAlteracaoEvento";
	public static final String LINK_REMOVER_EVENTO = "removerEvento";
	public static final String LINK_USUARIO_RECUPERADO_COM_SUCESSO = "usuarioRecuperadoComSucesso";
	public static final String LINK_CHECKLIST = "checkList";
	public static final String LINK_FORNECEDOR_PARAMETRIZADO = "listaFornecedor";
	public static final String LINK_CONSULTA_DOCUMENTO = "consultaDocumento";
	public static final String LINK_MARCAR_DESMARCAR_ITEM_CHECKLIST = "marcarDesmarcarTarefaCheckList";
	public static final String LINK_AVALIAR_FORNECEDOR = "avaliarFornecedor"; 
	public static final String LINK_EFETUAR_AVALIACAO_FORNECEDOR = "efetuarAvaliacaoFornecedor";
	public static final String LINK_VIZUALIZAR_TOTAL_AVALIACOES = "avaliacoes";
	public static final String LINK_BUSCAR_FORNECEDOR = "buscarFornecedor";
	public static final String LINK_EFETUAR_ORDENACAO_FORNECEDOR = "efetuarOrdenacaoFornecedor";
	public static final String LINK_USUARIO_CADASTRADO = "usuarioCadastrado";
	/**
	 * Links email
	 * */
	public static final String LINK_EMAIL_CONFIRMACAO = "emailConfirmacao";
	/**
	 * Atributos referencias passados no HttpSession
	 */
	public static final String CONTEXTO_USUARIO_LOGADO = "contextoUsuarioLogado";
	
	/**
	 * NOMES DAS JSP's / TELAS CRIADAS SE ENCONTRA NA PASTA ..WEB-INF/view
	 */
	
	public static final String NM_JSP_HOME_ADMINISTRADOR = "administrador/homeAdimnistrador";
	
	public static final String NM_JSP_HOME_PRODUTOR = "produtor/homeProdutor";
	public static final String NM_JSP_AREA_PRODUTOR = "produtor/areaProdutor";
	
	public static final String NM_JSP_LOGIN = "usuario/login";
	public static final String NM_JSP_LOGIN_INVALIDO = "usuario/loginInvalido";
	public static final String NM_JSP_RECUPERACAO_CONTA= "usuario/recuperarConta";
	public static final String NM_JSP_ALTERACAO_SENHA = "usuario/alterarSenha";
	public static final String NM_JSP_USUARIO_ALTERADO_COM_SUCESSO = "usuario/usuarioAlteradoComSucesso";
	public static final String NM_JSP_USUARIO_ALTERADO_SEM_SUCESSO = "usuario/usuarioAlteradoSemSucesso";
	public static final String NM_JSP_CADASTRO_USUARIO_COM_SUCESSO= "usuario/cadastroRealizadoSucesso";
	public static final String NM_JSP_CADASTRO_USUARIO_SEM_SUCESSO = "usuario/falhaAoCadastrar";
	
	public static final String NM_JSP_ALTERACAO_SENHA_CONTRATANTE = "contratante/alteracaoSenhas";
	public static final String NM_JSP_CADASTRAR_CONTRATANTE = "contratante/cadastrarContratante";
	public static final String NM_JSP_ALTERACAO_CONTRATANTE = "contratante/alteracaoContratante";
	public static final String NM_JSP_MEU_EVENTO = "contratante/meusEventos";
	public static final String NM_JSP_CADASTRAR_EVENTO = "contratante/cadastrarEvento";
	public static final String NM_JSP_ALTERACAO_EVENTO = "contratante/alteracaoEvento";
	public static final String NM_JSP_CHECKLIST = "contratante/meuCheckList";
	public static final String NM_JSP_FORNECEDOR_PARAMETRIZADO = "contratante/fornecedorParametrizado";
	public static final String NM_JSP_MEU_ORCAMENTO = "contratante/meusOrcamentos";
	public static final String NM_JSP_AREA_CONTRATANTE = "contratante/areaContratante";
	public static final String NM_JSP_HOME_CONTRATANTE = "contratante/homeContratante";
	public static final String NM_JSP_AVALIAR_FORNECEDOR = "contratante/avaliarFornecedor"; 
	public static final String NM_JSP_MEUS_FORNECEDORES = "contratante/meusFornecedores"; 
	public static final String NM_JSP_BUSCAR_FORNECEDOR = "contratante/buscarFornecedor";
	
	public static final String NM_JSP_CADASTRAR_FORNECEDOR= "fornecedor/cadastrarFornecedor";
	public static final String NM_JSP_ALTERACAO_FORNECEDOR = "fornecedor/alteracaoFornecedor";
	public static final String NM_JSP_GALERIA_FORNECEDOR = "fornecedor/imagemFornecedor";	
	public static final String NM_JSP_IMAGEM_GALERIA_FORNECEDOR = "fornecedor/imagemGaleriaFornecedor";	
	public static final String NM_JSP_DETALHAMENTO_FORNECEDOR = "fornecedor/detalhamento";
	public static final String NM_JSP_ALTERACAO_SENHA_FORNECEDOR = "fornecedor/alteracaoSenhas";
	public static final String NM_JSP_HOME_FORNECEDOR = "fornecedor/homeFornecedor";
	public static final String NM_JSP_AREA_FORNECEDOR = "fornecedor/areaFornecedor";
	public static final String NM_JSP_AVALIACOES = "fornecedor/avaliacoes";
	
	/**
	 * Vari�veis de Tela
	 */
	public static final String NM_ATR_MODEL_FORNECEDOR = "fornecedor";
	public static final String NM_ATR_MODEL_IMAGEM = "imagem";
	public static final String NM_ATR_MODEL_CIDADE = "cidade";
	public static final String NM_ATR_MODEL_ENDERECO = "endereco";
	public static final String NM_ATR_MODEL_ESTADO = "estado";
	public static final String NM_ATR_MODEL_TELEFONE = "telefone";
	public static final String NM_ATR_MODEL_CATEGORIA = "categoria";
	public static final String NM_ATR_MODEL_CONTRATANTE_FORNECEDOR = "listOrcamento";
	public static final String NM_ATR_MODEL_MEUS_FORNECEDORES = "MeusFornecedores";
	public static final String NM_ATR_MODEL_COMENTARIO = "comentario";
	public static final String NM_ATR_QTD_AVALIACOES = "qtdAvaliacoes";
	
	public static final String NM_REDIRECT = "redirect:";
	
	/**
	 * Caminhos de sistema
	 */
	
	public static final String SIGLA_ATIVO = "A";
	public static final String SIGLA_INATIVO= "I";
	public static final String SITUACAO_CD_ENVIADO= "B";
	public static final Integer SITUACAO_SIGLA_ENVIADO= 7; 
	public static final Integer SITUACAO_CD_ABERTO= 4;
	public static final String SITUACAO_SIGLA_ABERTO= "E"; 
	public static final String SITUACAO_SIGLA_TIPO_MEUS_FORNECEDORES= "F"; 
	public static final Integer SITUACAO_CD_TIPO_MEUS_FORNECEDORES= 8; 
	public static final String SITUACAO_SIGLA_TIPO_MEUS_ORCAMENTOS= "O"; 
	public static final Integer SITUACAO_CD_TIPO_MEUS_ORCAMENTOS= 9;
	public static final String SIGLA_TIPO_COMENTARIO_POSITIVO = "P";
	public static final String SIGLA_TIPO_COMENTARIO_NEGATIVO = "N";

	
	
	



}
