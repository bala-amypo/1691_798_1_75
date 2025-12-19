@RestController
@RequestMapping("/api/visit-logs")
@Tag(name = "Visit Logs")
public class VisitLogController {

    private final VisitLogService service;

    public VisitLogController(VisitLogService service) {
        this.service = service;
    }

    @PostMapping("/{visitorId}")
    public VisitLog create(@PathVariable Long visitorId, @RequestBody VisitLog log) {
        return service.createVisitLog(visitorId, log);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<VisitLog> list(@PathVariable Long visitorId) {
        return service.getLogsByVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public VisitLog get(@PathVariable Long id) {
        return service.getLog(id);
    }
}
