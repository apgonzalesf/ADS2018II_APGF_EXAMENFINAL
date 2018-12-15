package studentSystem.users.domain.repository;

import java.util.List;

import studentSystem.common.domain.repository.BaseRepository;
import studentSystem.users.domain.entity.User;

public interface UserRepository extends BaseRepository<User> {

	public User getById(long userId);

	public User getByName(String name);

	public List<User> getPaginated(int page, int pageSize);
}
