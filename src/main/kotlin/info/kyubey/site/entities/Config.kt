package info.kyubey.site.entities

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
        val database: DatabaseConfig
)