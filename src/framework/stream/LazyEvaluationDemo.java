package framework.stream;

public class LazyEvaluationDemo {

	public static void main(String[] args) {
		// Example of lazy evaluation in streams
		// The stream operations are not executed until a terminal operation is invoked

		// Create a stream of integers
		java.util.stream.Stream<Integer> stream = java.util.stream.Stream.of(1, 2, 3, 4, 5);

		// Intermediate operations (lazy)
		java.util.stream.Stream<Integer> filteredStream = stream.filter(x -> {
			System.out.println("Filtering: " + x);
			return x % 2 == 0;
		}).map(x -> {
			System.out.println("Mapping: " + x);
			return x * 2;
		});
		
		System.out.println("[Before terminal Operation] - Stream created, but no operations executed yet.");

		// Terminal operation (eager)
		filteredStream.forEach(x -> System.out.println("Final value: " + x));
	}

}
