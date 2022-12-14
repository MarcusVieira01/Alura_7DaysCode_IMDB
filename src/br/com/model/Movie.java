//Declaração de pacote
package br.com.model;

//Importação de classes externas
import java.util.ArrayList;
import java.util.List;

/**
 * @apiNote Declaração de classe concreta que define um objeto Movie 
 * @implNote Implementação de Content para generalização
 */
//
public class Movie implements Content{
    //Declaração de atributos
    private String title;
    private String year;
    private String image;
    private String rating;

    /**
     * Declaração de construtor
     * @param title
     * @param rating
     * @param year
     * @param image
     */
    public Movie(String title,  String rating, String year, String image){
        this.title = title;
        this.rating = rating;
        this.year = year;
        this.image = image;
    }

    //Declaração de métodos getter sobreescritos, advindos da interface Content
    @Override
    public String getTitle() {
        return this.title;
    }
    @Override
    public String getRating() {
        return this.rating;
    }
    @Override
    public String getYear() {
        return this.year;
    }
    @Override
    public String getImage() {
        return this.image;
    }

    /**
     * Método que retornará uma lista de filmes, após parseamento de um JSON via classe ParseJasonIMDB
     * @param jsonImdb Objeto da classe ParseJsonIMDB
     * @return Lista de objetos Movie
     */
    public static List<Movie> gerarListaFilmes(ParseJsonIMDB jsonImdb){
        //Instanciação de novo objeto via construtor ArrayList<>() que armazenará cada objeto Movie
        List<Movie> listaFilmes = new ArrayList<>();

        //Declaração de variáveis e atribuição dos valores de retorno dos métodos evocados, separando nas listas pertinentes cada elemento do filme.  
        List<String> title = jsonImdb.parseTitle();
        List<String> year = jsonImdb.parseYear();
        List<String> rating = jsonImdb.parseRating();
        List<String> image = jsonImdb.parseElemento("image");

        //Loop for que fará a adição de elemento no objeto de referência atribuída à variável filmes. Cada elemento será um objeto instanciado via construtor Movie(args)
        for(int i = 0; i < title.size(); i++){
            listaFilmes.add(new Movie(title.get(i), rating.get(i), year.get(i), image.get(i)));
        }
        
        //Retorno da lista contendo objetos
        return listaFilmes;
    }
    
    /**
     * Sobreescrita do método to string
     * @return Cadeia de caracteres pré definidos e concatenados com os atributos do objeto
     */
    @Override
    public String toString() {
        return "Movie:\n" 
        + "title: " + title 
        + "\nrating: " + rating
        + "\nyear: " + year 
        + "\nimage: " + image;
    }
}
