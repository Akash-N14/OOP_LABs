// Generic Stack class
class GenericStack<T> {
    private T[] stackArray;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public GenericStack(int size) {
        capacity = size;
        stackArray = (T[]) new Object[size]; // Creating a generic array
        top = -1;
    }

    // Push an element onto the stack
    public void push(T element) {
        if (top == capacity - 1) {
            System.out.println("Stack is full!");
        } else {
            stackArray[++top] = element;
        }
    }

    // Pop an element from the stack
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            return stackArray[top--];
        }
    }

    // Peek at the top element of the stack
    public T peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            return stackArray[top];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

// Student class
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

// Employee class
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{Name: " + name + ", Salary: " + salary + "}";
    }
}

public class q2 {
    public static void main(String[] args) {
        // Stack for Student objects
        GenericStack<Student> studentStack = new GenericStack<>(5);
        studentStack.push(new Student("Alice", 101));
        studentStack.push(new Student("Bob", 102));

        System.out.println("Top of student stack: " + studentStack.peek());
        System.out.println("Popped from student stack: " + studentStack.pop());
        System.out.println("Top of student stack after pop: " + studentStack.peek());

        // Stack for Employee objects
        GenericStack<Employee> employeeStack = new GenericStack<>(5);
        employeeStack.push(new Employee("John", 50000));
        employeeStack.push(new Employee("Jane", 60000));

        System.out.println("\nTop of employee stack: " + employeeStack.peek());
        System.out.println("Popped from employee stack: " + employeeStack.pop());
        System.out.println("Top of employee stack after pop: " + employeeStack.peek());
    }
}
