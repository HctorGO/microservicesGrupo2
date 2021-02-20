package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String name;
	private String age;
}
