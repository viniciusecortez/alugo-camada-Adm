package com.onlycoders.camadaadm;

import com.onlycoders.camadaadm.model.entity.Usuario;
import com.onlycoders.camadaadm.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CamadaAdmApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired UsuarioRepository repository){
		return args -> {
			Usuario usuario = new Usuario();
			usuario.setNome("Fulano do banco");
			usuario.setEmail("fulanodobanco@email.com");
			usuario.setLogin("fulano");
			usuario.setSenha("456");
			repository.save(usuario);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CamadaAdmApplication.class, args);
	}

}
