/**
  * Created by hernanBeiza on 6/20/17.
  */
object MainObject {

  def main(args: Array[String]): Unit ={
    println("MainObject: main();");
    //println(args);

    var soyVariable = "puedo cambiar";
    println(soyVariable);
    soyVariable = "Cambié";
    println(soyVariable);

    val soyValor = "Quiero cambiar";
    println(soyValor);

    var nombre = "Hernán Beiza";
    println(s"Mi nombre es $nombre");

    val lugares = List("Primero", "Segundo", "Tercero", "Cuarto");


    var clase = new ScalaClass("HB");
    //println(clase.presentar());

    var persona = new PersonaClass("Steve");
    //persona.saludar();
    //println(persona.nombre);

    //Tupla
    val resultado = (true, "Hola Hernán")
    //println(resultado._1);
    //println(resultado._2);

    val(result, mensaje) = resultado;

    println(result);
    println(mensaje);

    //Ciclos
    for (i <- 1 to 10) println(s"numero $i");

    // Ciclo y lista
    // Se instancian los objetos de tipo UsuarioClass
    val usuario = new UsuarioClass(1,"HB");
    var segundo = new UsuarioClass(2, "Steve");
    var tercero = new UsuarioClass(3, "Ubaldo");
    // Lista. Se meten en la lista
    val usuarios = List(usuario,segundo,tercero);
    // Se recorre la lista. Sirve para ver que tiene la lista
    for (user <- usuarios) println(user.nombre)

    // Se filtra la lista según el nombre. Solo se muestran los objetos que tengan nombre diferente a Ubaldo xD
    for (user <- usuarios
         if !user.nombre.contains("Ubaldo")
    ) println(user.nombre)

    //Por ejemplo, guardar todos los usuarios que no se llamen Ubaldo en una nueva lista
    val estudiantes = for(user <- usuarios
      if !user.nombre.contains("Ubaldo")
    ) yield user

    println("Estudiantes");
    for (user <- estudiantes) println(user.nombre)

    //Filtrar una lista y asignarla a otra lista
    val filteredUsers = for {
      user <- usuarios
      if !user.nombre.contains("SinID")
      //if !breed.startsWith("Yorkshire")
    } yield user

    println(filteredUsers.length);

    // Pattern Matching
    val dias = List(1,2,3,4,5,6,7,8)

    for (dia <- dias) {
      dia match {
        case 1 => println("Comienza el mes")
        case 4 => println("Cumpleaños de HB")
        case 5 => println("Pagan")
        case _ => println("Hay que trabajar")
      }
    }
    // Pattern Matchin con los tipos de datos ¡!
    val tonterasList = List(23, "Hello", 8.5, 'q')
    for (tontera <- tonterasList) {
      tontera match {
        case i: Int => println("got an Integer: " + i)
        case s: String => println("got a String: " + s)
        case f: Double => println("got a Double: " + f)
        case other => println("got something else: " + other)
      }
    }

    // El Underscore "_" es solo para expresiones lambda
    val variosLambda = List(1,2,3);
    variosLambda.map(_ * 2);
    //El elemento mayor de la lista
    //variosLambda.max
    //El total de elementos
    //variosLambda.size

    //Funciones
    val miFuncion = (param : Int) => { param * 2 }
    //No se necesita el _
    variosLambda.map(miFuncion);

    /*
    // Comenzando con la interacción
    println("Ingresa que deseas hacer");
    println("1.- Crear un usuario");
    println("2.- Listar los usuarios");
    println("3.- Editar un usuario");
    println("4.- Salir");
    var input:String = "";
    while(input != "4")
      input = readLine();
    */

    }
}
