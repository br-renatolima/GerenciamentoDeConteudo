package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="album")
public class Album {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String caminho;
	private String descricao;
	private String data;
	@Transient
	@OneToMany(mappedBy="album", fetch=FetchType.LAZY)
	@Cascade(value = CascadeType.ALL)
	private List<Foto> fotos;
	@Transient
	private Foto capa;

	public Album() {
	}
	
	public Album(String nome, String caminho, String descricao) {
		this.nome = nome;
		this.caminho = caminho;
		this.descricao = descricao;
		Calendar c = new GregorianCalendar();
		this.data = c.getInstance().toString();
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String string) {
		this.data = string;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Foto getCapa() {
		return capa;
	}

	public void setCapa(Foto capa) {
		this.capa = capa;
	}
	
}
