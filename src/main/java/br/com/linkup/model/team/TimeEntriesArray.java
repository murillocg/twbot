package br.com.linkup.model.team;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeEntriesArray {
	
	@JsonProperty("time-entries")
	private List<TimeEntrie> timeEntries;

	public List<TimeEntrie> getTimeEntries() {
		return timeEntries;
	}

	public void setTimeEntries(List<TimeEntrie> timeEntries) {
		this.timeEntries = timeEntries;
	}

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
    
    public Set<LocalDate> getDaysTimeEntries(){
    	return getTimeEntries().stream().map( t -> t.getDate().toLocalDate()).collect(Collectors.toSet());    	
    }
	
}
