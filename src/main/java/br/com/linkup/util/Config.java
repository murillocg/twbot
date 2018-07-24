package br.com.linkup.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Scanner;

public class Config {

	private String login;
	private String senha;
	private String projectId;
	private String token;
	private String dhManhaInicio;
	private String dhManhaFinal;
	private String dhTardeInicio;
	private String dhTardeFinal;
	private String pathConfig = "config" + File.separator + "config.ini";
	private String url;
	private Long taskId;
	
	private boolean mesTodo;
	private boolean deleteAllFirst;
	private boolean useProxy;
	private LocalDate date;

	public Config() {
	}

	public void validarEntrada() throws IOException {
		readInitConfig();
	}

	public void salvarConfig() throws IOException {
		File file = new File("config");
		file.mkdirs();
		try (FileOutputStream output = new FileOutputStream(pathConfig)) {
			Properties prop = new Properties();
			prop.setProperty("login", login);
			prop.setProperty("senha", senha);
			prop.setProperty("taskId", String.valueOf(taskId));
			prop.setProperty("projectId", projectId);
			prop.setProperty("token", token);
			prop.setProperty("url", url);
			prop.setProperty("mesTodo", String.valueOf(mesTodo));
			prop.setProperty("deleteAllFirst", String.valueOf(deleteAllFirst));
			prop.setProperty("useProxy", String.valueOf(useProxy));
			prop.store(output, null);
		}
	}

	private boolean readInitConfig() throws IOException {
		File dir = new File("config");
		if (!dir.exists()) {
			return false;
		}

		File fileConfig = new File(pathConfig);
		if (!fileConfig.exists()) {
			return false;
		}
		try (FileInputStream input = new FileInputStream(pathConfig)) {
			Properties prop = new Properties();
			prop.load(input);
			if (prop.keySet().isEmpty()) {
				return false;
			}

			setLogin(prop.getProperty("login"));
			setSenha(prop.getProperty("senha"));
			setTaskId(Long.parseLong(prop.getProperty("taskId")));
			setProjectId(prop.getProperty("projectId"));
			setToken(prop.getProperty("token"));
			setUrl(prop.getProperty("url"));
			setMesTodo(Boolean.parseBoolean(prop.getProperty("mesTodo")));
			setDeleteAllFirst(Boolean.parseBoolean(prop.getProperty("deleteAllFirst")));
			setUseProxy(Boolean.parseBoolean(prop.getProperty("useProxy")));
			setDate(prop.getProperty("refDate"));
			setDhManhaInicio(prop.getProperty("dhManhaInicio"));
			setDhManhaFinal(prop.getProperty("dhManhaFinal"));
			setDhTardeInicio(prop.getProperty("dhTardeInicio"));
			setDhTardeFinal(prop.getProperty("dhTardeFinal"));
			return true;
		}
	}

	public boolean isMesTodo() {
		return mesTodo;
	}

	public void setMesTodo(boolean mesTodo) {
		this.mesTodo = mesTodo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPathConfig() {
		return pathConfig;
	}

	public void setPathConfig(String pathConfig) {
		this.pathConfig = pathConfig;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public boolean isDeleteAllFirst() {
		return deleteAllFirst;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setDate(String dateStr) {
		if(dateStr == null || dateStr.isEmpty())
			return;
		this.date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public void setDeleteAllFirst(boolean deleteAllFirst) {
		this.deleteAllFirst = deleteAllFirst;
	}

	public boolean isUseProxy() {
		return useProxy;
	}

	public void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

	public String getDhManhaInicio() {
		return dhManhaInicio;
	}

	public void setDhManhaInicio(String dhManhaInicio) {
		this.dhManhaInicio = dhManhaInicio;
	}

	public String getDhManhaFinal() {
		return dhManhaFinal;
	}

	public void setDhManhaFinal(String dhManhaFinal) {
		this.dhManhaFinal = dhManhaFinal;
	}

	public String getDhTardeInicio() {
		return dhTardeInicio;
	}

	public void setDhTardeInicio(String dhTardeInicio) {
		this.dhTardeInicio = dhTardeInicio;
	}

	public String getDhTardeFinal() {
		return dhTardeFinal;
	}

	public void setDhTardeFinal(String dhTardeFinal) {
		this.dhTardeFinal = dhTardeFinal;
	}

}
