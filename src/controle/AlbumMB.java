package controle;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import modelo.Album;
import dao.AlbumDAO;

@ManagedBean(name="AlbumMB")
@RequestScoped
public class AlbumMB {
	
	private List<Album> albuns = new ArrayList<Album>();
	private AlbumDAO dao = new AlbumDAO();
	private int id;
	private String nome;
	private String caminho;
	private String descricao;
	private Date data;
	private Album album;

	public AlbumMB() {
		this.setAlbuns(dao.listarTodos());
		
		if (album == null) {
			// obtem parametro
			ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
	        String idParam = ctx.getRequestParameterMap().get("id");
			if (idParam != null && !idParam.equals("")) {
				try {
					this.album = this.getAlbumPorId(Integer.parseInt(idParam));
				} catch(NumberFormatException e) {
					// log 
				}
			}			
			if (this.album == null) {
				this.album = new Album();
			}
		}
	}

	public Album getAlbumPorId(int parseInt) {
		for (Album album : albuns) {
			if(album.getId() == parseInt){
				return album;
			}
		}
		return null;
	}

	public void salvar(){
		Album a = new Album();
		a.setCaminho("../img/fotos/" + this.getNome());
		a.setNome(this.getNome());
		a.setDescricao(getDescricao());
		a.setData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		try {			
			new File(a.getCaminho()).mkdirs();
			dao.inserir(a);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Salvo com Sucesso!");
	}
	
	public void atualizar(){
		dao.atualizar(album);
	}
	
	public void remover(){
		dao.remover(album);
	}
	
	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}
	
	public AlbumDAO getDAOAlbum() {
		return dao;
	}

	public void setDAOAlbum(AlbumDAO dAOAlbum) {
		this.dao = dAOAlbum;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}
