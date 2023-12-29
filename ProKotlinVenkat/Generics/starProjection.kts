// Use star projection when you want to convey that you simply don’t know enough about the type but nevertheless want type safety.
// The star projection will permit only read-out and not write-in. Here’s a piece of code to use star projection:

fun printValues(values : Array<*>){
    for (value in values){ println(value)}

    // values[0] = value[1] // cannot write-in function, only reads
}

printValues(arrayOf(1,2))

/*The function printValues() takes an Array<*> as its parameter, and any change to the array isn’t permitted within the function. Had we written the parameter as Array<T>,
 then the commented out line, marked as ERROR, would have compiled if uncommented. That would result in potentially modifying the collection, when the intent is to iterate over it.
  The star projection protects us from such inadvertent errors. The star projection here, <*>, is equivalent to out T but is more concise to write. If star projection is used for a contravariant parameter,
  which is defined as <in T> in the declaration-site variance,
then it’s equivalent to in Nothing, to emphasize that writing anything will result in a compilation error. Thus, star projection prevents any writes and provides safety. */