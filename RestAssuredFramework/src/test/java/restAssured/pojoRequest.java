package restAssured;

public class pojoRequest {
	
		String firstname;
		String lastname;
		String email;
		String skills[];
		
		
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String[] getSkills() {
			return skills;
		}
		public void setSkills(String[] skills) {
			this.skills = skills;
		}
		

}
