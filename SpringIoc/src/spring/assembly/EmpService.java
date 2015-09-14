package spring.assembly;

public class EmpService {
	private EmpDao empDao;
	private DeptDao deptDao;
	
	public EmpService() {
	}
	
	public EmpService(EmpDao empDao, DeptDao deptDao) {
		super();
		this.empDao = empDao;
		this.deptDao = deptDao;
	}


	public EmpDao getEmpDao() {
		return empDao;
	}
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	 
}
