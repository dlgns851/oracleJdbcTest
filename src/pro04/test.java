package pro04;

import java.util.List;

public class test {
	public static List<MemberVo> mList ;
	public static MemberDao dao = new MemberDao();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		
			
		MemberVo vo = new MemberVo();
			// 김상명 추가
			/*MemberVo vo = new MemberVo();
			vo.setEmail( "kim@bit.ac.kr" );
			vo.setName( "김비트" );
			vo.setGender( "남" );
			vo.setPassword( "12345" );
			
			dao.insertMember( vo );*/
			
			mList = dao.getListAll();
			
			
			vo = mList.get(0);
			System.out.println(vo.toString()); 
			for(int i=0; i<mList.size(); i++) {
				 vo = mList.get(i);
				
				System.out.print(vo.getId()+"|"+vo.getName()+"|"+vo.getEmail()+"|"+vo.getPassword()+"|"+vo.getGender());
				System.out.println("");
			}
			
	}

}

