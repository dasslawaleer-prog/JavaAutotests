package orgExample;
/*
Задача 1. Калькулятор для тестов
В папке src/main/java создай пакет org.example. Внутри создай класс Calculator.
Напиши методы (пока без main):

int add(int a, int b)
int subtract(int a, int b)
int multiply(int a, int b)
double divide(int a, int b) — если b == 0, выброси IllegalArgumentException("Division by zero").
кстати ты можешь более развернуто писать лекции. Ты не устал бро? Мы же не можем создавать пакеты в названии где есть точка. org.example
а когда мы будет графические окна делать интерфейса? есть они в плане?
 */
public  class Calculator {

    boolean isEven(int n){
        return n%2==0;
    }
    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a, int b){
        return a-b;
    }
    public int multiply(int a, int b){
        return a*b;
    }
    public int divide(int a, int b) throws IllegalArgumentException {
        if(b==0){throw new IllegalArgumentException("Division by zero");}
        return a/b;
    }


}
