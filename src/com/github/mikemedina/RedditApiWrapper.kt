package com.github.mikemedina

import net.dean.jraw.RedditClient
import net.dean.jraw.http.UserAgent
import net.dean.jraw.http.oauth.Credentials
import net.dean.jraw.paginators.SubredditPaginator
import java.util.UUID

class RedditApiWrapper {

    private val userAgent = UserAgent.of("desktop", "mikes.android.app", "1.0.0", "80blite")
    private val redditClient: RedditClient = RedditClient(userAgent)

    // TODO: Obfuscate the clientId
    private var credentials = Credentials.userless("-qXby8MCUS_3rg", "", UUID(10, 5))
    private var authData = redditClient.oAuthHelper.easyAuth(credentials)

    fun getPictureUrls(): List<String> {
        redditClient.authenticate(authData)
        return SubredditPaginator(redditClient, "pics").next()
                // TODO: Make this a property
                .filter { !it.isNsfw }
                .mapNotNull {
                    it.dataNode.get("preview")?.get("images")?.get(0)?.get("source")?.get("url")?.textValue()
                }
    }

}
