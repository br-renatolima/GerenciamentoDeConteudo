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
	
	public List<Foto> listarTodasFotos(){
		return session.createCriteria(Foto.class).addOrder(Order.desc("id")).list();
	}
	
	public void inserir(Foto foto){
		session.beginTransaction();
		session.save(foto);
		session.getTransaction().commit();
	}

}
