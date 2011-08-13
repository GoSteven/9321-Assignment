package com.entities;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Booking entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entities.Booking
 * @author MyEclipse Persistence Tools
 */

public class BookingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BookingDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String SHOW_TIME_ID = "showTimeId";
	public static final String NUM_OF_TICKET = "numOfTicket";

	public void save(Booking transientInstance) {
		log.debug("saving Booking instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Booking persistentInstance) {
		log.debug("deleting Booking instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Booking findById(java.lang.String id) {
		log.debug("getting Booking instance with id: " + id);
		try {
			Booking instance = (Booking) getSession().get(
					"com.entities.Booking", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Booking instance) {
		log.debug("finding Booking instance by example");
		try {
			List results = getSession().createCriteria("com.entities.Booking")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Booking instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Booking as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByShowTimeId(Object showTimeId) {
		return findByProperty(SHOW_TIME_ID, showTimeId);
	}

	public List findByNumOfTicket(Object numOfTicket) {
		return findByProperty(NUM_OF_TICKET, numOfTicket);
	}

	public List findAll() {
		log.debug("finding all Booking instances");
		try {
			String queryString = "from Booking";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Booking merge(Booking detachedInstance) {
		log.debug("merging Booking instance");
		try {
			Booking result = (Booking) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Booking instance) {
		log.debug("attaching dirty Booking instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Booking instance) {
		log.debug("attaching clean Booking instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}