package br.com.eventosbook.pojo;


public class FormularioContratante extends Formulario {
	
	public FormularioContratante() {
		super();
	}
	
	private String CPF;
	private String dataNascimento;
	private String sexo;
	private String idContratante;
	private String idUsuario;
	
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getIdContratante() {
		return idContratante;
	}

	public void setIdContratante(String idContratante) {
		this.idContratante = idContratante;
	}
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	

	
	
}
