package mx.org.certificatic.springboot.practica5.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// getters ay setters
// entidad
// constructor sin argumentos
// constructor con argumentos
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
}