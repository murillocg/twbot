package br.com.linkup.service;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.linkup.model.team.Task;
import br.com.linkup.model.team.TimeEntriesArray;
import br.com.linkup.model.team.TimeEntry;
import br.com.linkup.util.Base64Coder;

public class TeamService {

	private boolean useProxy;
	private String urlTeamwork;
	private String APIKey;
	private ObjectMapper mapper;

	
	public TeamService(boolean useProxy, String url, String APIKey) {
		super();
		this.useProxy = useProxy;
		this.urlTeamwork = url;
		this.APIKey = APIKey;
		this.mapper = new ObjectMapper();
		this.mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		this.mapper.findAndRegisterModules();
//		this.mapper.findModules().stream().forEach(a ->{
//			System.out.println(a.getModuleName());
//		});		
//		try {
//			System.out.println("Precisone qualquer tecla...");
//			System.in.read();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public Task getTaskById(Long taskId) throws Exception {
		String url = urlTeamwork + "/tasks/%s.json";
		return mapper.readValue(doGet(String.format(url, taskId)), Task.class);
	}

	public TimeEntriesArray restriveAllTimeForProject(Long projectId) throws Exception {
		String url = urlTeamwork + "/projects/%s/time_entries.json";
		return mapper.readValue(doGet(String.format(url, projectId)), TimeEntriesArray.class);
	}
	
	public TimeEntriesArray restriveAllTimeForTask(Long taskId) throws Exception {
		String url = urlTeamwork + "/todo_items/%s/time_entries.json";
		return mapper.readValue(doGet(String.format(url, taskId)), TimeEntriesArray.class);
	}
	
	public void deleteTimeEntryById(Long timeEntryId) throws Exception {
		String url = urlTeamwork + "/time_entries/%s.json";
		doDelete(String.format(url, timeEntryId));
	}
	
	public String doGet(String url) throws ClientProtocolException, IOException {
		String userpassword = APIKey + ":" + "";
        String encodedAuthorization = Base64Coder.encodeString( userpassword );
		Request request = Request.Get(url)
				.addHeader("Authorization", "Basic "+ encodedAuthorization);
		if(useProxy)
			request.viaProxy(new HttpHost("proxy", 8080));
			
		return request.execute().returnContent().asString();
	}
	
	public String doPost(String url,  Object json) throws IOException {
		String userpassword = APIKey + ":" + "";
        String encodedAuthorization = Base64Coder.encodeString( userpassword );
		Request request = Request.Post(url)
				.addHeader("Authorization", "Basic "+ encodedAuthorization)
				.bodyString(mapper.writeValueAsString(json), ContentType.APPLICATION_JSON);
		
		if(useProxy)
			request.viaProxy(new HttpHost("proxy", 8080));
			
		return request.execute().returnContent().asString();
	}
	
	public String doDelete(String url) throws IOException {
		String userpassword = APIKey + ":" + "";
        String encodedAuthorization = Base64Coder.encodeString( userpassword );
		Request request = Request.Delete(url)
				.addHeader("Authorization", "Basic "+ encodedAuthorization);
		if(useProxy)
			request.viaProxy(new HttpHost("proxy", 8080));
			
		return request.execute().returnContent().asString();
	}

	public void saveTimeEntryForTask(Long taskId, TimeEntry timeEntry) throws IOException {
		String url = urlTeamwork + "/todo_items/%s/time_entries.json";
		System.out.println(mapper.writeValueAsString(timeEntry));		
		doPost(String.format(url, taskId), timeEntry);
	}
	
	public static void main(String[] args) throws Exception {
		TeamService t = new TeamService(true, "http://projects.linkupconsultoria.com.br/", "twp_wWlSRJ1k3OT8Xtp7sUmK6ybcW9Qz");
		 t.restriveAllTimeForProject(298671L);
	}

}
