



public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {
    Optional<RiskScore> findByVisitorId(Long visitorId);
}
