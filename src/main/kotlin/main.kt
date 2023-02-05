
object WallService {
    private var posts = emptyArray<Post>()
    private var standartPostId: Int = 1
    private var standartCommentID: Int = 1
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        posts += post.copy(id = standartPostId)
        standartPostId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index] = post.copy(id = post.id, date = post.date)
                return true
            }
        }
        return false
    }

    fun newComment(comment: Comment, postId: Int): Comment {
        for (post in posts) {
            if (post.id == postId) {
                standartCommentID++
                val newComment = comment.copy(id = standartCommentID)
                comments += newComment
                println("Комментарий добавлен")
                return comments.last()
            }
        }
        throw NoPost("Пост удален или не существует")
    }


}

fun main() {

}