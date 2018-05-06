By static HashMap :	 ( Using DBClass.java )

	GetAllNews (GET) : http://localhost:9090/EntityResource/entities
	GetOneNew (GET)  : http://localhost:9090/EntityResource/entities/1
	CreateNew (PUT)  : http://localhost:9090/EntityResource/entities
	UpdateNew (POST) : http://localhost:9090/EntityResource/entities
	DeleteNew (DELETE): http://localhost:9090/EntityResource/entities/2		
	
	-------------------------------------------------------------------------------
By Serialization : ( Using Papers.dat )	

	GetAllNews (GET) : http://localhost:9090/PaperResource/lines
	GetOneNew (GET)  : http://localhost:9090/PaperResource/lines/1
	CreateNew (PUT)  : http://localhost:9090/PaperResource/lines
	UpdateNew (POST) : http://localhost:9090/PaperResource/lines
	DeleteNew (DELETE): http://localhost:9090/PaperResource/lines/2	
	
	-------------------------------------------------------------------------------
By MySQL Database ( Using MySQLSingleton.java )	+ By Oracle Database ( Using DBSingleton.java )	

	GetAllNews (GET) : http://localhost:9090/LineResource/lines
	GetOneNew (GET) : http://localhost:9090/LineResource/lines/1
	CreateNew (PUT) : http://localhost:9090/LineResource/lines
	UpdateNew (POST) : http://localhost:9090/LineResource/lines
	DeleteNew (DELETE) : http://localhost:9090/LineResource/lines/2	
	
	-------------------------------------------------------------------------------
By Hibernate framework + MySQL Database : (Using HibernateUtil.java)	

	GetAllNews (GET) :  http://localhost:9090/HBLineResource/lines
	GetOneNew (GET) :  http://localhost:9090/HBLineResource/lines/1
	CreateNew (PUT) :  http://localhost:9090/HBLineResource/lines
	UpdateNew (POST) :  http://localhost:9090/HBLineResource/lines
	DeleteNew (DELETE) :  http://localhost:9090/HBLineResource/lines/2
	
	-------------------------------------------------------------------------------