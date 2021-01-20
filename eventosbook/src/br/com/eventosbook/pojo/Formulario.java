package br.com.eventosbook.pojo;


/**
 * @author Andre Lucas
 * 
 * A Classe Frmulario, serve para facilitar a recuperação dos atributos,
 * nos formulários do Sistema, (CADASTRO, ALTERACAO, etc..), ela deve ser passada por parâmentro no 
 * Controlador da entidade que se está sendo implementada,
 * depois passada pela camada de serviços e depois na RN pertencente 
 * a sua entidade.
 * 
 * Ex:
 * 
 * @Controller
 * public EntidadeControlador(){
 * 		public String efetuarCadastroEntidade(Formulario pFormulario){
 * 			EntidadeServico.getInstance().incluirEntidade(pFormulario);
 * 		}
 * }
 * */
public class Formulario {
	
	private String codigo;
	
	private String valorSelect;
	private String nome;
	private String email;
	private String senha;
	private String confirmSenha;
	private String senhaAtual;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String contato1;
	private String contato2;
	private String contato3;

	private String idTelefone1;
	private String idTelefone2;
	private String idTelefone3;
	private String logradouro;
	private String cep;
	private String complemento;
	private String numero;
	private String idEndereco;
	private String bairro;
	private String estado;
	private String cidade;
	private String data;
	private String dataCriacao;
	private String dataUltmiaAtualizacao;
	private String valorAvaliacao;
	private String campoComentarioPositivo;
	private String campoComentarioNegativo;
	private String campoOrdenacao;
	
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getDataUltmiaAtualizacao() {
		return dataUltmiaAtualizacao;
	}
	public void setDataUltmiaAtualizacao(String dataUltmiaAtualizacao) {
		this.dataUltmiaAtualizacao = dataUltmiaAtualizacao;
	}
	private String hora;
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmSenha() {
		return confirmSenha;
	}
	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getTelefone3() {
		return telefone3;
	}
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	
	public String getIdTelefone1() {
		return idTelefone1;
	}
	public void setIdTelefone1(String idTelefone1) {
		this.idTelefone1 = idTelefone1;
	}
	public String getIdTelefone2() {
		return idTelefone2;
	}
	public void setIdTelefone2(String idTelefone2) {
		this.idTelefone2 = idTelefone2;
	}
	public String getIdTelefone3() {
		return idTelefone3;
	}
	public void setIdTelefone3(String idTelefone3) {
		this.idTelefone3 = idTelefone3;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String Logradouro) {
		this.logradouro = Logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getValorSelect() {
		return valorSelect;
	}
	public void setValorSelect(String valorSelect) {
		this.valorSelect = valorSelect;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getContato1() {
		return contato1;
	}
	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}
	public String getContato2() {
		return contato2;
	}
	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}
	public String getContato3() {
		return contato3;
	}
	public void setContato3(String contato3) {
		this.contato3 = contato3;
	}
	public String getSenhaAtual() {
		return senhaAtual;
	}
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}
	public String getValorAvaliacao() {
		return valorAvaliacao;
	}
	public void setValorAvaliacao(String valorAvaliacao) {
		this.valorAvaliacao = valorAvaliacao;
	}
	public String getCampoComentarioPositivo() {
		return campoComentarioPositivo;
	}
	public void setCampoComentarioPositivo(String campoComentarioPositivo) {
		this.campoComentarioPositivo = campoComentarioPositivo;
	}
	public String getCampoComentarioNegativo() {
		return campoComentarioNegativo;
	}
	public void setCampoComentarioNegativo(String campoComentarioNegativo) {
		this.campoComentarioNegativo = campoComentarioNegativo;
	}
	public String getCampoOrdenacao() {
		return campoOrdenacao;
	}
	public void setCampoOrdenacao(String campoOrdenacao) {
		this.campoOrdenacao = campoOrdenacao;
	}
	
	
	
	
}
