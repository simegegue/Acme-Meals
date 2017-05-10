
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Reporter extends Actor {

	// Attributes --------------------------------------

	// Getters and Setters -----------------------------

	// Relationships -----------------------------------
	private Collection<Report> reports;

	@Valid
	@OneToMany(mappedBy = "reporter")
	public Collection<Report> getReports() {
		return reports;
	}
	public void setReports(Collection<Report> reports) {
		this.reports = reports;
	}
	
	
}
