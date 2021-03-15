package br.com.purchaseclient.purchase.service;

import br.com.purchaseclient.purchase.Purchase;

@FunctionalInterface
public interface UpdatePurchaseService {

	void update(Purchase purchase, Long id);

}
