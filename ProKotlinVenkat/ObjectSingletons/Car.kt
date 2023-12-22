class Car (val yearOfMake : Int , var color : String) // classes are public final by default

/**
 * [~/ProgramingProjects/learningkotlin/ProKotlinVenkat/ObjectSingletons]$ kotlinc-jvm Car.kt                                                              *[master]
 * [~/ProgramingProjects/learningkotlin/ProKotlinVenkat/ObjectSingletons]$ javap -p Car.class                                                              *[master]
 * Compiled from "Car.kt"
 * public final class Car {
 *   private final int yearOfMake;
 *   private java.lang.String color;
 *   public Car(int, java.lang.String);
 *   public final int getYearOfMake();
 *   public final java.lang.String getColor();
 *   public final void setColor(java.lang.String);
 * }
 *
 * */

// with one line, kotlin created two fields for backing the properties, a constructor, two getters and a setter.
