package myboard.constants;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

/*
 * 상수를 선언하면서 final을 선언하는데 프로그램 도중에는 수정할 수 없음. 
 * 그러나 상수를 따로 선언해서 사용한다면 선언한 곳 한곳만 변경해주면 모든 곳이 한번에 적용이 됨.
 * 각각 자주 사용하는 문구나 숫자를 한 곳에서 볼 수 있어서 유지보수에도 유용함.
 */

public class MyboardConstants {
	
	public static Properties querys;
	
	//스태틱 변수의 값을 초기화 할 때 사용.
	static {
	
		querys = new Properties();	
		try {
			File file = new File("C:/selffy/elipse_workspace/MyBoard/src/main/webapp/WEB-INF/props/query.properties");
			Reader reader = new FileReader(file);			
			querys.load(reader);	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

//	public final static String LIST_SQL  = " select * from board order by bid desc ";
//	
//	public final static String WRITE_SQL = " insert into board (btitle, bcontent, bwdate, bdomain, bwriterid) ";
//	
//	public final static String UPDATE_SQL = " update board set btitle=?, bcontent=?, bdomain=?, bwriterid=? ";
//	
//	public final static String DELETE_SQL = " delete board where bid=? ";
//	
////	public final static String 	LIST_DOMAIN_SQL = select * from board where bdomain=? order by bid desc 
////			
////	public final static String LIST_SEARCH_SQL_PREPEND= select * from board 
////	
////	public final static String LIST_SEARCH_SQL_APPEND= order by bid desc 
}
