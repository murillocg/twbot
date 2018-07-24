package br.com.linkup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import br.com.linkup.model.team.Task;
import br.com.linkup.util.Config;
import br.com.linkup.util.DateSchedule;
import br.com.linkup.util.PontoAPI;

public class Main {

	public static void main(String[] args) throws Exception {	
		Config config = new Config();		
		config.validarEntrada();
		
		PontoAPI ponto = new PontoAPI(config);
		
		if (config.isDeleteAllFirst())
			ponto.deleteAllTimeEntriesByTask();
		
		Task task = ponto.getTaskById(config.getTaskId());
		
		DateSchedule dateSchedule = new DateSchedule(task, ponto.getDaysAlreadyRegister(), config);
		
		LocalDate refDate = config.getDate() != null ? config.getDate() : 
				LocalDate.parse(task.getTodoItem().getStartDate(), DateTimeFormatter.ofPattern("yyyyMMdd"));		
		
		Set<LocalDate> days = dateSchedule.readList(refDate);		
		for (LocalDate day : days) {				
			ponto.saveTimeEntrie(day, config.getDhManhaInicio(), config.getDhManhaFinal());
			ponto.saveTimeEntrie(day, config.getDhTardeInicio(), config.getDhTardeFinal());
		}
		
	}
}
