package br.com.purchaseclient.purchase.service;

import java.util.List;

import br.com.purchaseclient.purchase.PurchaseDTO;

@FunctionalInterface
public interface ListPurchaseService {

	List<PurchaseDTO> findAll();

}
