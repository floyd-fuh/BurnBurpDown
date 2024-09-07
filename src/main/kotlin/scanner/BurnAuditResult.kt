package scanner

import helpers.ExceptionThrower
import burp.api.montoya.scanner.AuditResult
import burp.api.montoya.scanner.audit.issues.AuditIssue
import scanner.audit.issues.BurnAuditIssue

class BurnAuditResult: AuditResult {
    var invocation: Int = -1
    val exceptionThrower = ExceptionThrower()
    val burnAuditIssue = BurnAuditIssue()
    override fun auditIssues(): MutableList<AuditIssue?> {
        exceptionThrower.throwIfNotDone("BurnAuditResult.auditIssues")
        invocation += 1
        if(invocation == 0){
            return mutableListOf(null)
        }
        return mutableListOf(burnAuditIssue)
    }

}