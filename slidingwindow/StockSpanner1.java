import java.util.Stack;

public class StockSpanner1 {

    static class StockSpanner {

        public StockSpanner() {

            stack = new Stack<>();

        }

        class Pair {
            int span;
            int price;

            Pair(int span, int price) {
                this.span = span;
                this.price = price;
            }

        }

        Stack<Pair> stack;

        public int next(int price) {
            int span = 1;

            while (!stack.isEmpty() && stack.peek().price <= price) {
                span += stack.pop().span;
            }
            stack.push(new Pair(span, price));
            return span;

        }
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100); // return 1
        stockSpanner.next(80); // return 1
        stockSpanner.next(60); // return 1
        stockSpanner.next(70); // return 2
        stockSpanner.next(60); // return 1
        stockSpanner.next(75); // return 4, because the last 4 prices (including today's price of 75) were less
                               // than or equal to today's price.
        stockSpanner.next(85); // return 6

    }
}
