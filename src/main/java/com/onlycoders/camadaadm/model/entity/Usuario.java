/* ########################## ENTIDADE DE USUÁRIO ##########################
 * Data Criação: 14/06/2020
 * Programador: Dilan Lima
 * Decrição: Entidade que mapea a tabela de usuários
 * #########################################################################
  */

package com.onlycoders.camadaadm.model.entity;

import java.util.Objects;

import javax.persistence.*;


@Entity
public class Usuario {

    /*o @ID e o @GeneratedValue dizem que a variável id é do tipo auto incremento*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String senha;

    public void setSenha(String senha){
      this.senha = senha;
    }

    public void setNome(String nome){
      this.nome = nome;
    }

  public Usuario() {
  }

  public Usuario(Integer id, String nome, String email, String login, String senha) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.login = login;
    this.senha = senha;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }


  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLogin() {
    return this.login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return this.senha;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(login, usuario.login) && Objects.equals(senha, usuario.senha);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, email, login, senha);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", nome='" + getNome() + "'" +
      ", email='" + getEmail() + "'" +
      ", login='" + getLogin() + "'" +
      ", senha='" + getSenha() + "'" +
      "}";
  }

    
}
