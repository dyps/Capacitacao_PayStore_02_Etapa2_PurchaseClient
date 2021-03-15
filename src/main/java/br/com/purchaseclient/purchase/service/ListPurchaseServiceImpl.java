package br.com.purchaseclient.purchase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.purchase.PurchaseDTO;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListPurchaseServiceImpl implements ListPurchaseService {

	private final PurchaseRepository purchaseRepository;
	private final BuscarClentesELivrosDaCompra buscarClentesELivrosDaCompra;

	public List<PurchaseDTO> findAll() {

		List<PurchaseDTO> lista = PurchaseDTO.fromAll(purchaseRepository.findAll());

		for (PurchaseDTO compra : lista)
			buscarClentesELivrosDaCompra.buscarClienteELivros(compra);
		return lista;
	}

}
