class Block(val color: String) {
    object BlockProperties {
        var length = 9
        var width = 4

        fun blocksInBox(length: Int, width: Int): Int {
            val rows = length / BlockProperties.length
            val columns = width / BlockProperties.width
            return rows * columns
        }
    }
}