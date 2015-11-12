package dao;

import java.util.List;

import modelo.Administrador;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class AdministradorDAO {
	private Session session;

	public AdministradorDAO() {
		this.session = HibernateUtil.getSession();
	}

	public List<Administrador> listarTodos() {
		return session.createCriteria(Administrador.class).addOrder(Order.asc("id")).list();
	}
	
	public String inserir(Administrador adm){
		session.beginTransaction();		
		try {
			session.save(adm);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return e.getMessage();
		}
		return "Salvo com Sucesso!";
	}
	
	public String atualizar(Administrador adm){
		session.beginTransaction();		
		try {
			session.update(adm);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return e.getMessage();
		}
		return "Atualizado com Sucesso!";
	}

	public String remover(Administrador adm) {
		session.beginTransaction();		
		try {
			session.delete(adm);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return e.getMessage();
		}
		return "Removido com Sucesso!";
	}
}
