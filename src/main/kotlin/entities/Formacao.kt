package entities

class Formacao(val nome: String, val nivel: NivelFormacao, val professor: String) {

    val inscritos: MutableList<Usuario> = mutableListOf();
    private val conteudos: MutableList<ConteudoEducacional> = mutableListOf()
    val conteudosView: List<ConteudoEducacional> = conteudos;

    fun matricular(usuario: Usuario){
        this.inscritos.add(usuario);
    }
    fun matricular(vararg usuarios: Usuario){
        this.inscritos.addAll(usuarios);
    }

    fun addConteudo(conteudo: ConteudoEducacional){
        conteudos.add(conteudo);
    }

    fun addConteudo(vararg conteudos: ConteudoEducacional){
        this.conteudos.addAll(conteudos);
    }

    fun getConteudos(){
        for(conteudo in conteudos){
            println("   ${conteudo.titulo}")
        }
    }fun getUsuarios(){
        for(usuario in inscritos){
            println("${usuario}")
        }
    }

    fun getDuracao(): Int{
        var soma: Int = 0;
        for(conteudo in conteudos){
            soma += conteudo.duracao;
        }

        return soma;
    }

    fun exibirFormacao(){
        println("\nFORMACAO ${nome}   ")
        println("-----------------------------------")
        println("nível: ${this.nivel}")
        println("Carga horária: ${this.getDuracao()} horas")
        println("Conteúdos: ")
        getConteudos();
        println("Total de usuarios inscritos: ${this.inscritos.size}")
        if(inscritos.size > 0){
            println("Lista de usuários: ")
            this.getUsuarios()
        }
        println("-----------------------------------")
    }
}