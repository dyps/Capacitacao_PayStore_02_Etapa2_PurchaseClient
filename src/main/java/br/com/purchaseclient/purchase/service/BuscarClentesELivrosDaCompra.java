package br.com.purchaseclient.purchase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.exceptions.BookNotFoundException;
import br.com.purchaseclient.exceptions.ClientNotFoundException;
import br.com.purchaseclient.purchase.BookDTO;
import br.com.purchaseclient.purchase.PurchaseDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BuscarClentesELivrosDaCompra {
	public final GetClientService getClientService;
	public final GetBookService getBookService;

	public void buscarClienteELivros(PurchaseDTO compra) {
		try {
			compra.setClient(getClientService.find(compra.getClient().getId()));
			
		} catch (FeignException e) {
			throw new ClientNotFoundException();
		}
		List<BookDTO> listalivros = new ArrayList<BookDTO>();
		for (BookDTO book : compra.getBooks())
			try {
				listalivros.add(getBookService.find(book.getId()));
			} catch (FeignException e) {
				throw new BookNotFoundException();
			}
		compra.setBooks(listalivros);
	}
}