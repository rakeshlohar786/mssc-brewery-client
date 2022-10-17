package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
public class BreweryClientTest {

	@Autowired
	BreweryClient client;
	
	@Test
	void getBeerId() {
		
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}
	
	
	@Test
	void testSavedNewBear() {
		//given
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		
		URI uri = client.saveNewBeer(beerDto);
		
		assertNotNull(uri);
		
		System.out.println(uri.toString());
		
	}
	
	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}
	
}
