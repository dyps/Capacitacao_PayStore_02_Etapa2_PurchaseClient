package br.com.purchaseclient.purchase.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.purchaseclient.purchase.Purchase;
import br.com.purchaseclient.purchase.PurchaseDTO;
import br.com.purchaseclient.purchase.service.DeletePurchaseService;
import br.com.purchaseclient.purchase.service.GetPurchaseService;
import br.com.purchaseclient.purchase.service.ListPagePurchaseService;
import br.com.purchaseclient.purchase.service.ListPurchaseService;
import br.com.purchaseclient.purchase.service.SavePurchaseService;
import br.com.purchaseclient.purchase.service.UpdatePurchaseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api/purchase")
@EnableFeignClients(basePackages = "br.com.purchaseclient.purchase.service")
public class PurchaseControllerV1 {

	private final GetPurchaseService getPurchaseService;
	private final ListPurchaseService listPurchaseService;
	private final ListPagePurchaseService listPagePurchaseService;
	private final SavePurchaseService savePurchaseService;
	private final UpdatePurchaseService updatePurchaseService;
	private final DeletePurchaseService deletePurchaseService;

	@GetMapping(value = "/{id}")
	public PurchaseDTO find(@PathVariable("id") Long id) {
		return getPurchaseService.find(id);
	}

	@GetMapping
	public List<PurchaseDTO> findAll() {
		return listPurchaseService.findAll();
	}

	@GetMapping("/search")
	public Page<PurchaseDTO> search(@RequestParam(value = "cliente_id", required = false) Integer searchTerm,
			Pageable pageable) {

		Page<PurchaseDTO> paginas = listPagePurchaseService.findPage(searchTerm, pageable);

		return paginas;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping 
	public void insert(@Valid @RequestBody PurchaseDTO purchaseDTO) {
		savePurchaseService.insert(Purchase.to(purchaseDTO));
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@PutMapping(value = "/{id}") 
	public void update(@Valid @RequestBody PurchaseDTO purchaseDTO, @PathVariable Long id) {
		updatePurchaseService.update(Purchase.to(purchaseDTO), id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}") 
	public void delete(@PathVariable Long id) {
		deletePurchaseService.delete(id);
	}

}
