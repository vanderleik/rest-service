package restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * <h1>Controller criado para tratar as requisi��es HTTP</h1>
 * 
 * <p>Os componentes s�o identificados pela anota��o @RestController, e a classe GreetingController 
 * � respons�vel por tratar a solicita��o "GET", quando acessada a p�gina "/greeting", 
 * retornando uma nova inst�ncia de Greeting.</p>
 * @author vande
 *
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * <h2>M�todo greeting</h2>
	 * 
	 * <p> Usamos a anota��o "@GetMapping" para assegurar que a requisi��o HTTP GET, enviada para
	 * a p�gina "/greeting" � mapeada pelo m�todo "greeting()".</p>
	 * <p> A anota��o "@RequestParam" liga o valor da query string "name" no par�metro "name"
	 * do m�todo "greeting()".</p>
	 * <p> Se o par�metro "name" n�o for informado na requisi��o, � utilizado o valor default setado 
	 * em "defaultValue".</p>
	 * @param name
	 * @return Objeto Greeting com id gerado a partir do "counter.incrementAdGet()" e conte�do definido
	 * 				  em "content". 
	 */
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
}
