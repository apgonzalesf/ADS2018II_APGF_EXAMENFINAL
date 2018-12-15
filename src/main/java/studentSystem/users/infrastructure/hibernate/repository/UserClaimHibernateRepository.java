package studentSystem.users.infrastructure.hibernate.repository;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import studentSystem.common.infrastructure.hibernate.repository.BaseHibernateRepository;
import studentSystem.users.domain.entity.UserClaim;
import studentSystem.users.domain.repository.UserClaimRepository;

@Transactional
@Repository

public class UserClaimHibernateRepository extends BaseHibernateRepository<UserClaim> implements UserClaimRepository {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<UserClaim> findByUserId(BigDecimal userId) throws Exception {
		List<UserClaim> userClaims = null;

		Criteria criteria = getSession().createCriteria(UserClaim.class, "uc");
		criteria.createAlias("uc.user", "u");
		// criteria.setFetchMode("user", FetchMode.SELECT);
		criteria.add(Restrictions.eq("u.id", userId));
		userClaims = criteria.list();
		return userClaims;
	}
}
