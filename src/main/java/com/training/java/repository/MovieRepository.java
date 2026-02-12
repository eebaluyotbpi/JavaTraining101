package com.training.java.repository;

import com.training.java.model.Movie;
import com.training.java.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class MovieRepository {
		private static final String PU = "default";
		private static final EntityManagerFactory emf =
						jakarta.persistence.Persistence.createEntityManagerFactory(PU);

		public MovieRepository(EntityManager em) {
		}

		public Movie save(Movie entity) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				try {
						tx.begin(); // starts the transaction

						Movie managed;
						if (entity.getId() == null) {
								em.persist(entity);
								em.flush(); // Generate the id automatically
								managed = entity;
						} else {
								managed = em.merge(entity);
								em.flush();
						}
						tx.commit();
						return managed;
				} catch (RuntimeException e) {
						if (tx.isActive()) tx.rollback();
						throw e;
				} finally {
						em.close();
				}
		}

		public List<Movie> findAll() {
				EntityManager em = emf.createEntityManager();
				try {
						return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
				} finally {
						em.close();
				}
		}

		public Movie findById(Long id) {
				EntityManager em = emf.createEntityManager();
				try {
						return em.find(Movie.class, id);   // returns null if not found
				} finally {
						em.close();
				}
		}


		/*
		Use Optional<Movie>
			try {
						TypedQuery<Movie> query = em.createQuery(
										"SELECT m FROM Movies m WHERE m.id", Movie.class
						);
						query.setParameter("id",id);
						List<Movie> results = query.getResultList();
						return results.isEmpty()? Optional.empty() : Optional.of(results.get(0));
				} finally {
						em.close();
				}
		 */
}