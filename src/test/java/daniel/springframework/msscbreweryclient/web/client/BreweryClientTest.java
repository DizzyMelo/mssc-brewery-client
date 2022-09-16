package daniel.springframework.msscbreweryclient.web.client;

import daniel.springframework.msscbreweryclient.web.model.BeerDto;
import daniel.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertThat(beerDto).isNotNull();
    }

    @Test
    void createBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = breweryClient.createBeer(beerDto);
        assertThat(uri).isNotNull();
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New name").build();
        breweryClient.updateBeer(beerDto.getId(), beerDto);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomer() {
        CustomerDto customer = breweryClient.getCustomer(UUID.randomUUID());
        assertThat(customer).isNotNull();
    }

    @Test
    void createCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Test").build();
        URI uri = breweryClient.createCustomer(customerDto);
        assertThat(uri).isNotNull();
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Test").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}