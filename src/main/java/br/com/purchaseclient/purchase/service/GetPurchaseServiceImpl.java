package br.com.purchaseclient.purchase.service;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.exceptions.PurchaseNotFoundException;
import br.com.purchaseclient.purchase.PurchaseDTO;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetPurchaseServiceImpl implements GetPurchaseService {

	private final PurchaseRepository purchaseRepository;
	private final BuscarClentesELivrosDaCompra buscarClentesELivrosDaCompra;

	public PurchaseDTO find(Long id) {

		PurchaseDTO compra = PurchaseDTO
				.from(purchaseRepository.findById(id).orElseThrow(PurchaseNotFoundException::new));

		buscarClentesELivrosDaCompra.buscarClienteELivros(compra);
		return compra;
	}

}
