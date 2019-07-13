package Imdbtest;

public class CompareMovies extends BaseTest{

	public static void main(String[] args) {
		navegarAImdb("https://www.imdb.com/");
		buscarPelicula(nombreDePelicula);
		capturarInformaciónPelicula(nombreDePelicula,anioDePelicula);
		navegarPelicula(anioDePelicula);
		compararInformaciónPelicula();
		cerrarPrueba();
	}

	

	

}
