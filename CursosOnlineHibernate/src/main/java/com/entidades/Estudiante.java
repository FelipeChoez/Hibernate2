package com.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estudiante {
  @Id
  @GeneratedValue
  
  private int id;
  private String nombre;
  private String apellido;
  private String Email;
  
  
 public Estudiante() {
	 
 }

public Estudiante(int id, String nombre, String apellido, String email) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apellido = apellido;
	Email = email;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

@Override
public String toString() {
	return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", Email=" + Email + "]";
}
  
  
  
}
