package com.entities;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * FriendInvitation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entities.FriendInvitation
 * @author MyEclipse Persistence Tools
 */

public class FriendInvitationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FriendInvitationDAO.class);
	// property constants
	public static final String TO_USER = "toUser";
	public static final String FROM_USER = "fromUser";
	public static final String MESSAGE = "message";
	public static final String IS_CONFIRMED = "isConfirmed";

	public void save(FriendInvitation transientInstance) {
		log.debug("saving FriendInvitation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FriendInvitation persistentInstance) {
		log.debug("deleting FriendInvitation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FriendInvitation findById(java.lang.String id) {
		log.debug("getting FriendInvitation instance with id: " + id);
		try {
			FriendInvitation instance = (FriendInvitation) getSession().get(
					"com.entities.FriendInvitation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FriendInvitation instance) {
		log.debug("finding FriendInvitation instance by example");
		try {
			List results = getSession()
					.createCriteria("com.entities.FriendInvitation")
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
		log.debug("finding FriendInvitation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FriendInvitation as model where model."
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

	public List findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	public List findByIsConfirmed(Object isConfirmed) {
		return findByProperty(IS_CONFIRMED, isConfirmed);
	}

	public List findAll() {
		log.debug("finding all FriendInvitation instances");
		try {
			String queryString = "from FriendInvitation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FriendInvitation merge(FriendInvitation detachedInstance) {
		log.debug("merging FriendInvitation instance");
		try {
			FriendInvitation result = (FriendInvitation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FriendInvitation instance) {
		log.debug("attaching dirty FriendInvitation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FriendInvitation instance) {
		log.debug("attaching clean FriendInvitation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}