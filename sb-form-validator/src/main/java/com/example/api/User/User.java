package com.example.api.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
 
@NotEmpty(message = "Field can't be left empty")
  @Size(min=2, max=20, message = "Has to be in 2-20 chars range")
  private String firstName;
  @NotEmpty
  @Size(min=2, max=20)
  private String lastName;
  @NotEmpty
  @Email
  private String email;
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }	
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}