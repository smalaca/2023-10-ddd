package com.smalaca.productmanagement.application.assortment;

import com.smalaca.productmanagement.domain.assortment.Assortment;
import com.smalaca.productmanagement.domain.assortment.AssortmentRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

class AssortmentApplicationServiceTest {

    @Test
    void shouldAddProductToAssortment() {
        AssortmentRepository assortmentRepository = Mockito.mock(AssortmentRepository.class);
        AssortmentApplicationService service = new AssortmentApplicationService(assortmentRepository);
        UUID sellerId = UUID.randomUUID();
        String productCode = new Faker().lorem().word();
        String productName = new Faker().lorem().word();
        AddProductCommand command = new AddProductCommand(sellerId, productCode, productName);

        service.addProduct(command);

        BDDMockito.then(assortmentRepository).should().save(any(Assortment.class));
        // sprawdź czy produkt dodany
    }
}
