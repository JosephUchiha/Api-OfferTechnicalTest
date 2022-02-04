package com.atos.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank; 

import com.atos.api.model.User;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	 	@NotBlank(message = "User attribute is required")
	    @Column(name="user_name")
	    private String userName;

	 	//@NotBlank(message = "User attribute is required")
	    @Column(name="birth_date")
	    private LocalDate birthDate;

	 	@NotBlank(message = "User attribute is required")
	    @Column(name="country")
	    private String country;

	    @Column(name="phone_number")
		private String phoneNumber;
		
	    @Column(name="gender")
		private Gender gender;

		public enum Gender {
			MALE, FEMALE;
		}
		
		public User() {
		}
		
		public User(String userName, LocalDate birthDate, String country) {
			this.userName = userName;
			this.birthDate = birthDate;
			this.country = country;
		}
		
		public User(String userName, LocalDate birthDate, String country, String phone, Gender gender) {
			this(userName, birthDate, country);
			this.phoneNumber=phone;
			this.gender=gender;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public LocalDate getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
		    int result = 1;
		    result = prime * result + userName.hashCode();
		    result = prime * result + birthDate.hashCode();
		    result = prime * result + country.hashCode();
		    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		    result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		    return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			User user = (User) obj;
			if(obj == null) return false;
			
			if(!this.userName.equals(user.userName)) return false;
			if(!this.birthDate.equals(user.birthDate)) return false;
			if(!this.country.equals(user.country)) return false;
			
			if(this.phoneNumber!=null) {
				if(!this.phoneNumber.equals(user.phoneNumber))return false;
			}
			
			if(this.gender!=null) {
				if(!this.gender.equals(user.gender)) return false;
			}

			return true;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("userName=");
			sb.append(userName);
			sb.append(", birthDate=");
			sb.append(birthDate);
			sb.append(", country=");
			sb.append(country);
			if(phoneNumber!=null) {
				sb.append(", phone=");
				sb.append(phoneNumber);
			}
			if(gender!=null) {
				sb.append(", gender=");
				sb.append(gender);
			}
			
			return sb.toString();
		}
}
