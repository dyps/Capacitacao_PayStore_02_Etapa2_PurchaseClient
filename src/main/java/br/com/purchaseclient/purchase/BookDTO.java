package br.com.purchaseclient.purchase;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class BookDTO {

	@NotNull // para validar ao ser puxado pela compra
	@Positive
	private Long id;

	private String title ;
	private String synopsis;
	private String isbn;
	private String author;
	private LocalDate yearPublication ;
	private Float priceSale ;
	private Integer availableQuantity;

	private List<BookCategoryDTO> bookCategories;

}
