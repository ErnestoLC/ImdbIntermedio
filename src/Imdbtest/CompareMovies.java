package Imdbtest;

public class CompareMovies extends BaseTest{

	public static void main(String[] args) {
		navegarAImdb("https://www.imdb.com/");
		buscarPelicula(nombreDePelicula);
		capturarInformaci�nPelicula(nombreDePelicula,anioDePelicula);
		navegarPelicula(anioDePelicula);
		compararInformaci�nPelicula();
		cerrarPrueba();
	}

	

	

}
