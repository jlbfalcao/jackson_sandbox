package test


import org.springframework.stereotype.Component

@Component
class Usuario(nome: String, email: String) {
  println("Hello Usuário");


  // construtor vazio
  def this() = this (null, null)

}
