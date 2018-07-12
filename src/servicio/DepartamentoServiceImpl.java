package servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import formulario.DepartamentoForm;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	private static List<DepartamentoForm> listaDepartamentos=new ArrayList<DepartamentoForm>();
	
	@Override
	public void addDepartamento(DepartamentoForm departamento) {
		listaDepartamentos.add(departamento);	
	}

	@Override
	public List<DepartamentoForm> getComponente() {
		return listaDepartamentos;
	}

}
