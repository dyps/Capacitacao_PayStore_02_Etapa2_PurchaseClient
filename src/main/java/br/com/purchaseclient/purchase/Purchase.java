package br.com.purchaseclient.purchase;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder(builderClassName = "Builder")
@Table(name = "TB_Purchase")
//@SecondaryTable(name = "tb_book_purchases", foreignKey = @ForeignKey(foreignKeyDefinition = "purchase_id")  )
public class Purchase implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PurchaseSeq")
	@SequenceGenerator(name = "PurchaseSeq", sequenceName = "PURCHASE_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "client_id")
	private Long client;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tb_book_purchases", joinColumns = @JoinColumn(name = "purchase_id"))
	@Column(name = "book_id")
	private List<Long> books;

	private Float amount;

	private LocalDate datePurchase;
	private Boolean completed;

	public static Purchase to(@Valid PurchaseDTO purchaseDTO) {
		List<Long> listaLivros = new ArrayList<Long>();
		for (BookDTO bookDTO : purchaseDTO.getBooks()) 
			listaLivros.add(bookDTO.getId());
		return Purchase.builder()
				.id(purchaseDTO.getId())
				.client(purchaseDTO.getClient().getId())
				.books(listaLivros )
				.amount(purchaseDTO.getAmount())
				.datePurchase(purchaseDTO.getDatePurchase())
				.completed(purchaseDTO.getCompleted())
				.build();
	}

}
