package studentSystem.users.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import studentSystem.users.domain.entity.UserClaim;

public interface UserClaimRepository {
	public List<UserClaim> findByUserId(BigDecimal userId) throws Exception;
}
