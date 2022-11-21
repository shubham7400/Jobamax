package com.jobamax.appjobamax.singletons

import com.parse.livequery.ParseLiveQueryClient

object MyParseLiveQueryClient {
    var parseLiveQueryClient: ParseLiveQueryClient = ParseLiveQueryClient.Factory.getClient()
}