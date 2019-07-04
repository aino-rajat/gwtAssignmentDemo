package com.ainosoft.loginGWT.client.cellTable;


	public class Employee {
	    private final String name;
	    private final String surname;
	    private final String city;
	    private final String country;

	    public Employee(String name, String surname,String city,String country) {
	      this.name = name;
	      this.surname = surname;
	      this.city=city;
	      this.country=country;
	    }

		public String getName() {
			return name;
		}

		public String getSurname() {
			return surname;
		}

		public String getCity() {
			return city;
		}

		public String getCountry() {
			return country;
		}
	  }

