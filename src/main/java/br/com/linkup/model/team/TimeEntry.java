package br.com.linkup.model.team;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "date", "has-start-time", "time", "minutes", "hours", "description", "markTaskComplete", "tags",
		"isBillable" })
@JsonRootName(value = "time-entry")
public class TimeEntry {

	@JsonProperty("date")
	public String date;
	@JsonProperty("has-start-time")
	public Boolean hasStartTime;
	@JsonProperty("time")
	public String time;
	@JsonProperty("minutes")
	public Integer minutes;
	@JsonProperty("hours")
	public Integer hours;
	@JsonProperty("description")
	public String description;
	@JsonProperty("markTaskComplete")
	public Boolean markTaskComplete;
	@JsonProperty("tags")
	public String tags;
	@JsonProperty("isBillable")
	public Boolean isBillable;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getHasStartTime() {
		return hasStartTime;
	}

	public void setHasStartTime(Boolean hasStartTime) {
		this.hasStartTime = hasStartTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getMarkTaskComplete() {
		return markTaskComplete;
	}

	public void setMarkTaskComplete(Boolean markTaskComplete) {
		this.markTaskComplete = markTaskComplete;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Boolean getIsBillable() {
		return isBillable;
	}

	public void setIsBillable(Boolean isBillable) {
		this.isBillable = isBillable;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	
	
}