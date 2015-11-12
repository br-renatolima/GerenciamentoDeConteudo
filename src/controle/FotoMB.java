package controle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import modelo.Album;
import modelo.Foto;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import dao.AlbumDAO;
import dao.FotoDAO;

@ManagedBean(name="FotoMB")
@RequestScoped
public class FotoMB implements Serializable{
	
	private static final long serialVersionUID = -275335211801099493L;
	private List<Foto> fotos = new ArrayList<Foto>();
	private FotoDAO DAOFoto = new FotoDAO();
	private Album album = new Album();
	private AlbumDAO DAOAlbum = new AlbumDAO();
	private List<Album> albuns = new ArrayList<Album>();
	UploadedFile foto;
	
	public FotoMB(){
		this.setFotos(DAOFoto.listarTodasFotos());
		this.setAlbuns(DAOAlbum.listarTodos());
	}
	
	public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Sucesso! ", event.getFile().getFileName() + " conluido!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        System.out.println(event.getFile().getFileName());
        this.foto = event.getFile();
        try {
			this.salvar(foto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	
	public void salvar(UploadedFile foto) throws IOException{
		String filename = FilenameUtils.getName(foto.getFileName());
	    InputStream input = foto.getInputstream();
	    File f = new File("teste.txt");
	    System.out.println(f.getAbsolutePath());
	    OutputStream output = new FileOutputStream(new File("../img/fotos/", filename));
	    try {
	        IOUtils.copy(input, output);
	    } finally {
	        IOUtils.closeQuietly(input);
	        IOUtils.closeQuietly(output);
	    }
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void setAlbuns(List<Album> list) {
		Collection toReturn = new ArrayList();
		for (Album album : list) {
			toReturn.add(new SelectItem(album.getId(), album.getNome()));
		}
		this.albuns.addAll(toReturn);
	}
	
	public List<Album> getAlbuns(){
		return this.albuns;
	}

}
