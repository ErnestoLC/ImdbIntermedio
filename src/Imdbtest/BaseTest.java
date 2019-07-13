package Imdbtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	
	static WebDriver driver;
	
	//Datos
	static String nombreDePelicula = "Star Wars";
	static String anioDePelicula = "1977";
	static String nombreDeDirector = "George Lucas";
	static String nombreDeEscritor = "George Lucas";
	static String nombreDeActor1 = "Mark Hamill";
	static String nombreDeActor2 = "Harrison Ford";
	static String nombreDeActor3= "Carrie Fisher";
	
	//Home Page objects
	static By logo = By.id("home_img");
	static By listCategories = By.id("quicksearch");
	static By signinButton = By.id("imdb-signin-link");
	static By searchLabel = By.id("navbar-query");
	static By searchButton = By.id("navbar-submit-button");
	
	//Movie search objects
	static By movieSearched = By.xpath("//h1[@class='findHeader' and text()='Results for ']");
	static By movieResult  = By.xpath("//a[text()='La guerra de las galaxias' or text()='"+nombreDePelicula+"' and conten=' ("+anioDePelicula+") ']");
	static By movie  = By.xpath("//a[text()='La guerra de las galaxias' and //td[text()=' ("+anioDePelicula+") ']]");
	
	//Movie page objects
	static By movieyear  = By.id("titleYear");
	static By movieOriginalTitle  = By.xpath("//div[@class='originalTitle']");
	static By movieDirector = By.xpath("//div[@class='credit_summary_item' and h4[text()='Director:'] and a[text()='"+nombreDeDirector+"']]"); 
	static By movieEscritor = By.xpath("//div[@class='credit_summary_item' and h4[text()='Writer:'] and a[text()='"+nombreDeEscritor+"']]");
	static By movieActor1 = By.xpath("//div[@class='credit_summary_item' and h4[text()='Stars:'] and a[text()='"+nombreDeActor1+"']]");
	static By movieActor2 = By.xpath("//div[@class='credit_summary_item' and h4[text()='Stars:'] and a[text()='"+nombreDeActor2+"']]");
	static By movieActor3 = By.xpath("//div[@class='credit_summary_item' and h4[text()='Stars:'] and a[text()='"+nombreDeActor3+"']]");
	static By movieCastingActor1 =  By.xpath("//div[@id='titleCast']//a[contains(text(),'"+nombreDeActor1+"')]");
	static By movieCastingActor2 = By.xpath("//div[@id='titleCast']//a[contains(text(),'"+nombreDeActor2+"')]");
	static By movieCastingActor3 =  By.xpath("//div[@id='titleCast']//a[contains(text(),'"+nombreDeActor3+"')]");
	
	
	protected static void compararInformaciónPelicula() {
		WebElement peliAnio = driver.findElement(movieyear);
		WebElement peliTituloOriginal = driver.findElement(movieOriginalTitle);
		WebElement peliDirector = driver.findElement(movieDirector);
		WebElement peliEscritor = driver.findElement(movieEscritor);
		WebElement peliActor1 = driver.findElement(movieActor1);
		WebElement peliActor2 = driver.findElement(movieActor2);
		WebElement peliActor3 = driver.findElement(movieActor3);
		WebElement pelicastingActor1 = driver.findElement(movieCastingActor1);
		WebElement pelicastingActor2 = driver.findElement(movieCastingActor2);
		WebElement pelicastingActor3 = driver.findElement(movieCastingActor3 );
		
		String textoAnio = peliAnio.getText();
		String textoTituloOriginal = peliTituloOriginal.getText();
		
		if (textoAnio.contains(anioDePelicula)) {
			System.out.println("OK - El año es correcto");
		} else {
			System.out.println("NOK - El año es NO correcto");
		}
		
		if (textoTituloOriginal.contains(nombreDePelicula)) {
			System.out.println("OK - El nombre original de la pelicula es correcto");
		} else {
			System.out.println("NOK - El nombre original de la pelicula NO es correcto");
		}
		
		if (peliDirector.isDisplayed()) {
			System.out.println("OK - El nombre del director es correcto");
		} else {
			System.out.println("NOK - El nombre del director NO es correcto");
		}
		
		if (peliEscritor.isDisplayed()) {
			System.out.println("OK - El nombre del escritor es correcto");
		} else {
			System.out.println("NOK - El nombre del escritor NO es correcto");
		}
		
		if (peliActor1.isDisplayed()) {
			System.out.println("OK - El nombre del Actor es correcto");
		} else {
			System.out.println("NOK - El nombre del Actor NO es correcto");
		}
		if (peliActor2.isDisplayed()) {
			System.out.println("OK - El nombre del Actor es correcto");
		} else {
			System.out.println("NOK - El nombre del Actor NO es correcto");
		}
		if (peliActor3.isDisplayed()) {
			System.out.println("OK - El nombre del Actor es correcto");
		} else {
			System.out.println("NOK - El nombre del Actor NO es correcto");
		}
		if (pelicastingActor1.isDisplayed()) {
			System.out.println("OK - El nombre del Actor es correcto");
		} else {
			System.out.println("NOK - El nombre del Actor NO es correcto");
		}
		if (pelicastingActor2.isDisplayed()) {
			System.out.println("OK - El nombre del Actor es correcto");
		} else {
			System.out.println("NOK - El nombre del Actor NO es correcto");
		}
		if (pelicastingActor3.isDisplayed()) {
			System.out.println("OK - El nombre del Actor es correcto");
		} else {
			System.out.println("NOK - El nombre del Actor NO es correcto");
		}
	}

	protected static void navegarPelicula(String anioPelicula) {
		WebElement peliculaLink = driver.findElement(movie);
		
		peliculaLink.click();
	}

	protected static void capturarInformaciónPelicula(String nombre, String anio) {
		WebElement peliculaBuscada = driver.findElement(movieSearched);
		WebElement datosDePelicucla = driver.findElement(movieResult);
		
		String resultados = peliculaBuscada.getText();
		
		if (resultados.contains(nombre)) {
			System.out.println("OK - Se buscó correctamente la pelicula");
		}else {
			System.out.println("NOK - No se encontró la pelicula");
		}
		
		if (datosDePelicucla.isDisplayed()) {
			System.out.println("OK - Se buscó correctamente la pelicula");
		} else {
			System.out.println("NOK - No se encontró la pelicula");
		}
	}

	protected static void buscarPelicula(String nombrePelicula) {
		WebElement campoBuscar = driver.findElement(searchLabel);
		WebElement botonBuscar = driver.findElement(searchButton);
		
		campoBuscar.clear();
		campoBuscar.sendKeys(nombrePelicula);
		botonBuscar.click();		
	}

	protected static void navegarAImdb(String url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	protected static void cerrarPrueba() {
		driver.quit();
		
	}

}
