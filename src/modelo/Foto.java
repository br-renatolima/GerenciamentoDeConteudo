package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
public class Foto {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String caminho;
	private Date data;
	@ManyToOne(fetch=FetchType.EAGER)
	private Album album;

	public Foto(int id, String nome, String caminho, Date data, Album album) {
		this.id = id;
		this.nome = nome;
		this.caminho = caminho;
		this.data = data;
		this.album = album;
	}


	public Foto() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album_id) {
		this.album = album_id;
	}

}
