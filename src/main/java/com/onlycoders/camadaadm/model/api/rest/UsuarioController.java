/* ########################## CONTROLLER API DE USUÁRIO ##########################
 * Data Criação: 14/06/2020
 * Programador: Dilan Lima
 * Decrição: Recebe as requisições, delega os processamentos e cuida dos retornos para api de usuários
 * #########################################################################
 */
package com.onlycoders.camadaadm.model.api.rest;

import com.onlycoders.camadaadm.model.entity.Usuario;
import com.onlycoders.camadaadm.model.repository.UsuarioRepository;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario){
        System.out.println(usuario);
        return repository.save(usuario);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer Id){
        repository.deleteById(Id);
    }

    @GetMapping
    public List<Usuario> list(){
        return repository.findAll();
    }

    @PatchMapping("{id}/muda-senha")
    public void MudaSenha( @PathVariable Integer Id, @RequestBody String senha){
        Optional<Usuario> usuario = repository.findById(Id);
        usuario.ifPresent( c -> {
            c.setSenha(senha);
            repository.save(c);
        });

    }

}
