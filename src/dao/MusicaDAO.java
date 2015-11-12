package dao;

import java.util.List;
import modelo.Musica;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class MusicaDAO {
	private Session session;

	public MusicaDAO() {
		this.session = HibernateUtil.getSession();
	}

	public List<Musica> ListarTodas() {
		return session.createCriteria(Musica.class).addOrder(Order.desc("id")).list();
	}
	
	public String inserir(Musica musica){
		session.beginTransaction();
		try {
			session.save(musica);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return e.getMessage();
		}
		return "Salvo com sucesso!";
	}

	public String atualizar(Musica musica) {
		session.beginTransaction();
		try {
			session.update(musica);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return e.getMessage();
		}
		return "Atualizado com sucesso!";
	}

	public String remover(Musica musica) {
		session.beginTransaction();
		try {
			session.delete(musica);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return e.getMessage();
		}
		return "Removido com sucesso!";
	}
}
