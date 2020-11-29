package M12Spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class TrabajadorController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hola Mundo!";
	}
}
