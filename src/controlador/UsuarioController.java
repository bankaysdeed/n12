package controlador;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import formulario.DepartamentoForm;
import formulario.UsuarioForm;

public class UsuarioController {
	
	
    private static UsuarioForm usuarioForm = new UsuarioForm("christian","pcgonzal");
     
    @RequestMapping(value = "/inicializarLogin.html", method = RequestMethod.GET)
    public ModelAndView inicializarUsuario() {      
     return new ModelAndView("login" , "usuarioForm", new UsuarioForm());
    }
     
    @RequestMapping(value = "/verificarLogin.html", method = RequestMethod.POST)
    public ModelAndView verificarUsuario(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm) {
    	
     if("".equals(usuarioForm.getNombre()) && "".equals(usuarioForm.getClave())){
      return new ModelAndView("login" , "mensaje", "Debe de llenar los campos de Usuario y Clave");
     }
     else if(usuarioForm.getNombre().equals(UsuarioController.usuarioForm.getNombre()) 
    		 && usuarioForm.getClave().equals(UsuarioController.usuarioForm.getClave())){
    	 
      System.out.println("Se coloco al usuario y clave correctamente y va a la pagina de agregarDepartamento");
      ModelAndView modelo= new ModelAndView("agregarDepartamento" , "mensaje", "Usuario Correcto");
      modelo.addObject("departamentoForm", new DepartamentoForm());
;
      return modelo;
     }
     else{
      System.out.println("Se coloco al usuario y clave incorrectamente y regresamos a la pagina de login con el mensaje de Usuario Incorrecto");
      return new ModelAndView("login" , "mensaje", "Usuario Incorrecto");
     }
    }
}


