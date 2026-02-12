package com.training.java.dto;

import com.training.java.ResponseStatus;

public class ResponseDto<T> {
		// ResponseDto holds the response from the api


		private ResponseStatus responseStatus;
		private String message;
		private T data;


		public ResponseStatus getResponseStatus() {
				return responseStatus;
		}

		public void setResponseStatus(ResponseStatus responseStatus) {
				this.responseStatus = responseStatus;
		}

		public String getMessage() {
				return message;
		}

		public void setMessage(String message) {
				this.message = message;
		}

		public T getData() {
				return data;
		}

		public void setData(T data) {
				this.data = data;
		}
}
