package com.bpi.training.m6act2;

import jakarta.persistence.EntityManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class m6a2 {
		public static void main(String[] args) {
				EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
				try {
						runM6Activity2(em);

				} finally {

						EntityManagerUtil.getInstance().closeEntityManager(em);
						EntityManagerUtil.getInstance().shutdownFactory();
				}
		}


		static void testConnection() {
				EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

				try {
						if(em.isOpen()) {
								System.out.println("entity manager open, ready to create transaction");
						}

				} finally {
						EntityManagerUtil.getInstance().closeEntityManager(em);
						EntityManagerUtil.getInstance().shutdownFactory();
				}
		} // End of Test Connection

		static void runM6Activity2(EntityManager em) {
				try {
						em.getTransaction().begin();

						Student newStudent = new Student();
						newStudent.setName("Juan Dela Paz");
						newStudent.setAge(25);
						newStudent.setEmail("jdpaz@gmail.com");

						em.persist(newStudent);
						em.getTransaction().commit();
						System.out.println("is the newStudent still in persist context :" + em.contains(newStudent));

				} catch (RuntimeException e) {
						throw new RuntimeException(e);
				}
		} // Run M6 Activity #2

		static void runBirectional(EntityManager em) {
				em.getTransaction().begin();
				Student student = em.find(Student.class, 1L);

				student.getCourse().forEach(course -> System.out.print(course.getCourse_name()));
				em.getTransaction().commit();

		}
}