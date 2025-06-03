import java.util.Stack;

public class QueueUsingStack {
    static class MyQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public MyQueue() {

            inStack = new Stack<>();
            outStack = new Stack<>();

        }

        public void push(int x) {
            inStack.push(x);

        }

        public int pop() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }

            }
            return outStack.pop();

        }

        public int peek() {
            if (outStack.isEmpty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();

        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

    }

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // Output: 1
        System.out.println(myQueue.pop()); // Output: 1
        System.out.println(myQueue.empty()); // Output: false

    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */