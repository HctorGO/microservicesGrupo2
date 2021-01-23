package mx.org.certificatic.springboot.practica18.gateway.aggregates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.org.certificatic.springboot.practica18.gateway.restcontroller.IProductAggregate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesktopProductAggregate implements IProductAggregate {

	private String price;
	private String imagePath;

}