package restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * <h1>Controller criado para tratar as requisições HTTP</h1>
 * 
 * <p>Os componentes são identificados pela anotação @RestController, e a classe GreetingController 
 * é responsável por tratar a solicitação "GET", quando acessada a página "/greeting", 
 * retornando uma nova instância de Greeting.</p>
 * @author vande
 *
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * <h2>Método greeting</h2>
	 * 
	 * <p> Usamos a anotação "@GetMapping" para assegurar que a requisição HTTP GET, enviada para
	 * a página "/greeting" é mapeada pelo método "greeting()".</p>
	 * <p> A anotação "@RequestParam" liga o valor da query string "name" no parâmetro "name"
	 * do método "greeting()".</p>
	 * <p> Se o parâmetro "name" não for informado na requisição, é utilizado o valor default setado 
	 * em "defaultValue".</p>
	 * @param name
	 * @return Objeto Greeting com id gerado a partir do "counter.incrementAdGet()" e conteúdo definido
	 * 				  em "content". 
	 */
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
}
