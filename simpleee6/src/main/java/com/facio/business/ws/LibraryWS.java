package com.facio.business.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface LibraryWS {

	@WebMethod
	@WebResult(name="Codigo")
	public Long createBook(
			@WebParam(name="Title") String title, 
			@WebParam(name="Price") Integer price, 
			@WebParam(name="Author") String author);
}
