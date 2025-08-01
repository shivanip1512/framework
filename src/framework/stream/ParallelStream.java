package framework.stream;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {

	public static void main(String[] args) {
		// A type of stream that allows parallel processing of elements
		// Allowing multiple threads to process parts of the stream simultaneously
		// This can lead to performance improvements for large datasets
		// Workload is distributed across multiple threads

		long startTime = System.currentTimeMillis();
		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
		list.stream().map(ParallelStream:: factorial).toList();
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken for sequential stream: " + (endTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		list.parallelStream().map(ParallelStream::factorial).toList();
//		list.parallelStream().map(ParallelStream::factorial).sequential().toList();
		endTime = System.currentTimeMillis();
		System.out.println("Time taken for parallel stream: " + (endTime - startTime) + " ms");
		
		
		// Parallel streams can be beneficial for CPU-intensive tasks or large datasets where tasks are independent
		// However, they may not be suitable for I/O-bound tasks or when order of processing is important
		
		// Cumulative sum example
		// Expected Output : Cumulative sum: [1, 3, 6, 10, 15]
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		AtomicInteger sum= new AtomicInteger(0);
		var cumulativeSum = numbers.parallelStream().map(n -> sum.addAndGet(n)).toList();
		System.out.println("Cumulative sum: " + cumulativeSum); // Incorrect output due to parallel processing
		var cumulativeSum1 = numbers.parallelStream().map(n -> sum.addAndGet(n)).toList();
		System.out.println("Cumulative sum: " + cumulativeSum1); // Correct output due to sequential processing
	}
	
	private static long factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

}
