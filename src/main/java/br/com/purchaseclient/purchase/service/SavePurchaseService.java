package br.com.purchaseclient.purchase.service;

import br.com.purchaseclient.purchase.Purchase;

@FunctionalInterface
public interface SavePurchaseService {

	void insert(Purchase purchase);

}
