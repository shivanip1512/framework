package framework.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreams {

	public static void main(String[] args) {
		// Primitive Streams in Java
		// Java provides specialized streams for primitive types: IntStream, LongStream, and DoubleStream
		// These streams are designed to handle primitive data types more efficiently than generic streams

		// Example of IntStream
		int[] numbers = {1, 2, 3, 4, 5};
		IntStream primitiveStream = Arrays.stream(numbers);
		
		Integer[] intWrapper = {10, 20, 30};
		Stream<Integer> wrapperStream = Arrays.stream(intWrapper);

		IntStream range = IntStream.range(1, 5);
		List<Integer> list = range.boxed().collect(Collectors.toList());
		System.out.println("range: " + list);
		
		System.out.println("rangeClosed: " + IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));
		
		IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
		DoubleStream doubles = new Random().doubles(5);
		System.out.println("DoubleStream: " + doubles.boxed().collect(Collectors.toList()));
	}

}
