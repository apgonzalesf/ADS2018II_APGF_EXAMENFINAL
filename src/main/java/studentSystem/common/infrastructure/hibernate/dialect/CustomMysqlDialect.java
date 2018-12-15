package studentSystem.common.infrastructure.hibernate.dialect;

import java.sql.Types;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.type.StandardBasicTypes;

public class CustomMysqlDialect extends MySQL5Dialect {
	 public CustomMysqlDialect() {
		 super ();
//		 registerHibernateType (Types.BIGINT, StandardBasicTypes.LONG.getName());
	}
}
