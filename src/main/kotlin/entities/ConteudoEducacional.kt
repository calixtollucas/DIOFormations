package entities

data class ConteudoEducacional(
    val titulo: String,
    val duracao: Int = 60,
    val conhecimentos: List<String>,
    val xp: Int
)