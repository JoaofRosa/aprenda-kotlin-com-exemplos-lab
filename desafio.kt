enum class EstadoMatricula { MATRICULADO, NAO_MATRICULADO }

data class Usuario(val id: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    val estadoMatricula = mutableMapOf<Usuario, EstadoMatricula>()
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            estadoMatricula[usuario] = EstadoMatricula.MATRICULADO
            println("Usuário ${usuario.id} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.id} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    val curso1 = ConteudoEducacional("Curso 1", 30)
    val curso2 = ConteudoEducacional("Curso 2", 45)
    val curso3 = ConteudoEducacional("Curso 3", 60)
    val formacao = Formacao("Formação Kotlin", listOf(curso1, curso2, curso3))

    val usuario1 = Usuario("123")
    val usuario2 = Usuario("456")

    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2) 

    formacao.matricular(usuario1) 

    
    println("Estado de matrícula de ${usuario1.id}: ${formacao.estadoMatricula[usuario1]}")
    println("Estado de matrícula de ${usuario2.id}: ${formacao.estadoMatricula[usuario2]}")
}
