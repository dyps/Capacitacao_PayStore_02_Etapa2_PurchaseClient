package br.com.purchaseclient.purchase.service;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.exceptions.PurchaseNotDeletedException;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeletePurchaseServiceImpl implements DeletePurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    public void delete(Long id) {
        if (!purchaseRepository.existsById(id)) {
            throw new PurchaseNotDeletedException();
        }
        purchaseRepository.deleteById(id);
    }
}
