package br.com.purchaseclient.purchase.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.purchaseclient.purchase.PurchaseDTO;

@FunctionalInterface
public interface ListPagePurchaseService {

	Page<PurchaseDTO> findPage(Integer searchTerm, Pageable pageable);

}