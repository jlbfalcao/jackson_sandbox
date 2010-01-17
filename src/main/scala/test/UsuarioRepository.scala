package test

import org.springframework.stereotype.Component

@Component
class UsuarioRepository {
  def getModel() = {
    new Usuario(null, null).getClass()
  }


  def getById(id: Integer): Usuario = {
    new Usuario("foo", "bar")
  }
}
