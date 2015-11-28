package dao;

import java.util.List;

import modelo.Foto;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class FotoDAO {
	private Session session;
	
	public FotoDAO() {
		this.session = HibernateUtil.getSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Foto> listarTodasFotos(){
		return session.createCriteria(Foto.class).addOrder(Order.desc("id")).list();
	}
	
	public String inserir(Foto foto){
		session.beginTransaction();
		try {
		session.save(foto);
		session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return "Ocorreu um Erro com a Mensagem : " + e.getMessage();
		}
		return "Inclu�do com Sucesso!";
	}
	
	public String remover(Foto foto) {
		session.beginTransaction();
		try {
			session.flush();
			session.clear();
			session.delete(foto);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return "Ocorreu um Erro com a Mensagem : " + e.getMessage();
		}
		return "Removido com Sucesso!";
	}

}
