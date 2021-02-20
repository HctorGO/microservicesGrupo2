/**
 * 
 */
package mx.org.certificatic.springboot.practica23.ribbon.randommicroservice.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hgore
 *
 */
@Service
public class RandomServiceImpl implements RandomService {

	@Autowired
	private Random random;
	
	@Override
	public int next() {
		// TODO Auto-generated method stub
		return random.nextInt(40);
	}

}
