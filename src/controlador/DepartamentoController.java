package controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import formulario.DepartamentoForm;
import formulario.UsuarioForm;
import servicio.DepartamentoService;
import servicio.DepartamentoServiceImpl;

@Controller
public class DepartamentoController {

	private DepartamentoService departamentoService= new DepartamentoServiceImpl();
	  
	 @RequestMapping(value="/agregarDepartamento.html", method = RequestMethod.POST)
	 public ModelAndView guardarComponente(@ModelAttribute("departamentoForm") DepartamentoForm departamento) {
	  System.out.println("Ingreso a departamento guardado");
	  departamentoService.addDepartamento(departamento);
	  System.out.println("Departamento guardado");
	  return new ModelAndView("mostrarDepartamentos" , "listaDepartamentos", departamentoService.getComponente());
	 }
	  
	 @RequestMapping(value="/volverDepartamento.html", method = RequestMethod.GET)
	 public ModelAndView volverDepartamento() {
	  System.out.println("Volvemos a agregar departamento");
	  ModelAndView modelo= new ModelAndView("agregarDepartamento" , "mensaje", "Usuario Correcto");
	  modelo.addObject("usuarioForm", new UsuarioForm("christian","pcgonzal"));
	  modelo.addObject("departamentoForm", new DepartamentoForm());
	  return modelo;
	 }
	 
}
