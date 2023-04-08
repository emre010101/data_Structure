package College.Subjects;

public class IntroductiontoDatabases {
	String name = "Introduction to Databases";
	String ModuleLevel = "LEVEL 8";
	static int Credits = 5;
	String learningOutcomeDesc = "LO1	Analyse and evaluate current and future trends in database technologies\r\n"
			+ "LO2	Construct and evalaute data models based on analysis of data requirements\r\n"
			+ "LO3	Comprehend and describe the relational database model\r\n"
			+ "LO4	Design, implement and evaluate a relational database system with an appropriate database package\r\n"
			+ "LO5	Formulate and assess advanced SQL queries to manipulate databases and provide value-added reporting";
	int grade;
	
	public IntroductiontoDatabases(int grad) {
		this.grade = grad;
	}
	
}
