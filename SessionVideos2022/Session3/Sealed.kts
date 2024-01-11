sealed interface Car
class CRV: Car
class RAV4: Car

sealed class Car2(var maker: String) // sealed classes can have data. 
class CRV2 : Car2("Honda")
class RAV42 : Car2("Toyota")
