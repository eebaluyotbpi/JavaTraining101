package com.bpi.training;

import com.bpi.training.model.Club;
import com.bpi.training.model.Course;
import com.bpi.training.model.Profile;
import com.bpi.training.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class M6A5 {
		public static void main(String[] args) {
				EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
//
				try {
						printAllStudentNames(em);
						countCourseByID(em,1);
						countStudentsByAgeGreaterThan(em,21);
				} finally {



						EntityManagerUtil.getInstance().closeEntityManager(em);
						EntityManagerUtil.getInstance().shutdownFactory();
				}
		}
		static void persistManyToOne(EntityManager em) {
				em.getTransaction().begin();

				Student student1 = em.find(Student.class,1);


				Course course1 = new Course();
				course1.setCourse_name("Math");
				course1.setGrade(95);
				course1.setStudents(student1);
				em.persist(course1);

				Course course2 = new Course();
				course2.setCourse_name("English");
				course2.setGrade(75);
				course2.setStudents(student1);
				em.persist(course2);


				List<Course> student1Courses = new ArrayList<>();
				student1Courses.add(course2);
				student1Courses.add(course2);

				student1.setCourses(student1Courses);

				em.getTransaction().commit();

		}

		static void createStudent(EntityManager em) {
				try {
						em.getTransaction().begin();
						Student newStudent = new Student();
						Student newStudent2 = new Student();

						newStudent.setName("hayabusa");
						newStudent.setAge(25);
						newStudent.setEmail("hayabusa@gmail.com");

						newStudent2.setName("Sona");
						newStudent2.setAge(52);
						newStudent2.setEmail("Sona@protonmail.com");

						Course course1 = new Course("Java Programming 101");
						Course course2 = new Course("Database Management");
						Course course3 = new Course("Backend dev");



						newStudent.addCourse(course1);
						newStudent.addCourse(course2);
						newStudent.addCourse(course3);


						newStudent2.addCourse(course1);
						em.persist(newStudent);
						em.persist(newStudent2);
						em.getTransaction().commit();
				} catch (Exception e) {
						throw new RuntimeException(e);
				}


		}

		static void persistOneToOne(EntityManager em) {
				em.getTransaction().begin();

				Student newStudent = new Student();
				newStudent.setName("Garen");
				newStudent.setAge(25);
				newStudent.setEmail("garen@gmail.com");
				em.persist(newStudent);

				Profile newStudentProfile = new Profile();
				newStudentProfile.setAddress("Pasig");
				newStudentProfile.setNationality("Filipino");
				newStudentProfile.setStudent(newStudent);
				em.persist(newStudentProfile);

				newStudent.setProfile(newStudentProfile);
				em.getTransaction().commit();

		}
		static void runM6M2(EntityManager em) {
				try {
						em.getTransaction().begin();

						Student newStudent = new Student();
						newStudent.setName("Son");
						newStudent.setAge(21);
						newStudent.setEmail("Son@gmail.com");

						em.persist(newStudent);
						em.getTransaction().commit();
				} catch (Exception e) {
						throw new RuntimeException(e);
				}
		}

		static void runBirectional(EntityManager em) {
				em.getTransaction().begin();

				Student students = em.find(Student.class, 1L	);
				students.getCourses().forEach(courses -> System.out.print(courses.getCourse_name()));
		}

		static void ManyToMany(EntityManager em) {
				em.getTransaction().begin();

				Student student = em.find(Student.class, 1);
				Student student2 = em.find(Student.class,2);

				Club basketballClub = new Club();
				basketballClub.setName("BasketBall Club");
				basketballClub.setDescription("For basketball enthusiast");
				List<Student> basketballStudentList = new ArrayList<>();
				basketballStudentList.add(student);
				basketballClub.setStudents(basketballStudentList);
				em.persist(basketballClub);

				Club gleeClub = new Club();
				gleeClub.setName("Glee Club");
				gleeClub.setDescription("For students that wants to sing");
				List<Student> gleeClubstudentList = new ArrayList<>();
				gleeClubstudentList.add(student);
				gleeClubstudentList.add(student2);
				gleeClub.setStudents(gleeClubstudentList);
				em.persist(gleeClub);


				Club artClub = new Club();
				artClub.setName("Art Club");
				artClub.setDescription("For students who love art");
				List<Student> artClubstudentList = new ArrayList<>();
				artClubstudentList.add(student);
				artClubstudentList.add(student2);
				artClub.setStudents(artClubstudentList);
				em.persist(artClub);

				em.getTransaction().commit();


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
		}

		static void printAllStudentNames(EntityManager em ) {
				em.getTransaction().begin();

				String jpql = "Select s.name FROM Student s";
				TypedQuery<String> query = em.createQuery(jpql,String.class);
				List<String> studentName = query.getResultList();

				studentName.forEach(name -> System.out.println(name));

				em.getTransaction().commit();

		}

		static Long countCourseByID(EntityManager em, int id) {
				em.getTransaction().begin();

				Long totalcourse = em.createQuery(
								"SELECT COUNT(s) FROM Student s  JOIN s.courses c WHERE s.id = ?1", Long.class
				).setParameter(1,id).getSingleResult();

				System.out.println("Total course of Student ID" + id + " is " + totalcourse);
				em.getTransaction().commit();
				return totalcourse;


		}

		static Long countStudentsByAgeGreaterThan(EntityManager em, int age ) {
				em.getTransaction().begin();

				Long totalAge = em.createQuery(
								"SELECT COUNT(s) FROM Student s WHERE s.age > ?1", Long.class
				).setParameter(1,age).getSingleResult();
				System.out.println("total student with age greater than " + age + " is " + totalAge);

				em.getTransaction().commit();
				return totalAge;

		}

}