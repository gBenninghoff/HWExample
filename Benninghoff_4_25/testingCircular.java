//Gabe Benninghoff
//Chapter 4 #25
//I did not copy code from other people or sources other than our CIS-221 textbook. 
//I did not use any "AI" software to help write code

public class testingCircular {

    public static void main(String[] args) {
        circularQueue<String> circlar = new circularQueue<String>();
        // --------------------------------------------------------//
        // one element test case
        circlar.enqueue("Hi");
        System.out.println(circlar.dequeue());
        System.out.println();
        System.out.println();
        // --------------------------------------------------------//
        // two elements test case
        circlar.enqueue("Hello There");
        circlar.enqueue("Daniel");
        System.out.println(circlar.dequeue());
        System.out.println(circlar.dequeue());
        System.out.println();
        System.out.println();
        // --------------------------------------------------------//
        // 10 elements test case
        circlar.enqueue("A");
        circlar.enqueue("B");
        circlar.enqueue("C");
        circlar.enqueue("D");
        circlar.enqueue("E");
        circlar.enqueue("F");
        circlar.enqueue("G");
        circlar.enqueue("H");
        circlar.enqueue("I");
        circlar.enqueue("J");
        System.out.println(circlar.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(circlar.dequeue());
        }
        System.out.println(circlar.size());

        System.out.println(circlar.isEmpty());
        System.out.println(circlar.isFull());

    }
}
