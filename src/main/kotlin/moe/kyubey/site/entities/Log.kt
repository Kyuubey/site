package moe.kyubey.site.entities

data class Log(
        val event: String,

        // Message
        val messageId: Long,
        val content: String,
        val attachments: List<String>,
        val embeds: List<Map<String, Any>>,
        val timestamp: Long,

        // Author
        val authorId: Long,
        val authorName: String,
        val authorDiscrim: String,
        val authorAvatar: String,
        val authorNick: String,

        // Guild
        val guildId: Long,
        val guildName: String,

        // Channel
        val channelId: Long,
        val channelName: String
)