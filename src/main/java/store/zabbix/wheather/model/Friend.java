package store.zabbix.wheather.model;

import lombok.Data;

@Data
public class Friend {
	
	private String name;
	private String city;
	private String email;

	public Friend(String name, String city, String email) {
		super();
		this.name = name;
		this.city = city;
		this.email = email;
	}

}

