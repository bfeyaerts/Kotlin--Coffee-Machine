class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var currentId = 0
        fun create(name: String): Player {
            return Player(currentId++, name, 100)
        }
    }
}