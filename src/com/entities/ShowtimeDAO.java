package com.entities;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Showtime entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entities.Showtime
 * @author MyEclipse Persistence Tools
 */

public class ShowtimeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ShowtimeDAO.class);
	// property constants
	public static final String CINEMA_ID = "cinemaId";
	public static final String MOVIE_ID = "movieId";
	public static final String PRICE = "price";

	public void save(Showtime transientInstance) {
		log.debug("saving Showtime instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Showtime persistentInstance) {
		log.debug("deleting Showtime instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Showtime findById(java.lang.String id) {
		log.debug("getting Showtime instance with id: " + id);
		try {
			Showtime instance = (Showtime) getSession().get(
					"com.entities.Showtime", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Showtime instance) {
		log.debug("finding Showtime instance by example");
		try {
			List results = getSession().createCriteria("com.entities.Showtime")
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
		log.debug("finding Showtime instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Showtime as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCinemaId(Object cinemaId) {
		return findByProperty(CINEMA_ID, cinemaId);
	}

	public List findByMovieId(Object movieId) {
		return findByProperty(MOVIE_ID, movieId);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findAll() {
		log.debug("finding all Showtime instances");
		try {
			String queryString = "from Showtime";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Showtime merge(Showtime detachedInstance) {
		log.debug("merging Showtime instance");
		try {
			Showtime result = (Showtime) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Showtime instance) {
		log.debug("attaching dirty Showtime instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Showtime instance) {
		log.debug("attaching clean Showtime instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}