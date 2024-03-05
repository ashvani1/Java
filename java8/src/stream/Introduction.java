package stream;

public class Introduction {
    //Streams introduction
    /*
    * Stream is sequence of elements
    * Introduced in Java8 to perform operations on collections effectively.
    * Parallel operations on collections became easy with stream
    * until stream has a Terminal operation, non of the operation will start [no Intermediate operation will run without terminal operation]
     */

    //Difference between Collection and Stream
    /*
    * In Collection we can add/modify elements at any point of time but this is not applicable on Stream
    * Elements of collection can be accessed in any order ex[using index], but stream elements can be accessed only in sequence.
    * Collection is eagerly constructed but Streams are lazily.
    * Collection can be traversed as many times as we want but streams can be traversed only once. we can create another
      stream from current stream for further operations
    */

    //Stream API methods
    /*
    * map()       => convert one type to another
    * flatMap()   => similar to map but used where each element of stream represent multiple elements
                     example: Stream<List>, Stream<Arrays> [activities of Student class]
    * distinct()  => returns a stream with unique elements
    * count()     => total number of elements in stream [long]
    * sorted()    => sort the elements of stream [optionally takes a Comparator object]
    * reduce()    => reduce the contents of a stream to a single value. takes 2 parameters [default value, BinaryOperator]
    * max()       => takes a comparator to decide the pattern to find max, in general for integer max(Integer::compareTo)
    * min()       => takes a comparator to decide the pattern to find min, in general for integer min(Integer::compareTo)
    * limit()     => limits n number of elements to be processed in the stream [takes n input as number of elements]
    * skip()      => skip n number of elements from the stream [takes n input as number of elements]
    * anyMatch()  => true, if any element matched the predicate else false [takes predicate returns a boolean]
    * allMatch()  => true, if all elements matched the predicate else false [takes predicate returns a boolean]
    * noneMatch() => true, if none of the element matched the predicate else false [takes predicate returns a boolean]
    * findFirst() => return first element [return as Optional]
    * findAny()   => return first encountered element in the stream [return as Optional]
    * of()        => create a stream based on values passed to this method
    * iterate()   => to create infinite stream
    * generate()  => to create infinite stream
    * summingInt() => return sum as a result, it takes a
    * averagingInt() => return average as a result
    *
    * */

    /*Methods that adhere short circuiting*/
    /*limit(), findFirst(), findAny(), anyMatch(), allMatch(), noneMatch()
    All these functions doesn't have to iterate the whole stream to evaluate the result.
     */

    //Terminal Operations : operation that collects the data
    /*
    * forEach() =>
    * min()     =>
    * max()     =>
    * reduce()  =>
    * collect() =>
    * joining() => can be used under collect as collect(Collectors.joining()). will join and collect each data came from stream
    * counting()=> total number pf elements as collect(Collectors.counting())
    * mapping() => applies a transformation function first and then collects
    * groupingBy() => return result based on property and it returns Map<K, V>.
                    groupingBy(classifier)
                    groupingBy(classifier, downStream)
                    groupingBy(classifier, supplier, downStream)
    * partitioningBy() => do grouping, accept predicate and return map
                          partitioningBy(predicate)
                          partitioningBy(predicate, downStream)


    * */


    //collect methods
    /*
    * joining()  =>
    * counting() =>
    * minBy()    =>
    * maxBy()    =>
    * summingInt()  =>
    * averagingImt() =>
    * */


}
