package library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sahabt.library.domain.catalog.Catalog;

public class CatalogTest {

	@Test
	void test() {
		
	
		var inceMemed = new Catalog.Builder()
				.bookId(1)
				.cover(null)
				.isbn("TR01")
				.title("�nce Memed")
				.author("Ya�ar", "Kemal")
				.numberOfPages(438)
				.publishDate(01,02,1978)
				.publishingHouse("Varl�k Yay�nlar�")
				.language("TURKISH")
				.type("NOVEL")
				.topic("HISTORY")
				.useTarget("OTHER")
				.periodical("UNLIMITED")
				.available("AVAILABLE")
				.build();
		//System.out.print(inceMemed.getPublishDate().getPublishDate());
		
		assertEquals(1, inceMemed.getBookId().getBookId());
		assertEquals(null, inceMemed.getCover().getCover());
		assertEquals("TR01", inceMemed.getIsbn().getIsbn());
		assertEquals("�nce Memed", inceMemed.getTitle().getTitle());
		assertEquals("Ya�ar",inceMemed.getAuthor().getFirstName());
		assertEquals("Kemal",inceMemed.getAuthor().getLastName());
		assertEquals(438,inceMemed.getNumberOfPages().getNumberOfPages());
		assertEquals(01,inceMemed.getPublishDate().getDay());
		assertEquals(02,inceMemed.getPublishDate().getMounth());
		assertEquals(1978,inceMemed.getPublishDate().getYear());
		assertEquals("Varl�k Yay�nlar�",inceMemed.getPublishingHouse().getPublishingHouseName());
		assertEquals("TURKISH",inceMemed.getLanguage().toString());
		assertEquals("NOVEL",inceMemed.getType().toString());
		assertEquals("HISTORY",inceMemed.getTopic().toString());
		assertEquals("OTHER",inceMemed.getUseTarget().toString());
		assertEquals("UNLIMITED",inceMemed.getPeriodical().toString());
		assertEquals("AVAILABLE",inceMemed.getAvailable().toString());
					

	}
	
	

}
