package br.com.linkup.util;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Set;

import br.com.linkup.model.team.Task;
import br.com.linkup.model.team.TimeEntriesArray;
import br.com.linkup.model.team.TimeEntry;
import br.com.linkup.service.TeamService;

public class PontoAPI {
	
	private TeamService service;
	private Config config;
	
	
	
	public PontoAPI(Config config) {
		service = new TeamService(config.isUseProxy(), config.getUrl(), config.getToken());
		this.config = config;
	}
	
	public Task getTaskById(Long taskId) throws Exception {
		return service.getTaskById(taskId);
	}

	public Set<LocalDate> getDaysAlreadyRegister() throws Exception {
		TimeEntriesArray entriesArray = service.restriveAllTimeForTask(config.getTaskId());
		return entriesArray.getDaysTimeEntries();
	}

	public void saveTimeEntrie(LocalDate day, String hourStart, String hourEnd) throws IOException {
		LocalTime timeStart = LocalTime.parse(hourStart, DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime timeEnd = LocalTime.parse(hourEnd, DateTimeFormatter.ofPattern("HH:mm"));
		Duration duration = Duration.between(timeStart, timeEnd); 
		Long hours = duration.toHours();
		Long minutes = duration.toMinutes()%60;
		
		TimeEntry timeEntry = new TimeEntry();
		timeEntry.setDate(day.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		timeEntry.setHasStartTime(true);
		timeEntry.setMarkTaskComplete(false);
		timeEntry.setTime(hourStart);
		timeEntry.setHours(hours.intValue());
		timeEntry.setMinutes(minutes.intValue());
		timeEntry.setIsBillable(true);

		service.saveTimeEntryForTask(config.getTaskId(),timeEntry);
	}
	
	
	public void deleteAllTimeEntriesByTask() throws Exception {
		TimeEntriesArray entriesArray = service.restriveAllTimeForTask(config.getTaskId());
		entriesArray.getTimeEntries().forEach( e ->{
			try {
				service.deleteTimeEntryById(Long.parseLong(e.getId()) );
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

	

}
