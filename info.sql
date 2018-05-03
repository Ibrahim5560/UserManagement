By static HashMap :
	
	mena.db -> DBClass.java
	mena.model -> Entity.java
	mena.service -> EntityService.java (Using DBClass.java)
	mena.resource -> EntityResource.java
		
	-----------------------------------------------
By Serialization : ( Using Papers.dat )
	
	mena.model -> Paper.java
	mena.service -> PaperService.java  ( Using Papers.dat )
	mena.resource -> PaperResource.java
	-> PaperTester.java
	
	-----------------------------------------------
By MySQL Database : (Using MySQLSingleton.java)
	
	mena.db -> MySQLSingleton.java
	mena.model -> Line.java
	mena.service -> LineService.java (Using MySQLSingleton.java)
	mena.resource -> LineResource.java
	mena -> LineTester.java
	
	-----------------------------------------------
By Oracle Database : (Using DBSingleton.java)
	
	mena.db -> DBSingleton.java
	mena.model -> Line.java
	mena.service -> LineService.java (Using DBSingleton.java)
	mena.resource -> LineResource.java
	mena -> LineTester.java
	
	-----------------------------------------------	
By Hibernate framework + MySQL Database : (Using HibernateUtil.java)

	mena.db -> HibernateUtil.java
	mena.model -> HBLine.java
	mena.service -> HBLineService.java (Using HibernateUtil.java)
	mena.resource -> HBLineResource.java
	mena -> HBLineTester.java
	-> HBLine.hbm.xml
	-> hibernate.cfg.xml
	-----------------------------------------------