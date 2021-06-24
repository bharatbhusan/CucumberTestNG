package model;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Data {

private Integer id;
private String email;
private String first_name;
private String last_name;
private String avatar;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getfirst_name() {
return first_name;
}

public void setfirst_name(String first_name) {
this.first_name = first_name;
}

public String getlast_name() {
return last_name;
}

public void setlast_name(String last_name) {
this.last_name = last_name;
}

public String toString()
{
	return this.getfirst_name()+"-"+this.getlast_name();
}

public String getAvatar() {
return avatar;
}

public void setAvatar(String avatar) {
this.avatar = avatar;
}

}