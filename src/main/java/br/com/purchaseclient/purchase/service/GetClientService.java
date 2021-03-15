package br.com.purchaseclient.purchase.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.purchaseclient.purchase.ClientDTO;



@FeignClient( value = "clientcliente", url = "http://deucalion.phoebus.local:8081/v1/api/client/")
public interface GetClientService {

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ClientDTO find(@PathVariable("id") Long id);

}
