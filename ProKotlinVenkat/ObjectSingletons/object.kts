fun drawCircle() {
    val circle = object { // object expression is useful on lyt to group a few local variables together.
        // anon objects internal types such as circle.x cannot
        // stand as return types to functions or methods
        // cant be used as types of parameters to functions or methods
        // if they are stored as a properties in a class they will be of type Any. none of their properties or methods will be available for direct access
        val x = 10
        val y = 20
        val radius = 30
    }

    println("Circle x: ${circle.x} y: ${circle.y} radius: ${circle.radius}")
}

drawCircle() 