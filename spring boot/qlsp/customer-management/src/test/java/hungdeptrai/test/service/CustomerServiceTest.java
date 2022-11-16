package hungdeptrai.test.service;

import cg.wbd.grandemonstration.exception.CustomerNotFoundException;
import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.repository.CustomerRepository;
import cg.wbd.grandemonstration.service.impl.CustomerServiceImplWithSpringData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerServiceImplWithSpringData customerService;

    @Test
    void whenFindAll_shouldReturnList() {
        // 1. create mock data
        List<Customer> mockBooks = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            mockBooks.add(new Customer((long)i));
        }

        // 2. define behavior of Repository
        when(customerRepository.findAll()).thenReturn(mockBooks);

        // 3. call service method
        List<Customer> actualCustomers = customerService.findAll();

        // 4. assert the result
        assertThat(actualCustomers.size()).isEqualTo(mockBooks.size());

        // 4.1 ensure repository is called
        verify(customerRepository).findAll();
    }

    @Test
    void whenFindInvalidOne_shouldThrowException() {
        Long invalidCustomerId = 99l;

        when(customerRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(null));

        assertThatThrownBy(() -> customerService.findOne(invalidCustomerId))
                .isInstanceOf(CustomerNotFoundException.class);

//        verify(customerRepository).findById(any(Long.class));
        verify(customerRepository).findById(invalidCustomerId);
    }
}
