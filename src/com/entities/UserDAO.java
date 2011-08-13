package com.entities;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entities.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String NICK_NAME = "nickName";
	public static final String FIRST_NAME = "firstName";
	public static final String IS_FIRST_NAME_PUBLIC = "isFirstNamePublic";
	public static final String LAST_NAME = "lastName";
	public static final String IS_LAST_NAME_PUBLIC = "isLastNamePublic";
	public static final String YEAR_OF_BIRTH = "yearOfBirth";
	public static final String IS_YEAR_OF_BIRTH_PUBLIC = "isYearOfBirthPublic";
	public static final String FAV_GENRE = "favGenre";
	public static final String IS_FAV_GENRE_PUBLIC = "isFavGenrePublic";
	public static final String FAV_ACTORS = "favActors";
	public static final String IS_FAV_ACTORS_PUBLIC = "isFavActorsPublic";
	public static final String ROLE_ID = "roleId";
	public static final String IS_VAILDATE = "isVaildate";
	public static final String IS_COMPLETE_PRIVATE = "isCompletePrivate";

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.String id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getSession().get("com.entities.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getSession().createCriteria("com.entities.User")
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
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByEmailAddress(Object emailAddress) {
		return findByProperty(EMAIL_ADDRESS, emailAddress);
	}

	public List findByNickName(Object nickName) {
		return findByProperty(NICK_NAME, nickName);
	}

	public List findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List findByIsFirstNamePublic(Object isFirstNamePublic) {
		return findByProperty(IS_FIRST_NAME_PUBLIC, isFirstNamePublic);
	}

	public List findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List findByIsLastNamePublic(Object isLastNamePublic) {
		return findByProperty(IS_LAST_NAME_PUBLIC, isLastNamePublic);
	}

	public List findByYearOfBirth(Object yearOfBirth) {
		return findByProperty(YEAR_OF_BIRTH, yearOfBirth);
	}

	public List findByIsYearOfBirthPublic(Object isYearOfBirthPublic) {
		return findByProperty(IS_YEAR_OF_BIRTH_PUBLIC, isYearOfBirthPublic);
	}

	public List findByFavGenre(Object favGenre) {
		return findByProperty(FAV_GENRE, favGenre);
	}

	public List findByIsFavGenrePublic(Object isFavGenrePublic) {
		return findByProperty(IS_FAV_GENRE_PUBLIC, isFavGenrePublic);
	}

	public List findByFavActors(Object favActors) {
		return findByProperty(FAV_ACTORS, favActors);
	}

	public List findByIsFavActorsPublic(Object isFavActorsPublic) {
		return findByProperty(IS_FAV_ACTORS_PUBLIC, isFavActorsPublic);
	}

	public List findByRoleId(Object roleId) {
		return findByProperty(ROLE_ID, roleId);
	}

	public List findByIsVaildate(Object isVaildate) {
		return findByProperty(IS_VAILDATE, isVaildate);
	}

	public List findByIsCompletePrivate(Object isCompletePrivate) {
		return findByProperty(IS_COMPLETE_PRIVATE, isCompletePrivate);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}