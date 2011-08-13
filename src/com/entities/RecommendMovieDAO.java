package com.entities;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * RecommendMovie entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entities.RecommendMovie
 * @author MyEclipse Persistence Tools
 */

public class RecommendMovieDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RecommendMovieDAO.class);
	// property constants
	public static final String TO_USER = "toUser";
	public static final String FROM_USER = "fromUser";
	public static final String MOVIE_ID = "movieId";
	public static final String IS_READED = "isReaded";

	public void save(RecommendMovie transientInstance) {
		log.debug("saving RecommendMovie instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RecommendMovie persistentInstance) {
		log.debug("deleting RecommendMovie instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RecommendMovie findById(java.lang.String id) {
		log.debug("getting RecommendMovie instance with id: " + id);
		try {
			RecommendMovie instance = (RecommendMovie) getSession().get(
					"com.entities.RecommendMovie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RecommendMovie instance) {
		log.debug("finding RecommendMovie instance by example");
		try {
			List results = getSession()
					.createCriteria("com.entities.RecommendMovie")
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
		log.debug("finding RecommendMovie instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RecommendMovie as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByToUser(Object toUser) {
		return findByProperty(TO_USER, toUser);
	}

	public List findByFromUser(Object fromUser) {
		return findByProperty(FROM_USER, fromUser);
	}

	public List findByMovieId(Object movieId) {
		return findByProperty(MOVIE_ID, movieId);
	}

	public List findByIsReaded(Object isReaded) {
		return findByProperty(IS_READED, isReaded);
	}

	public List findAll() {
		log.debug("finding all RecommendMovie instances");
		try {
			String queryString = "from RecommendMovie";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RecommendMovie merge(RecommendMovie detachedInstance) {
		log.debug("merging RecommendMovie instance");
		try {
			RecommendMovie result = (RecommendMovie) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RecommendMovie instance) {
		log.debug("attaching dirty RecommendMovie instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RecommendMovie instance) {
		log.debug("attaching clean RecommendMovie instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}