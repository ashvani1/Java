package functionalInterfaces.consumer;

import java.util.function.Consumer;

public class ConsumerExample1 {
        public static void main(String[] args) {
            Consumer<String> consumer = (string) -> {
                System.out.println(string.toUpperCase());
            };

            consumer.accept("Hello");

        }
}
