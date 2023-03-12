package com.pool.exception;

public class UserResponse {
private String response;

public UserResponse(String response) {
	this.response = response;
}

public String getResponse() {
	return response;
}

public void setResponse(String response) {
	this.response = response;
}

@Override
public String toString() {
	return "UserResponse [response=" + response + "]";
}

}
