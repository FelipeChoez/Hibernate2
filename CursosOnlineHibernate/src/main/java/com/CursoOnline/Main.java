package com.CursoOnline;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entidades.Curso;
import com.entidades.Estudiante;

//import com.entidades.Curso;

public class Main {

	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	public static void main(String[] args) {
		     // Curso cur1 = new Curso("Fundamentos java");
	         // Curso cur2 = new Curso("hibernate principantes");
	           
	           //ingresarCurso(cur1);
	           //ingresarCurso(cur2);
		
		           Estudiante estu1 = new Estudiante(0,"pedro", "carbo","pedro@gmial.com");
		           ingresarEstudiante(estu1);
		           Estudiante estu2 = new Estudiante(0,"carlos", "lucas","carloso@gmial.com");
		           ingresarEstudiante(estu2);
		           Estudiante estu3 = new Estudiante(0,"jose", "maria","jose@gmial.com");
		           ingresarEstudiante(estu3);
		           Estudiante estu4 = new Estudiante(0,"pedro", "maria","jose@gmial.com");
		           ingresarEstudiante(estu4);
		           
		           
		           //List<Estudiante> estudiantes = getEstudiante();
		           
		         //  for (Estudiante temp:estudiantes) {
		        	//   System.out.println(temp);
		           //}
		          // List<Estudiante> estudiante = getEstudiantePorNombre("pedro");
		           //for (Estudiante e: estudiante) {
		        	 //  System.out.println(e);
		           
		           //}
		           
		          // Estudiante estudiante = new Estudiante(1,"ronald", "choezch", "gamil");
                  // modificarEstudiante(estudiante);
		           
		            //Curso curso = new Curso(1, "base de datos 2");
		            //modificarCurso(curso);
		          
		           
		           
	}
	
	static void modificarCurso(Curso curso)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(curso);
		session.getTransaction().commit();
		session.close();
		
	}
	
	static void eliminarCurso(Curso curso) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(curso);
		session.getTransaction().commit();
		session.close();
   		  
		
		
	}
	
	
	 static void modificarEstudiante(Estudiante estudiante) {
		    Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(estudiante);
			session.getTransaction().commit();
			session.close();
		 
		 
	 }
	
	
   	  static void eliminarEstudiante(Estudiante estudiante) {
   		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(estudiante);
		session.getTransaction().commit();
		session.close();
   	  }
		
    
	
	
	
	
	    static List<Estudiante>getEstudiantePorNombre(String nombre){
	    	Session session = sessionFactory.openSession();
			 Query query= session.createQuery("from Estudiante where nombre=:nombre");
	    	      query.setParameter("nombre", nombre);
	    	
	    	List<Estudiante> estudiante= (List<Estudiante>) query.getResultList();
		
	    	return estudiante;
	    	 
	    }
	    
	    
	    
	    
	     
	     static List<Estudiante>getEstudiante()
	     {
	    	 Session session = sessionFactory.openSession();
			 List<Estudiante>estudiantes = session.createQuery("from Estudiante",Estudiante.class).list(); 
			 return estudiantes;
			 
	     }
	     
	     
	
	    static List<Curso>getCursos(){
		Session session = sessionFactory.openSession();
		 List<Curso>cursos = session.createQuery("from Curso", Curso.class).list(); 
		 return cursos;
		
	      }
	
	     
	
	
	static void ingresarCurso(Curso curso) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(curso);
		session.getTransaction().commit();
		session.close();
	}

	
	static void ingresarEstudiante(Estudiante estudiante) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(estudiante);
		session.getTransaction().commit();
		session.close();
	}
}
