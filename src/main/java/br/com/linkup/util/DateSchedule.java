package br.com.linkup.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.linkup.model.Events;
import br.com.linkup.model.team.Task;

public class DateSchedule {

	private String pathFileDate = "config" + File.separator + "dates.ini";
	private Set<LocalDate> listDaysSaved = new LinkedHashSet<>();
	private Set<LocalDate> listDayToProcess;
	private Set<LocalDate> listHolidays = new LinkedHashSet<>();
	private Task task;
	private String pathHoliday = "config" + File.separator + "calendar_%s.xml";
	private Config config;

	private String urlCalendar = "http://www.calendario.com.br/api/api_feriados.php?ano=%s&estado=RS&cidade=SAO_LEOPOLDO&token=am92YW5pLm1AaG90bWFpbC5jb20maGFzaD0yMzM4OTc0MDk=";
	private boolean mesTodo;
	
	
	public DateSchedule(Task task,  Set<LocalDate> daysAlreadRegistered, Config config) {
		this.task = task;
		this.mesTodo = config.isMesTodo();
		this.listDaysSaved = daysAlreadRegistered;
		this.config = config;
	}

	public void getHolidaysList(LocalDate refDate) throws IOException {
		int year = refDate.getYear();
		String xmlReturn = null;
		if (Files.exists(Paths.get(String.format(pathHoliday, year)))) {
			try (Stream<String> stream = Files.lines(Paths.get(String.format(pathHoliday, year)))) {

				StringBuilder sb = new StringBuilder();
				stream.forEach(a -> {
					sb.append(a);
				});

				xmlReturn = sb.toString();
			}
		} else {
			xmlReturn = getHolidaysFromWebService(year);
			saveHolidaysFile(xmlReturn, year);
		}

		XmlMapper xmlMapper = new XmlMapper();
		Events events = xmlMapper.readValue(xmlReturn, Events.class);
		fillHolidayList(events, refDate.getMonth());
	}

	private String getHolidaysFromWebService(int year) throws ClientProtocolException, IOException {
		Request request = Request.Get(String.format(urlCalendar, year));
		
		if (config.isUseProxy()) 
			request.viaProxy(new HttpHost("proxy", 8080));
		
		return request.execute().returnContent().asString();
	}

	private void fillHolidayList(Events events, Month mesAtual) {
		listHolidays = events.getEvent().stream().filter( e -> {
			return e.isRelevantHoliday();
		}).map(a -> {
			return LocalDate.parse(a.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}).filter(a -> {
			return mesAtual.getValue() == a.getMonthValue()		;
		}).collect(Collectors.toSet());

		System.out.println("Holidays in " + mesAtual.name() + ":");
		listHolidays.forEach(a -> {
			System.out.println(a);
		});
	}

	public Set<LocalDate> readList(LocalDate refDate) throws IOException {
		listDayToProcess = new LinkedHashSet<>();
		LocalDate date = refDate;
		for (int i = getLastDay(); i <= getLimitDay(date); i++) {
			refDate = refDate.withDayOfMonth(i);
			if (!refDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) && !refDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
				listDayToProcess.add(refDate);
			}
		}

		getHolidaysList(refDate);

		listDayToProcess.removeAll(listHolidays);

		return listDayToProcess;
	}
	
	private int getLimitDay(LocalDate refDate) {		
		if(mesTodo) {
			return refDate.lengthOfMonth();
		}
		else {
			return config.getDate() != null ? config.getDate().getDayOfMonth() : 
				LocalDate.now().getDayOfMonth();
		}
	}

	private void readFromFile() throws Exception {
		if (Files.exists(Paths.get(pathFileDate))) {
			try (Stream<String> stream = Files.lines(Paths.get(pathFileDate))) {
				int mesAtual = LocalDate.now().getMonthValue();
				stream.forEach(a -> {
					LocalDate day = LocalDate.parse(a);
					if (day.getMonthValue() == mesAtual)
						listDaysSaved.add(day);
				});
			}
		}
	}

	public void saveList() throws IOException {

		Set<LocalDate> listAllProcess = new LinkedHashSet<>();
		listAllProcess.addAll(listDaysSaved);
		listAllProcess.addAll(listDayToProcess);

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(pathFileDate))) {
			for (LocalDate localDate : listAllProcess) {
				writer.append(localDate.format(DateTimeFormatter.ISO_DATE) + "\r\n");
			}
		}
	}

	public void saveHolidaysFile(String xmlContent, int year) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(String.format(pathHoliday, year)))) {
			writer.write(xmlContent);
		}
	}

	public int getLastDay() {
		return listDaysSaved == null || listDaysSaved.isEmpty() ? 1 : Collections.max(listDaysSaved).getDayOfMonth() + 1;
	}

	public Set<LocalDate> getListDaysSaved() {
		return listDaysSaved;
	}

	public void setListDaysSaved(Set<LocalDate> listDaysSaved) {
		this.listDaysSaved = listDaysSaved;
	}
	
	

}
