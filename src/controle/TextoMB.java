package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.TextoDAO;
import modelo.Texto;

@ManagedBean(name="TextoMB")
@RequestScoped
public class TextoMB {
	
	private Texto texto;
	private TextoDAO dao;
	private String release;
	private String agradecimento;
	private List<Texto> textos;
	
	public TextoMB() {
		this.texto = new Texto();
		this.dao = new TextoDAO();
		this.textos = new ArrayList<Texto>();
		
		this.setTextos(dao.ListarTodosTextos());
		this.setRelease();
		this.setAgradecimento();
	}
	
	public TextoDAO getDao() {
		return dao;
	}

	public void setDao(TextoDAO dao) {
		this.dao = dao;
	}

	public Texto getTexto() {
		return texto;
	}

	public void setTexto(Texto texto) {
		this.texto = texto;
	}
	

	public String getRelease() {
		return release;
	}

	public void setRelease() {
		for (Texto texto : textos) {
			if(texto.getId() == 1){
				this.release = texto.getTexto();
			}
		};
	}

	public String getAgradecimento() {
		return agradecimento;
	}

	public void setAgradecimento() {
		for (Texto texto : textos) {
			if(texto.getId() == 1){
				this.agradecimento = texto.getTexto();
			}
		};
	}

	public List<Texto> getTextos() {
		return textos;
	}

	public void setTextos(List<Texto> textos) {
		if (textos.isEmpty() || textos == null) {
			Texto t = new Texto("<p>A Banda Orbita Crist� foi gerada na cabe�a e no cora��o do Vocalista e Compositor"
		            + " Vin�cius Gon�alves atrav�s de uma ora��o, na qual o m�sico pedia a Deus uma banda de"
					+ " rock crist�, quando Deus lhe entregou o nome (<b>�rbita Crist�</b>)... O m�sico que j� havia"
		            + " integrado algumas bandas seculares, como a Banda Reverse 69, a banda � qual ele abriu"
					+ " m�o para servir a Deus em 2009, ainda tinha o sonho de se tornar um musico, por�m,"
		            + " dessa vez com can��es e banda que por onde passasse levasse a palavra de Deus... </p><p>"
					+ " Mas iniciou no ano de 2011 e n�o passou de esbo�o... Muitas id�ias, planos, sonhos, e"
		            + " um s� objetivo: Alcan�ar o Almejado. Segundos, minutos, horas, dias, meses e at�"
					+ " mesmo anos se passaram, para que essa id�ia sa�sse do papel e tomasse forma... </p><p> Em"
		            + " setembro de 2013, Vin�cius Gon�alves que j� conhecia, n�o s� como amigos de igreja"
					+ " como tamb�m j� haviam tirado som com o baterista Paulo Freitas, que sempre sonhou"
		            + " em integrar a uma banda de rock crist�o e o Guitarrista Renato Lima, que j� integrava"
		            + " uma banda de rock crist�, a qual estava parada cumprindo alguns prop�sitos pessoais,"
		            + " tamb�m sonhava em realizar seu sonho de anunciar a palavra de Deus atrav�s de"
		            + " can��es impactantes, ent�o resolveram tirar tudo do papel e por em pr�tica, foi quando "
		            + " um r�pido ensaio com musicas autorais, que superou as expectativas de todos... </p><p>"
		            + " Pois a banda que hoje j� se faz existente, come�ou apenas com um vocal, um batera e uma"
		            + " guitarra, e logo conseguiu seu segundo guitarrista Davi Coutinho, que tamb�m � da mesma"
		            + " igreja que os outros integrantes e tinha o imenso sonho de se tornar musico profissional e"
		            + " tocar em uma banda, e assim foi convidado a fazer parte dessa fam�lia... </p><p>"
		            + " Desde ent�o n�o mais apenas um esbo�o, um rabisco e nem s� uma ideia, mais j� havia tomado sua"
		            + " forma real para alcan�ar o Almejado que era anunciar a palavra de Deus atrav�s de can��es impactantes... </p><p>"
		            + " A Banda ent�o passou a existir, aonde come�aram ensaios, e as divulga��es, hoje o objetivo de um se tornou objetivo da Banda... </p><p>"
		            + " A banda que tem diversas m�sicas autorais, na qual algumas est�o em fase de arranjos, outras j�"
		            + " fechadas, aguardando a oportunidade em DEUS para tir�-las do papel."
		            + " </p><p>No dia 10 de Janeiro de 2014, Renato Lima, resolve se dedicar exclusivamente a Banda �rbita Crist�, e anuncia sua sa�da, de sua antiga banda, que estava em per�odo de termino."
		            + " </p><p> Ap�s um per�odo de conversas e an�lises, no dia 04 de Janeiro de 2014, a banda passou a contar"
		            + " com o baixista Pedro Fraga, conhecido de longa data do guitarrista Renato Lima, e primo da namorada do vocalista Vin�cius Gon�alves, que ap�s um ensaio, o novo membro ent�o passou a se dedicar � banda e mais ainda ao seu minist�rio."
		            + " </p><p> No dia 09 de Janeiro de 2014, Andressa Ferreira, que � da mesma igreja que parte da banda, j� conhecida e amiga de longas data dos integrantes, foi convidada a estar integrando como segundo vocal da"
		            + " banda, e alguns meses ap�s sua entrada na banda, realizaram as grava��es da singles <b>AO LADO TEU</b>& <b>LOUCURA QUE TR�S VIDA</b>, providenciando tamb�m, Fotos Promo, V�deos e seu pr�prio site."
		            + " </p><p> No dia 22 de Abril 2015 foi anunciado oficialmente a sa�da do Guitarrista Davi Coutinho, para cumprir seus prop�sitos pessoais e ministeriais, onde ele deixou uma grande li��o para todos, obede�endo os prop�sitos de Deus pra vida dele."
		            + " </p><p> Contudo a banda que � da baixada Fluminense, da cidade de Belford Roxo RJ, ainda � uma banda independente, vem buscando aprimorar conhecimentos e tentando entrar no cen�rio underground, como uma banda de Rock"
		            + " Crist�o..."
		            + " <br><Br>"
		            + " Integrada por:"
		            + " <br><br>"
		            + " Vin�cius Gon�alves : Vocal / Composi��es / Back<br>"
		            + " Andressa Ferreira : Vocal / Composi��es / Back<br>"
		            + " Renato Lima : Guitarra <br>"
		            + " Paulo Freitas : Bateria <br>"
		            + " Pedro Fraga : Contrabaixo <br>"
		            + " </p>");
			dao.inserir(t);
			textos.add(t);
		}
		this.textos = textos;
	}
	
	public String salvar(){
		dao.inserir(texto);
		return null;
	}

}
