import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    //тест проверки на корректность работы метода eatMeat, который должен вернуть список еды для хищников
    @Test
    public void eatMeatReturnFoodListForFeline() throws Exception {
        Feline feline = new Feline(); //создаем объект класса Feline
        List<String> food = feline.eatMeat(); //вызываем метод eatMeat класса Feline
        assertEquals("Список еды для хищника должен содержать 'Животные', 'Птицы', 'Рыба'",
                List.of("Животные", "Птицы", "Рыба"), food); //сравниваем результат вызова eatMeat с ожидаемым значением
    }

    //тест проверки на корректность работы метода getFamily, который должен вернуть семейство кошачьих
    @Test
    public void getFamilyReturnsFamily() {
        Feline feline = new Feline(); //создаем объект класса Feline
        assertEquals("Семейство должно быть кошачьих", "Кошачьи", feline.getFamily());
        //сравниваем результата вызова getFamily с ожидаемым результатом
    }

    //тест проверки на корректность работы метода getKittens, который должен вернуть 1
    @Test
    public void getKittensReturnsOne() {
        Feline feline = new Feline(); //создаем объект класса Feline
        assertEquals(1, feline.getKittens()); //сравниваем результата вызова getKittens с ожидаемым результатом 1
    }

    //тест проверки на корректность работы метода getKittens, который должен вернуть переданное количество котят
    @Test
    public void getKittensReturnsNumberOfKittens() {
        Feline feline = new Feline(); //создаем объект класса Feline
        assertEquals("Метод getKittens(int) должен вернуть переданное количество котят",
                5, feline.getKittens(5));
    }
}