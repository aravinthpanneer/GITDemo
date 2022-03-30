package resources;

import pojo_Class.AddBook_Pojo;
import pojo_Class.DeleteBook_Pojo;

public class TestDataBuild {
	
	
	public AddBook_Pojo AddBook_Payload(String name, String isbn,int aisle,String author) {
		AddBook_Pojo add = new AddBook_Pojo();
		add.setName(name);
		add.setIsbn(isbn);
		add.setAisle(aisle);
		add.setAuthor(author);
		
		return add;
		
	}
	public DeleteBook_Pojo DeleteBook_payload(String ID) {
		DeleteBook_Pojo del = new DeleteBook_Pojo();
		del.setID(ID);
		return del;
	}
	public String getDelete_Payload(String id) {
		return "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+id+"\"\r\n"
				+ " \r\n"
				+ "} ";
	}

}
