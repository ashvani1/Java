package stream.numericStreams;

public class Introduction {
    //numeric Streams
    /*
    * IntStream:
        methods:
            range(1, 50) => 1...49
            rangeClosed(1, 50) => 1...50
    * LongStream:
         methods:
            range(1, 50) => 1...49
            rangeClosed(1, 50) => 1...50
    * DoubleStream:
          doest have range() and rangeClosed()


    //Aggregate functions of numeric stream
    * sum()      => sum of all stream elements
    * max()      => max from all stream elements
    * min()      => min from all stream elements
    * average()  => average of all stream elements
    * boxed()    => converting primitive to Wrapper class
    * mapToInt() =>
            this is applicable on a Integer Stream to convert it to intStream like stream.mapToInt(Integer::intValue);
            another use case can be when we need to do some calculation like find sum of all notebooks that student having
            here, we can use mapToInt(Student::getNoteBooks)
    */
}
