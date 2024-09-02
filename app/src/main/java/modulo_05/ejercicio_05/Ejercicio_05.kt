package modulo_05.ejercicio_05

class Persona(val nombre: String,
              val edad: Int,
              val trabajo: String?="No indica",
              val referencia: Persona?){

    override fun toString():String{
        val cadena = "Nombre: $nombre  " +
                "Edad: $edad   " +
                "Trabajo: ${trabajo?:"No indica"}  " +
                "Referencia: ${referencia?.toString() ?:"Sin referencia"}  "
        return cadena
    }
    fun mostrardatos(){
        println(this).toString()
    }
}

fun mostrarLista(lista:MutableList<Persona>){
    for(persona in lista){
        persona.mostrardatos()
    }
}
class ListaUsers(){
    val listaUsers:MutableList<Persona> = mutableListOf<Persona>()

    fun  agregarUser(persona :Persona){
        listaUsers.add(persona)
    }
    fun eliminarUser(persona: Persona){
        listaUsers.remove(persona)
    }
}
fun filtrarPorEdad(listaUsers: MutableList<Persona>, edad: Int): MutableList<Persona> {
    return listaUsers.filter { it.edad >= edad } as MutableList<Persona>
}
fun main(){
    val juanito = Persona(nombre = "Juanito", 12, trabajo = "Estudiante", referencia = null)
    val pedrito = Persona("Pedrito", 23, null, juanito)
    val chavela = Persona("Chavela", 54, "Profesora", pedrito)
    val pepe = Persona("Pepe", 66, null,juanito)
    val pancho = Persona("Pancho", 32, "Electricista", chavela)
    val listaUsers = ListaUsers()
    listaUsers.agregarUser(juanito)
    listaUsers.agregarUser(pedrito)
    listaUsers.agregarUser(chavela)
    listaUsers.agregarUser(pepe)
    listaUsers.agregarUser(pancho)
  //  mostrarLista(listaUsers.listaUsers)
    listaUsers.eliminarUser(pedrito)
    mostrarLista(filtrarPorEdad(listaUsers.listaUsers, 30))
}
