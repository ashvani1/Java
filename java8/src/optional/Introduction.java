package optional;

public class Introduction {
    /*
    * This is used to avoid Null Pointer Exception.
    *
    * ******Methods*****
    * of()                  => give NullPointerException for null value
    * ofNullable()          => return Optional.empty() for null
    * empty()               => give empty object as result
    * orElse()              => can get a default value like a "String"
    * orElseGet(Supplier)   => can get any value, for example if no data from Option, create an object by supplier and get
    * orElseThrow(Supplier) => can get any Exception, for example if no data from Option create an object by supplier and get
    * isPresent()           => return true when Optional has data
    * ifPresent()           => take a Consumer and execute it only once Optional has data
    * map()                 => similar to collection
    * flatMap()             => similar to collection
    * filter()              => If we want to get Optional object inside another Optional object then we use flatMap
    *                          similar to when in collection we have list inside, inside list
    *
    * */
}
