package moe.kyubey.site.entities

data class DiscordConfig(
        val clientId: String,
        val clientSecret: String,
        val redirectUri: String,
        val admins: List<String>
)

data class DatabaseConfig(
        val host: String,
        val pass: String,
        val user: String,
        val name: String
)

data class Config(
        val port: Int,
        val botInvite: String,
        val guildInvite: String,
        val discord: DiscordConfig,
        val database: DatabaseConfig
)