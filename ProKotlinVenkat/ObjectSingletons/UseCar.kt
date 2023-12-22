fun useCarObject() : Pair<Int, String> {

    val car = Car(2019, "Red")
    val year = car.yearOfMake

    car.color = "Green"
    val color = car.color

    return year to color

}

/***
 * [~/ProgramingProjects/learningkotlin/ProKotlinVenkat/ObjectSingletons]$ kotlinc-jvm Car.kt UseCar.kt                                                    *[master]
 * [~/ProgramingProjects/learningkotlin/ProKotlinVenkat/ObjectSingletons]$ javap -c UseCarKt.class                                                         *[master]
 * Compiled from "UseCar.kt"
 * public final class UseCarKt {
 *   public static final kotlin.Pair<java.lang.Integer, java.lang.String> useCarObject();
 *     Code:
 *        0: new           #10                 // class Car
 *        3: dup
 *        4: sipush        2019
 *        7: ldc           #12                 // String Red
 *        9: invokespecial #16                 // Method Car."<init>":(ILjava/lang/String;)V
 *       12: astore_0
 *       13: aload_0
 *       14: invokevirtual #20                 // Method Car.getYearOfMake:()I
 *       17: istore_1
 *       18: aload_0
 *       19: ldc           #22                 // String Green
 *       21: invokevirtual #26                 // Method Car.setColor:(Ljava/lang/String;)V
 *       24: aload_0
 *       25: invokevirtual #30                 // Method Car.getColor:()Ljava/lang/String;
 *       28: astore_2
 *       29: iload_1
 *       30: invokestatic  #36                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *       33: aload_2
 *       34: invokestatic  #42                 // Method kotlin/TuplesKt.to:(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;
 *       37: areturn
 * }

 *The formatted excerpt from the output that follows shows that we’re not accessing the fields directly; we are using the set and get methods.
 * the code follows the JavaBean convention and doesn’t breach encapsulation
 *
 * In short, you can access the properties by providing the name of the property instead of using set and get
 * a field is a variable in java and a property is a "variable" in kotlin.
 * the difference is in java fields need a set and get must be accessed this way. In kotlin we can call the property and kotlin will use the set and get methods internally.
 * no need to use set and get methods, although we can to change the behvairo of the class
 */