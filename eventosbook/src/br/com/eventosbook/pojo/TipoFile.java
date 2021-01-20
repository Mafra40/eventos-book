package br.com.eventosbook.pojo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 
 * @author Mafra
 *
 */
@JsonIgnoreProperties({"bytes"}) 
public  class TipoFile implements Serializable { 
	
	private static final long serialVersionUID = -9067764144865668836L;
	
	private String aNome;
    private long aSize;
    private String aType;
    /**URL pública.
     * 
     */
    private String aCaminho; 
    private String aCaminhoPath;
 
    private byte[] bytes;
    
    public TipoFile() {
	}

	public TipoFile(String aNome, long aSize, String aType, byte[] bytes) {
		this.aNome = aNome;
		this.aSize = aSize;
		this.aType = aType;
		this.bytes = bytes;
	}

	public String getNome() {
		return aNome;
	}

	public void setNome(String aNome) {
		this.aNome = aNome;
	}

	public long getSize() {
		return aSize;
	}

	public void setSize(long aSize) {
		this.aSize = aSize;
	}

	public String getType() {
		return aType;
	}

	public void setType(String aType) {
		this.aType = aType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	

	public String getCaminho() {
		return aCaminho;
	}

	public void setCaminho(String aCaminho) {
		this.aCaminho = aCaminho;
	}

	public String getaCaminhoPath() {
		return aCaminhoPath;
	}

	public void setaCaminhoPath(String aCaminhoPath) {
		this.aCaminhoPath = aCaminhoPath;
	}
    
    

}
