package package1;

public class AcademicStaffMember {
	private int id;
	private Module1[] moduleArray = new Module1[2];
	
	public AcademicStaffMember() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Module1[] getModuleArray() {
		return moduleArray;
	}

	public void setModuleArray(Module1[] moduleArray) {
		this.moduleArray = moduleArray;
	}
}

