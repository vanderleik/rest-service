package restservice;

/**
 * <h1>Cria a classe Greeting</h1>
 * 
 * <p> Cria uma classe com construtor que recebe id e um conteúdo de texto associado
 * a esse id.</p>
 * @author vande
 *
 */
public class Greeting {
	
	private final long id;
	private final String content;
	/**
	 * @param id O campo "id" é um identificador único.
	 * @param content Representa o conteúdo textual a ser exibido na tela.
	 */
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
	/**
	 * @return Retorna o id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return Retorna o conteúdo
	 */
	public String getContent() {
		return content;
	}
}
