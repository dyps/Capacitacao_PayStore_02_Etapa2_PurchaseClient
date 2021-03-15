package br.com.purchaseclient.purchase.service;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.exceptions.PurchaseNotFoundException;
import br.com.purchaseclient.purchase.Purchase;
import br.com.purchaseclient.purchase.PurchaseDTO;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdatePurchaseServiceImpl implements UpdatePurchaseService {

	private final PurchaseRepository purchaseRepository;
	private final BuscarClentesELivrosDaCompra buscarClentesELivrosDaCompra;

	@Override
	public void update(Purchase newPurchase, Long id) {
		buscarClentesELivrosDaCompra.buscarClienteELivros(PurchaseDTO.from(newPurchase));
		Purchase purchase = purchaseRepository.findById(id).orElseThrow(PurchaseNotFoundException::new);
		purchase.setClient(newPurchase.getClient());
		purchase.setBooks(newPurchase.getBooks());
		purchase.setAmount(newPurchase.getAmount());
		purchase.setDatePurchase(newPurchase.getDatePurchase());
		purchase.setCompleted(newPurchase.getCompleted());
		purchaseRepository.save(purchase);
	}
}
