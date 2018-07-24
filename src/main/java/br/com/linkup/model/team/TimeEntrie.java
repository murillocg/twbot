package br.com.linkup.model.team;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "project-id",
    "minutes",
    "isbillable",
    "person-first-name",
    "todo-list-name",
    "description",
    "todo-item-name",
    "todo-list-id",
    "tags",
    "company-id",
    "person-id",
    "project-status",
    "project-name",
    "company-name",
    "id",
    "date",
    "todo-item-id",
    "invoiceNo",
    "person-last-name",
    "has-start-time",
    "hours"
})
public class TimeEntrie {

    @JsonProperty("project-id")
    public String projectId;
    @JsonProperty("minutes")
    public String minutes;
    @JsonProperty("isbillable")
    public String isbillable;
    @JsonProperty("person-first-name")
    public String personFirstName;
    @JsonProperty("todo-list-name")
    public String todoListName;
    @JsonProperty("description")
    public String description;
    @JsonProperty("todo-item-name")
    public String todoItemName;
    @JsonProperty("todo-list-id")
    public String todoListId;
    @JsonProperty("tags")
    public List<Tag> tags = null;
    @JsonProperty("company-id")
    public String companyId;
    @JsonProperty("person-id")
    public String personId;
    @JsonProperty("project-status")
    public String projectStatus;
    @JsonProperty("project-name")
    public String projectName;
    @JsonProperty("company-name")
    public String companyName;
    @JsonProperty("id")
    public String id;
    @JsonProperty("date")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    public LocalDateTime date;
    @JsonProperty("todo-item-id")
    public String todoItemId;
    @JsonProperty("invoiceNo")
    public String invoiceNo;
    @JsonProperty("person-last-name")
    public String personLastName;
    @JsonProperty("has-start-time")
    public String hasStartTime;
    @JsonProperty("hours")
    public String hours;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public String getIsbillable() {
		return isbillable;
	}

	public void setIsbillable(String isbillable) {
		this.isbillable = isbillable;
	}

	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getTodoListName() {
		return todoListName;
	}

	public void setTodoListName(String todoListName) {
		this.todoListName = todoListName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTodoItemName() {
		return todoItemName;
	}

	public void setTodoItemName(String todoItemName) {
		this.todoItemName = todoItemName;
	}

	public String getTodoListId() {
		return todoListId;
	}

	public void setTodoListId(String todoListId) {
		this.todoListId = todoListId;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getTodoItemId() {
		return todoItemId;
	}

	public void setTodoItemId(String todoItemId) {
		this.todoItemId = todoItemId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	public String getHasStartTime() {
		return hasStartTime;
	}

	public void setHasStartTime(String hasStartTime) {
		this.hasStartTime = hasStartTime;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
    

}
