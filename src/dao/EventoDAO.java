package dao;

import java.util.List;
import modelo.Evento;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class EventoDAO {
	
	String retorno = "";
	private Session session;
	
	public EventoDAO(){
		this.session =  HibernateUtil.getSession();
	}
	
	public List<Evento> ListarTodosEventos(){
		return session.createCriteria(Evento.class).addOrder(Order.asc("data")).list();
		}
	
	
	public String inserir(Evento objEvento) throws Exception{
		session.beginTransaction();		
		try{
			
			session.save(objEvento);
			session.getTransaction().commit();
			
		}catch (Exception error){
			session.getTransaction().rollback();
			retorno =  error.getMessage();	
			return retorno;
		}
		retorno = "Salvo com sucesso!";
		return retorno;
	
	}
	
	public String atualizarEvento (Evento objEvento) {
		session.beginTransaction();
		try{
			session.update(objEvento);
			session.beginTransaction().commit();

		}catch (Exception error){
			session.getTransaction().rollback();
			retorno = error.getMessage();
			return retorno;
		}
		retorno = "Atualizado com sucesso!";
		return retorno;
	}
	
}
