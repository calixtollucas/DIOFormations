package entities

data class Usuario(val nome: String, val email: String, val senha: String) {
    private var nextLevelXp: Int = 1000;
    private var level: Int = 0;
    private var xp: Int = 0;

    fun assistirConteudo(conteudo: ConteudoEducacional){
        this.xp += conteudo.xp
        if(xp > nextLevelXp){
            xp = xp - nextLevelXp;
            level++
            nextLevelXp = Math.round(nextLevelXp * 1.5F)
        }
        print("$nome assistiu o conteúdo: ${conteudo.titulo}\n")
    }

    override fun toString(): String {
        return "Nome: ${nome}, Nível: ${level}, XP: ${xp}/${nextLevelXp}"
    }
}