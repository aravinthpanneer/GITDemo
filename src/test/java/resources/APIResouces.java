package resources;

public enum APIResouces {

	addBookAPI("/Library/Addbook.php"), getBookAPI("/Library/GetBook.php"), deleteBookAPI("/Library/DeleteBook.php");

	private String resource;

	private APIResouces(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
