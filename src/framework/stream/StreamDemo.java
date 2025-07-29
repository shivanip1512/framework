package framework.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		long count = list.stream().filter(i -> i % 2 == 0).count();
		System.out.println(count);
	}

	void createStreams() {
		// 1. From Collections
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream1 = list.stream();

		// 2. From Arrays
		String[] arr = { "a", "b", "c" };
		Stream<String> stream2 = Arrays.stream(arr);

		// 3. Using Stream.of()
		Stream<String> stream3 = Stream.of("a", "b", "c");

		// 4. Infinite streams
		Stream.generate(() -> 1);
		Stream.iterate(0, x -> x + 1);
	}

}
