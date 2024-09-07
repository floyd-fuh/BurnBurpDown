package scanner.audit.issues

import burp.api.montoya.scanner.audit.issues.AuditIssueDefinition
import burp.api.montoya.scanner.audit.issues.AuditIssueSeverity
import helpers.ExceptionThrower
import helpers.IntTester
import helpers.StringTester

class BurnAuditIssueDefinition: AuditIssueDefinition {
    val nameExceptionThrower = ExceptionThrower()
    var nameStringTester = StringTester()

    val backgroundExceptionThrower = ExceptionThrower()
    var backgroundStringTester = StringTester()

    val remediationExceptionThrower = ExceptionThrower()
    var remediationStringTester = StringTester()

    val typicalSeverityExceptionThrower = ExceptionThrower()
    var typicalSeverityCounter = -1

    val typeIndexExceptionThrower = ExceptionThrower()
    var typeIndexIntTester = IntTester()

    override fun name(): String? {
        nameExceptionThrower.throwIfNotDone("AuditIssueDefinition.name")
        return nameStringTester.next()
    }

    override fun background(): String? {
        backgroundExceptionThrower.throwIfNotDone("AuditIssueDefinition.background")
        return backgroundStringTester.next()
    }

    override fun remediation(): String? {
        remediationExceptionThrower.throwIfNotDone("AuditIssueDefinition.name")
        return remediationStringTester.next()
    }

    override fun typicalSeverity(): AuditIssueSeverity? {
        typicalSeverityExceptionThrower.throwIfNotDone("AuditIssueDefinition.typicalSeverity")
        return AuditIssueSeverity.FALSE_POSITIVE
    }

    override fun typeIndex(): Int {
        typeIndexExceptionThrower.throwIfNotDone("AuditIssueDefinition.typeIndex")
        return typeIndexIntTester.next()
    }
}