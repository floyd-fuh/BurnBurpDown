package scanner

import Api
import helpers.ExceptionThrower
import burp.api.montoya.http.message.HttpRequestResponse
import burp.api.montoya.scanner.AuditResult
import burp.api.montoya.scanner.ConsolidationAction
import burp.api.montoya.scanner.ScanCheck
import burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPoint
import burp.api.montoya.scanner.audit.issues.AuditIssue

class BurnScanCheck: ScanCheck {
    val passiveExceptionThrower = ExceptionThrower()
    val activeExceptionThrower = ExceptionThrower()
    val consolidateIssuesExceptionThrower = ExceptionThrower()

    val passiveBurnAuditResult = BurnAuditResult()
    val activeBurnAuditResult = BurnAuditResult()

    override fun passiveAudit(p0: HttpRequestResponse?): AuditResult {
        passiveExceptionThrower.throwIfNotDone("ScanCheck.passiveAudit")
        return passiveBurnAuditResult
    }

    override fun activeAudit(p0: HttpRequestResponse?, p1: AuditInsertionPoint?): AuditResult {
        activeExceptionThrower.throwIfNotDone("ScanCheck.activeAudit")
        return activeBurnAuditResult
    }

    override fun consolidateIssues(p0: AuditIssue?, p1: AuditIssue?): ConsolidationAction {
        consolidateIssuesExceptionThrower.throwIfNotDone("ScanCheck.consolidateIssues")
        return ConsolidationAction.KEEP_BOTH
    }
}