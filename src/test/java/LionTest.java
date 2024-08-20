import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    @Mock
    private Feline feline; //Мок класса Feline

    @Before
    public void setUp()  {
        MockitoAnnotations.openMocks(this); // Инициализация моков
    }

    //тест проверяет исключение
    @Test
    public void doesHaveManeThrowsExceptionForUnknownSex() {
        Exception thrown = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
    }
}
