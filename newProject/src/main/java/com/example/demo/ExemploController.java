package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/exemplo")
public class ExemploController {
	@GetMapping("/pagina")
	public String paginaExemplo() {
		return "teste";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/user/{id}")
	@ResponseBody
	public String getUser(@PathVariable int id) {
		return "User Id: " + (id+1);
	}
	
	@PostMapping("/userJ/{id}")
	@ResponseBody
	public ResponseEntity<User> getUserJ(@PathVariable int id){
		User u=new User();
		u.setNome("Joao");
		return new ResponseEntity(u,HttpStatus.OK);
	}
	
	@PostMapping("/userK/")
	@ResponseBody
	public ResponseEntity<User> getUserK(@RequestBody User user){
		User u = new User();
		u.setNome(user.getNome()+ "Sobrenome");
		return new ResponseEntity(u, HttpStatus.OK);
	}
	
	@PostMapping("/calcular")
	@ResponseBody
	public ResponseEntity<Dados> calcular(@RequestBody Dados dados){
		calculadora calc = new calculadora();
		calc.setDados(dados);
		calc.calcular();
		Dados dadosX=calc.getDados();
		return new ResponseEntity(dados, HttpStatus.OK);
	}
	
	@GetMapping("/relatorio")
	@ResponseBody
	public ResponseEntity<Relatorio> getUsers(){
		Relatorio relatorio = new Relatorio();
		User u1 = new User();
		u1.setNome("Joao");
		User u2 = new User();
		u2.setNome("Maria");
		relatorio.addUser(u1);
		relatorio.addUser(u2);
		relatorio.setTitulo("Relatorio de Usuarios");
		relatorio.setData("08/01/2025");
		
		return new ResponseEntity(relatorio, HttpStatus.OK);
	}
}
