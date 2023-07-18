package es.inditex.api.data;

import es.inditex.api.infraestructure.repository.ProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

public class DataInitializerTest {

    @Mock
    private ProductJpaRepository productJpaRepository;

    private DataInitializer dataInitializer;

    @Test
    public void testInit() {
        // given
        MockitoAnnotations.openMocks(this);
        dataInitializer = new DataInitializer(productJpaRepository);
        // when
        dataInitializer.init();
        // then
        verify(productJpaRepository).saveAll(anyList());
    }
}
