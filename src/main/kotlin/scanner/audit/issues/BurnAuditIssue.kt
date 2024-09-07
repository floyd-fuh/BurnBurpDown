package scanner.audit.issues

import helpers.ExceptionThrower
import burp.api.montoya.collaborator.Interaction
import burp.api.montoya.http.HttpService
import burp.api.montoya.http.message.HttpRequestResponse
import burp.api.montoya.scanner.audit.issues.AuditIssue
import burp.api.montoya.scanner.audit.issues.AuditIssueConfidence
import burp.api.montoya.scanner.audit.issues.AuditIssueDefinition
import burp.api.montoya.scanner.audit.issues.AuditIssueSeverity
import collaborator.BurnInteraction
import helpers.StringTester
import helpers.UrlStringTester
import http.BurnHttpService
import http.message.BurnHttpRequestResponse

class BurnAuditIssue: AuditIssue {
    val nameExceptionThrower = ExceptionThrower()
    var nameStringTester = StringTester()

    val detailExceptionThrower = ExceptionThrower()
    var detailStringTester = StringTester()

    val remediationExceptionThrower = ExceptionThrower()
    var remediationStringTester = StringTester()

    val httpServiceExceptionThrower = ExceptionThrower()
    val burnHttpService = BurnHttpService()
    var httpServiceCounter = -1

    val baseUrlExceptionThrower = ExceptionThrower()
    var baseUrlStringTester = UrlStringTester()

    val severityExceptionThrower = ExceptionThrower()

    val confidenceExceptionThrower = ExceptionThrower()

    val requestResponsesExceptionThrower = ExceptionThrower()
    var requestResponsesCounter = -1
    val burnHttpRequestResponse = BurnHttpRequestResponse()

    val collaboratorInteractionsExceptionThrower = ExceptionThrower()
    var collaboratorInteractionsCounter = -1
    val burnInteraction = BurnInteraction()

    val definitionInteractionExceptionThrower = ExceptionThrower()
    var definitionCounter = -1
    val burnAuditIssueDefinition = BurnAuditIssueDefinition()


    override fun name(): String? {
        nameExceptionThrower.throwIfNotDone("BurnAuditIssue.name")
        return nameStringTester.next()
    }

    override fun detail(): String? {
        detailExceptionThrower.throwIfNotDone("BurnAuditIssue.detail")
        return detailStringTester.next()
    }

    override fun remediation(): String? {
        remediationExceptionThrower.throwIfNotDone("BurnAuditIssue.remediation")
        return remediationStringTester.next()
    }

    override fun httpService(): HttpService? {
        httpServiceExceptionThrower.throwIfNotDone("BurnAuditIssue.httpService")
        httpServiceCounter += 1
        if(httpServiceCounter == 0)
            return null
        return burnHttpService
    }

    override fun baseUrl(): String? {
        baseUrlExceptionThrower.throwIfNotDone("BurnAuditIssue.baseUrl")
        return baseUrlStringTester.next()
    }

    override fun severity(): AuditIssueSeverity {
        severityExceptionThrower.throwIfNotDone("BurnAuditIssue.severity")
        return AuditIssueSeverity.FALSE_POSITIVE
    }

    override fun confidence(): AuditIssueConfidence {
        confidenceExceptionThrower.throwIfNotDone("BurnAuditIssue.confidence")
        return AuditIssueConfidence.CERTAIN
    }

    override fun requestResponses(): MutableList<HttpRequestResponse?>? {
        requestResponsesExceptionThrower.throwIfNotDone("BurnAuditIssue.requestResponses")
        requestResponsesCounter += 1
        if(requestResponsesCounter == 0)
            return null
        else if(requestResponsesCounter == 1)
            return mutableListOf(null)
        else
            //TODO()
            //return mutableListOf(burnHttpRequestResponse)
            return mutableListOf()
    }

    override fun collaboratorInteractions(): MutableList<Interaction?>? {
        collaboratorInteractionsExceptionThrower.throwIfNotDone("BurnAuditIssue.collaboratorInteractions")
        collaboratorInteractionsCounter += 1
        if(collaboratorInteractionsCounter == 0)
            return null
        else if(collaboratorInteractionsCounter == 1)
            return mutableListOf(null)
        else
            //TODO()
            //return mutableListOf(burnInteraction)
            return mutableListOf()
    }

    override fun definition(): AuditIssueDefinition? {
        definitionInteractionExceptionThrower.throwIfNotDone("BurnAuditIssue.definition")
        definitionCounter += 1
        if(definitionCounter == 0)
            return null
        return burnAuditIssueDefinition
    }
}