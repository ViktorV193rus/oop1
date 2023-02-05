data class Comment(
    val count: Long,
    val text: String,
    val id: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean)
