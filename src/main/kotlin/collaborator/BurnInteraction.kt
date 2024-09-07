package collaborator

import burp.api.montoya.collaborator.*
import java.net.InetAddress
import java.time.ZonedDateTime
import java.util.*

class BurnInteraction: Interaction {
    override fun id(): InteractionId {
        TODO("Not yet implemented")
    }

    override fun type(): InteractionType {
        TODO("Not yet implemented")
    }

    override fun timeStamp(): ZonedDateTime {
        TODO("Not yet implemented")
    }

    override fun clientIp(): InetAddress {
        TODO("Not yet implemented")
    }

    override fun clientPort(): Int {
        TODO("Not yet implemented")
    }

    override fun dnsDetails(): Optional<DnsDetails> {
        TODO("Not yet implemented")
    }

    override fun httpDetails(): Optional<HttpDetails> {
        TODO("Not yet implemented")
    }

    override fun smtpDetails(): Optional<SmtpDetails> {
        TODO("Not yet implemented")
    }

    override fun customData(): Optional<String> {
        TODO("Not yet implemented")
    }

}