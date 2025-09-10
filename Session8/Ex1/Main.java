package Session8.Ex1;

public class Main {
    public static void main(String[] args) {
        // tạo mảng động vật
        Animals [] animalsArray = new Animals[2];

        // tạo đối tượng dog, cat
        Dog dog1 = new Dog("Bddy", 3, "Golden Retriever");
        Cat cat1 = new Cat("Whiskers", 2, "Ghi");

        // add vào mảng
        animalsArray[0] = dog1;
        animalsArray[1] = cat1;
        for (int i = 0; i < animalsArray.length; i++) {
            animalsArray[i].displayInfo();
            animalsArray[i].makeSound();
            System.out.println();

        }
    }
}
