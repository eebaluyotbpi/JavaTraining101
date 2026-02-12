package com.training.java.dao;

public class QueriesDao {

		public static final String INSERT_SQL = """
						INSERT into movies(title,director,showing_date)
						VALUES (?,?,?)
						RETURNING id
						""";

		public static final String SELECT_ALL_SQL = """
						SELECT id,title,director,showing_date
						FROM movies
						ORDER BY id
						""";

		public static final String SELECTBY_ID_SQL = """
						SELECT id,title,director,showing_date
						FROM movies
						WHERE id = ?
						""";
}
