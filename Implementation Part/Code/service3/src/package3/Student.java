package package3;

public class Student {
	private int id;
	private Module[] modules = new Module[20];

	public Student() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Module[] getModules() {
		return modules;
	}

	public void setModules(Module[] modules) {
		this.modules = modules;
	}
}
