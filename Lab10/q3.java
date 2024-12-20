class GenericStack<T> {
    private T[] stackArray;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public GenericStack(int size) {
        capacity = size;
        stackArray = (T[]) new Object[size];
        top = -1;
    }

    public void push(T element) {
        if (top == capacity - 1) {
            System.out.println("Stack is full!");
        } else {
            stackArray[++top] = element;
        }
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            return stackArray[top--];
        }
    }

    public T peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{Name: " + name + ", ID: " + id + "}";
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "Employee{Name: " + name + ", Salary: " + salary + "}";
    }
}

public class q3 {
    public static void printStack(GenericStack<?> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        GenericStack<Student> studentStack = new GenericStack<>(5);
        studentStack.push(new Student("Alice", 101));
        studentStack.push(new Student("Bob", 102));

        System.out.println("Student Stack:");
        printStack(studentStack);

        GenericStack<Employee> employeeStack = new GenericStack<>(5);
        employeeStack.push(new Employee("John", 50000));
        employeeStack.push(new Employee("Jane", 60000));

        System.out.println("\nEmployee Stack:");
        printStack(employeeStack);
    }
}
