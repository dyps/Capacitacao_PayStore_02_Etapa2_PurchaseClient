package br.com.purchaseclient.purchase.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.purchaseclient.purchase.PurchaseDTO;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListPagePurchaseServiceImpl implements ListPagePurchaseService {

	private final PurchaseRepository purchaseRepository;
	private final BuscarClentesELivrosDaCompra buscarClentesELivrosDaCompra;

	public Page<PurchaseDTO> findPage(Integer searchTerm, Pageable pageable) {

		pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"));

//		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");

		Page<PurchaseDTO> paginas = PurchaseDTO
				.fromPage((searchTerm != null) ? purchaseRepository.findAll(searchTerm, pageable)
						: purchaseRepository.findAll(pageable));

		for (PurchaseDTO compra : paginas.getContent())
			buscarClentesELivrosDaCompra.buscarClienteELivros(compra);

		return paginas;
	}

}
