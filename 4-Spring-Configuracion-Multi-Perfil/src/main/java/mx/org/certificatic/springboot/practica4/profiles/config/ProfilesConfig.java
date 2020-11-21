package mx.org.certificatic.springboot.practica4.profiles.config;

import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import mx.org.certificatic.springboot.practica4.profiles.bean.api.DummyDataSource;
import mx.org.certificatic.springboot.practica4.profiles.customprofiles.ProductionProfile;
import mx.org.certificatic.springboot.practica4.profiles.customprofiles.StagingProfile;

// clase de configuracion
@Configuration
public class ProfilesConfig {

	// define bean DummyDataSource para perfil dev
	@Bean
	@Profile("dev")
	public DummyDataSource devDataSource() {
		
		return new DummyDataSource() {
			
			@Override
			public void connect() {
				System.out.println("dev");
			}
		};
	}
	// define bean DummyDataSource para perfil qa
	@Bean
	@Profile("qa")
	public DummyDataSource qaDataSource() {
		
		return new DummyDataSource() {
			
			@Override
			public void connect() {
				System.out.println("qa");
			}
		};
	}
	
	// define bean DummyDataSource para perfil staging con meta-anotacion
	@Bean
	@StagingProfile
	public DummyDataSource stagingDataSource() {
		
		return new DummyDataSource() {
			
			@Override
			public void connect() {
				System.out.println("staging");
			}
		};
	}
	
	// define bean DummyDataSource para perfil production con meta-anotacion
	@Bean
	@ProductionProfile
	public DummyDataSource productionDataSource() {
		
		return new DummyDataSource() {
			
			@Override
			public void connect() {
				System.out.println("production");
			}
		};
	}
}
