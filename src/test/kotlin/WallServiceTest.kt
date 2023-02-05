import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addPost() {
        val post1 = Post(id = 100, authorId = 100, authorName = "Ivan", "text", published = 1, 2021)
        val expected = 2
        WallService.add(post1)
        val result = WallService.add(post1).id
        assertEquals(expected, result)
    }

    @Test
    fun update() {
        val post1 = Post(id = 10, authorId = 88, authorName = "Ivan", content = "text", published = 100, date = 2021)
        val post2 = Post(id = 11, authorId = 99, authorName = "Ivan2", content = "text", published = 101, date = 2022)
        //val post3 = Post(id = 12, authorId = 100, authorName = "Ivan3", content = "tra-ta-ta", published = 102, date = 2023)
        WallService.add(post1)
        val result = WallService.update(post2)
        val expected = "text"
        assertFalse(expected,result)
    }
    @Test
    fun newComment() {
        val postComment = Post(1, authorId = 1, authorName = "Ivan", "text", published = 1, date = 2021)
        val commentForTest1 = Comment(101, "yra", id = 1, canPost = false, groupsCanPost = false, canClose = false, canOpen = false)
        val expected = "yra"
        WallService.add(postComment)
        WallService.newComment(commentForTest1, 1)
        val result = commentForTest1.text
        assertEquals(expected, result)
    }

    @Test
    fun noPost() {
        val post1 = Post(1, authorId = 1, authorName = "Ivan", "text", published = 1, date = 2021)
        WallService.add(post1)
        val commentTest2 = Comment(101, "text", id = 1, canPost = false, groupsCanPost = false, canClose = false, canOpen = false)
        WallService.newComment(commentTest2, 1)
    }
}
