@RestController
@RequestMapping("/api/score-logs")
@Tag(name = "Score Audit Logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService service;

    public ScoreAuditLogController(ScoreAuditLogService service) {
        this.service = service;
    }

    @PostMapping("/{visitorId}/{ruleId}")
    public ScoreAuditLog create(
            @PathVariable Long visitorId,
            @PathVariable Long ruleId,
            @RequestBody ScoreAuditLog log) {
        return service.logScoreChange(visitorId, ruleId, log);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<ScoreAuditLog> list(@PathVariable Long visitorId) {
        return service.getLogsByVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public ScoreAuditLog get(@PathVariable Long id) {
        return service.getLog(id);
    }
}
