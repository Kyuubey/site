package moe.kyubey.site.utils

import moe.kyubey.site.entities.Log

object LogSorter : Comparator<Log> {
    override fun compare(a: Log, b: Log) = if (a.messageId == b.messageId) {
        (a.timestamp - b.timestamp).toInt()
    } else 0
}