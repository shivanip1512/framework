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
		
		
		// 7. Peek
		// Peek is an intermediate operation that allows you to perform an action on each
//		Stream.iterate(1, x->x+1).skip(10).limit(100).peek(x -> System.out.println("Peeked: " + x)).count();
		
		// 8. flatMap
		// Handle streams of collections, list or arrays where each element is itself a collection
		// Flattens the nested structure so that they can be processed as a single sequence of elements
		// Transform and flatten elements at the same time
		List<List<String>> nestedList = Arrays.asList(
				Arrays.asList("apple", "banana"),
				Arrays.asList("orange", "kiwi"),
				Arrays.asList("grape", "pear")
		);
		
		List<String> flatMap = nestedList.stream()
										 .flatMap(x->x.stream()) // Flatten the nested lists into a single stream
										 .map(String::toUpperCase) // Transform each element to uppercase
										 .toList();
		System.out.println("FlatMap Result: " + flatMap);

		List<String> list2 = Arrays.asList("Hello World", "Java Streams", "Intermediate Operations")
								.stream()
								.flatMap(s -> Arrays.stream(s.split(" ")))
								.map(String::toUpperCase)
								.toList();
		System.out.println("FlatMap with Split: " + list2);
		
	}

}
