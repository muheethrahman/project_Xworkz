package com.xworkz.vacccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

import com.xworkz.vacccine.entity.VaccineEntity;

@Component
public class VaccineDAOImpl implements VaccineDAO {
	@Autowired
	private SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public   VaccineDAOImpl() {
		System.out.println(getClass().getSimpleName() + "object is created");
	}

	public boolean saveVaccineDTO(VaccineEntity vaccineEntity) {
		 LOGGER.log(Level.INFO, "Save Method started");
		//System.out.println("Save Method started");
		Session session = this.factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(vaccineEntity);
			transaction.commit();
			LOGGER.log(Level.INFO,"data is saved in sql successfully");
			//System.out.println("data is saved in SQL successfully");
			return true;
		} catch (Exception exp) {
			session.getTransaction().rollback();
			LOGGER.log(Level.INFO,"data is not saved,rolling back"+exp.getMessage());
			//System.out.println("data is not saved,rolling back"+exp.getMessage());
		} finally {
			if (session != null) {
				LOGGER.log(Level.INFO,"Session Closed");
				//System.out.println("Session Closed");
				session.close();
			} else {
				LOGGER.log(Level.INFO,"Session Not Closed");
				//System.out.println("Session not closed");
			}
		}
		return false;
	}

	@Override
	public VaccineEntity getEmailByEntity(String email,String password) {
		VaccineEntity enrollEntity = null;
		Object session = null;
		try {
			session = this.factory.openSession();
			Query<VaccineEntity> query = ((QueryProducer) session).createNamedQuery("GetRecordByMail");
			query.setParameter("em", email);
			query.setParameter("e", password);
			enrollEntity = (VaccineEntity) query.uniqueResult();
			return enrollEntity;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.INFO,"You have an exception " + e.getMessage());
			//System.out.println("You have an exception " + e.getMessage());
			return null;
		} finally {
			if (session != null) {
				LOGGER.log(Level.INFO,"Session is closed");
				//System.out.println("Session is closed");
			} else {
				LOGGER.log(Level.INFO,"Session is not closed");
				//System.out.println("Session is not closed");
			}
		}

	}

}