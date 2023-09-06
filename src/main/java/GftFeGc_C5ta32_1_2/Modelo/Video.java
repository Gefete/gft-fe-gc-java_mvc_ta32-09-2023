package GftFeGc_C5ta32_1_2.Modelo;

public class Video {
	private int id;
    private String title;
    private String director;
    private int clienteId;
	
    public Video() {
	}

	public Video(int id, String title, String director, int clienteId) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.clienteId = clienteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
    
    
    
}
