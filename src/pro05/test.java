package pro05;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookShopDao dao = new BookShopDao();
		BookVo vo = new BookVo();
		
		vo.setTitle( "트와일라잇" );
		vo.setAuthorName( "스테파니메이어" );
		dao.insert( vo );
	}

}
