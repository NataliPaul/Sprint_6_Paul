import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CatTest {

    private Predator predator; //Мок для интерфейса Predator для замены реального объекта Feline
    private Cat cat; // создаем объект класса Cat

    //
    @Before //
    public void setUp() {
        predator = Mockito.mock(Feline.class); //создаем мок-объект для класса Feline, который реализует интерфейс Predator
        cat = new Cat((Feline) predator); // инициализируем объект Cat, передавая в него мок predator
    }

    //тест проверки на корректность работы метода getSound, который должен вернуть строку "Мяу"
    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Должна вернуться строка 'Мяу'","Мяу", cat.getSound());
    }

    //тест проверяет, что метод getFood() возвращает тот же список, который возвращает метод eatMeat() на мок-объекте
    @Test
    public void getFoodReturnsListIsPredator() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба"); //Ожидаемый результат для хищника
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood); // Настройка поведения мока
        assertEquals("Если объект хищник, то должна вернуться еда 'Животные', 'Птицы', 'Рыба'",
                expectedFood, cat.getFood()); // Проверка, что метод getFood возвращает еду хищника
    }

    //тест проверяет, если метод predator возвращает пустой список
    @Test
    public void getFoodNull() throws Exception {
        Mockito.when(predator.eatMeat()).thenReturn(null);
        assertNull("Метод getFood должен вернуть null", cat.getFood());
    }

    //тест проверяет, если метод getFood() возвращает null
    @Test
    public void getFoodReturnsEmptyList() throws Exception {
        List<String> emptyFoodList = Collections.emptyList();
        Mockito.when(predator.eatMeat()).thenReturn(emptyFoodList);
        assertEquals("Метод getFood должен вернуть пустой список", emptyFoodList, cat.getFood());
    }
}