package com.topico.api.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        System.out.println("==== DEBUG PASSWORD ====");
        System.out.println("Valor: [" + user.getPassword() + "]");
        System.out.println("Longitud: " + user.getPassword().length());
        System.out.println("Empieza con $2a$: " + user.getPassword().startsWith("$2a$"));
        System.out.println("========================");

        return user;
    }
}