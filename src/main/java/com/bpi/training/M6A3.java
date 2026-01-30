package com.bpi.training;

import jakarta.persistence.EntityManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class M6A3 {
		public static void main(String[] args) {
				EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
				try {
						createStudent(em);
					persistOneToMany(em);
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
		static void createStudent(EntityManager em) {
				em.getTransaction().begin();

				Student newStudent = new Student();
				newStudent.setName("Hayabusa");
				newStudent.setAge(43);
				newStudent.setEmail("Hayabusa@protonmail.com");
				em.persist(newStudent);

				em.getTransaction().commit();
		}
		static void persistOneToMany(EntityManager em) {
				em.getTransaction().begin();

				Student student1 = em.find(Student.class,2);

				Courses newCourse = new Courses();
				newCourse.setGrade(1);
				newCourse.setCourse_name("Math Developer");
				newCourse.setStudent(student1);
				em.persist(newCourse);

				em.getTransaction().commit();
		}
}