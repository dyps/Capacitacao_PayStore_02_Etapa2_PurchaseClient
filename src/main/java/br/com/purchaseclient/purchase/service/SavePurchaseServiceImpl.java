package br.com.purchaseclient.purchase.service;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.purchase.Purchase;
import br.com.purchaseclient.purchase.PurchaseDTO;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SavePurchaseServiceImpl implements SavePurchaseService {

    private final PurchaseRepository purchaseRepository;
	private final BuscarClentesELivrosDaCompra buscarClentesELivrosDaCompra;

    @Override
    public void insert(Purchase purchase) {
    	buscarClentesELivrosDaCompra.buscarClienteELivros(PurchaseDTO.from(purchase));
        purchaseRepository.save(purchase);
    }
}
