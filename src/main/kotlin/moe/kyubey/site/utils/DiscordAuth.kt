package moe.kyubey.site.utils

import moe.kyubey.site.entities.Config
import okhttp3.*
import org.eclipse.jetty.util.MultiMap
import org.eclipse.jetty.util.UrlEncoded
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset

object DiscordAuth {
    private val okhttp = OkHttpClient()
    lateinit var config: Config

    private fun atMeRequestObject(accessToken: String, endpoint: String = ""): JSONObject {
        val res = okhttp.newCall(Request.Builder().apply {
            url("https://discordapp.com/api/v6/users/@me$endpoint")
            header("Authorization", "Bearer $accessToken")
        }.build()).execute()

        val body = res.body()!!.string()

        return JSONObject(body)
    }

    private fun atMeRequestArray(accessToken: String, endpoint: String = ""): JSONArray {
        val res = okhttp.newCall(Request.Builder().apply {
            url("https://discordapp.com/api/v6/users/@me$endpoint")
            header("Authorization", "Bearer $accessToken")
        }.build()).execute()

        val body = res.body()!!.string()

        return JSONArray(body)
    }

    fun getUserGuilds(accessToken: String) = atMeRequestArray(accessToken, "/guilds")

    fun getUser(accessToken: String) = atMeRequestObject(accessToken)

    fun exchangeCode(code: String): JSONObject {
        val data = MultiMap<String>(
                mapOf(
                        "client_id" to listOf(config.discord.clientId),
                        "client_secret" to listOf(config.discord.clientSecret),
                        "grant_type" to listOf("authorization_code"),
                        "code" to listOf(code),
                        "redirect_uri" to listOf(config.discord.redirectUri)
                )
        )

        val res = okhttp.newCall(Request.Builder().apply {
            post(
                    RequestBody.create(
                            MediaType.parse("application/x-www-form-urlencoded"),
                            UrlEncoded.encode(data, Charset.defaultCharset(), false)
                    )
            )
            url("https://discordapp.com/api/v6/oauth2/token")
            header("Content-Type", "application/x-www-form-urlencoded")
        }.build()).execute()

        val body = res.body()!!.string()
        val json = JSONObject(body)

        res.close()

        return json
    }
}