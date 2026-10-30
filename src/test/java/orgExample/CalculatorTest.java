package orgExample;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Задача 2. Первый тест!
В папке src/test/java создай пакет org.example.
Создай класс CalculatorTest. (IntelliJ обычно подсказывает это сделать через Cmd + Shift + T на классе Calculator).
Напиши тесты с аннотациями @Test:
Тест testAdd — проверь, что add(2, 3) равно 5.
Тест testSubtract — проверь, что subtract(10, 4) равно 6.
Тест testMultiply — проверь, что multiply(3, 3) равно 9.
Запусти тесты (зеленая стрелочка рядом с классом CalculatorTest). Убедись, что они зеленые (Passed).
 */
/*Задача 5. Проверка на true/false (со звёздочкой)

Создай в Calculator метод boolean isEven(int n) (возвращает true, если число четное).
В тестах напиши:

testIsEvenTrue — проверяет, что isEven(4) это true (используй assertTrue).
testIsEvenFalse — проверяет, что isEven(5) это false (используй assertFalse).
 */
class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp(){
        calc = new Calculator();
    }
    @Test
    void testIsEvenTrue(){
        assertTrue(calc.isEven(4));
    }
    @Test
    void testIsEvenFalse(){
        assertFalse(calc.isEven(5));
    }
    @Test
    void testAdd() {
        int actualResult = calc.add(2, 3);
        assertEquals(5, actualResult);
    }

    @Test
    void testSubtract() {
        int actualResult = calc.subtract(10, 4);
        assertEquals(6, actualResult);
    }

    @Test
    void testMultiply() {
        int actualResult = calc.multiply(3, 3);
        assertEquals(9, actualResult);
    }

    /*
    Задача 3. Тестирование исключений
В CalculatorTest добавь тест testDivideByZero.
Используй assertThrows, чтобы проверить, что при вызове divide(10, 0) выбрасывается IllegalArgumentException.
     */
    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(10, 0);
        });
    }
/*
Задача 4. Использование @BeforeEach
Создай приватное поле Calculator calculator; в тестовом классе.
Создай метод setUp() с аннотацией @BeforeEach, который инициализирует это поле (calculator = new Calculator();).
Убери создание объекта из самих тестов и используй поле.
 */

}
