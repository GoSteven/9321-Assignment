package com.entities;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Movies entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entities.Movies
 * @author MyEclipse Persistence Tools
 */

public class MoviesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MoviesDAO.class);
	// property constants
	public static final String MOVIE_TITLE = "movieTitle";
	public static final String POSTER = "poster";
	public static final String YOUTUBE_LINK = "youtubeLink";
	public static final String ACTORS = "actors";
	public static final String GENRE = "genre";
	public static final String DIRECTOR = "director";
	public static final String SHORT_SYNOPSIS = "shortSynopsis";
	public static final String AGE_RATING = "ageRating";

	public void save(Movies transientInstance) {
		log.debug("saving Movies instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movies persistentInstance) {
		log.debug("deleting Movies instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movies findById(java.lang.String id) {
		log.debug("getting Movies instance with id: " + id);
		try {
			Movies instance = (Movies) getSession().get("com.entities.Movies",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Movies instance) {
		log.debug("finding Movies instance by example");
		try {
			List results = getSession().createCriteria("com.entities.Movies")
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
		log.debug("finding Movies instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Movies as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieTitle(Object movieTitle) {
		return findByProperty(MOVIE_TITLE, movieTitle);
	}

	public List findByPoster(Object poster) {
		return findByProperty(POSTER, poster);
	}

	public List findByYoutubeLink(Object youtubeLink) {
		return findByProperty(YOUTUBE_LINK, youtubeLink);
	}

	public List findByActors(Object actors) {
		return findByProperty(ACTORS, actors);
	}

	public List findByGenre(Object genre) {
		return findByProperty(GENRE, genre);
	}

	public List findByDirector(Object director) {
		return findByProperty(DIRECTOR, director);
	}

	public List findByShortSynopsis(Object shortSynopsis) {
		return findByProperty(SHORT_SYNOPSIS, shortSynopsis);
	}

	public List findByAgeRating(Object ageRating) {
		return findByProperty(AGE_RATING, ageRating);
	}

	public List findAll() {
		log.debug("finding all Movies instances");
		try {
			String queryString = "from Movies";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Movies merge(Movies detachedInstance) {
		log.debug("merging Movies instance");
		try {
			Movies result = (Movies) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movies instance) {
		log.debug("attaching dirty Movies instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movies instance) {
		log.debug("attaching clean Movies instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}