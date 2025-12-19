




public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {
    boolean existsByRuleName(String ruleName);
}
