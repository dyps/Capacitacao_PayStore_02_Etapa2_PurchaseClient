package br.com.purchaseclient.purchase.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.purchaseclient.purchase.BookDTO;

@FeignClient( value = "bookcliente", url = "http://deucalion.phoebus.local:8082/v1/api/book/")
public interface GetBookService {

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public BookDTO find(@PathVariable("id") Long id);

}