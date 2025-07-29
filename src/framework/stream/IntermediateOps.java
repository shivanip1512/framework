package framework.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 */
public class IntermediateOps {

	public static void main(String[] args) {
		// Intermediate operations transform a stream into another stream
		// They are lazy, meaning they don't execute until a terminal operation is
		// invoked.

		List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ghanshyam");

		// 1. Filter
		Stream<String> stream = list.stream().filter(x -> x.endsWith("am"));

		// no filtering until this point
		long count = stream.count();
		System.out.println(count);

		// 2. Map
		Stream<String> stream2 = list.stream().map(x -> x.toUpperCase());

		// 3. sort
		Stream<String> stream3 = list.stream().sorted();
		Stream<String> streamUsingComparator = list.stream().sorted((a, b) -> a.length() - b.length());

		// 4. distinct
		Stream<String> stream4 = list.stream().distinct();

		// 5. limit
		Stream<Integer> stream5 = Stream.iterate(1, x -> x + 1).limit(1512);
		System.out.println(stream5.count());

		// 6. skip
		Stream<Integer> stream6 = Stream.iterate(1, x -> x + 1).limit(1512).skip(10);
		Stream<Integer> stream6_1 = Stream.iterate(1, x -> x + 1).skip(10).limit(1512);
		System.out.println(stream6.count() + " " + stream6_1.count());
		
		
	}

}
