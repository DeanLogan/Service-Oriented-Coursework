package package3;

public class Module {
	private ModuleCode moduleCode;
	private double mark;
	private String academicYear;
	
	public Module() {
		
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public ModuleCode getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(ModuleCode moduleCode) {
		this.moduleCode = moduleCode;
	}
}
