@RestController
@RequestMapping("/api/risk-scores")
@Tag(name = "Risk Scores")
public class RiskScoreController {

    private final RiskScoreService service;

    public RiskScoreController(RiskScoreService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{visitorId}")
    public RiskScore evaluate(@PathVariable Long visitorId) {
        return service.evaluateVisitor(visitorId);
    }

    @GetMapping("/{visitorId}")
    public RiskScore get(@PathVariable Long visitorId) {
        return service.getScoreForVisitor(visitorId);
    }

    @GetMapping
    public List<RiskScore> list() {
        return service.getAllScores();
    }
}
