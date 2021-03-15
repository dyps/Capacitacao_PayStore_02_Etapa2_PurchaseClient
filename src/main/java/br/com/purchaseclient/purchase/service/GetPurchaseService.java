package br.com.purchaseclient.purchase.service;

import br.com.purchaseclient.purchase.PurchaseDTO;

@FunctionalInterface
public interface GetPurchaseService {

	PurchaseDTO find(Long id);

}
