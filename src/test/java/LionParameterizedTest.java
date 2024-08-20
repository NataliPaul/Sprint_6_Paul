import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedMane;

    @Mock
    private Feline feline; //Мок класса Feline

    private Lion lion; // создаем объект класса Lion

    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this); // Инициализация моков
        lion = new Lion(sex, feline); //создаем объект Lion с параметром sex
    }

    //тест проверяет пол льва
    @Test
    public void returnsGenderOfLion() {
        assertEquals("Некорректный пол льва", expectedMane, lion.doesHaveMane());
    }

    //тест проверяет, что возвращается правильный список еды для льва
    @Test
    public void returnsFoodList() throws Exception {
        //настраиваем, чтобы метод getFood() возвращал список "Животные", "Птицы", "Рыба"
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        //сравниваем результат вызова getFood с ожидаемым значением
        assertEquals("Тест не прошел", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    //тест проверяет, что возвращается правильное количество котят
    @Test
    public void returnsNumberOfKittens() {
        Mockito.when(feline.getKittens()).thenReturn(5); // настраиваем, чтобы метод getKittens() возвращал 5
        assertEquals("Количество котят должно быть равно 5", 5, lion.getKittens());
    }
}
