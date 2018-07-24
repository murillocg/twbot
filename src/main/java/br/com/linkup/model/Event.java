package br.com.linkup.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Event {

	public static final int FEDERAL = 1;
	public static final int ESTADUAL = 2;
	public static final int MUNICIPAL = 3;

	@JacksonXmlProperty(namespace = "date")
	private String date;

	@JacksonXmlProperty(namespace = "name")
	private String name;

	@JacksonXmlProperty(namespace = "description")
	private String description;

	@JacksonXmlProperty(namespace = "type")
	private String type;

	@JacksonXmlProperty(namespace = "type_code")
	private Integer type_code;

	@JacksonXmlProperty(namespace = "link")
	private String link;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String date, String name, String description, String type, Integer type_code, String link) {
		super();
		this.date = date;
		this.name = name;
		this.description = description;
		this.type = type;
		this.type_code = type_code;
		this.link = link;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getType_code() {
		return type_code;
	}

	public void setType_code(Integer type_code) {
		this.type_code = type_code;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isRelevantHoliday() {
		return type_code != null && (type_code == MUNICIPAL || type_code == ESTADUAL || type_code == FEDERAL);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
