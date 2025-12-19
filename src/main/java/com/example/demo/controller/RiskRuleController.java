@RestController
@RequestMapping("/api/risk-rules")
@Tag(name = "Risk Rules")
public class RiskRuleController {

    private final RiskRuleService service;

    public RiskRuleController(RiskRuleService service) {
        this.service = service;
    }

    @PostMapping
    public RiskRule create(@RequestBody RiskRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<RiskRule> list() {
        return service.getAllRules();
    }

    @GetMapping("/{id}")
    public RiskRule get(@PathVariable Long id) {
        return service.getRule(id);
    }
}
