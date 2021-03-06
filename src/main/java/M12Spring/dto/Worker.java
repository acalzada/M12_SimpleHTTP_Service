package M12Spring.dto;


import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.*;

import M12Spring.exceptions.JobPositionUnkown;
import M12Spring.exceptions.MissingSalariesException;


@Entity
@Table(name="workers")
public class Worker {
	
	// Available job positions for all the company workers.
	private static enum Position {
		CEO, CTO, CFO, SALES, MARKETING, OPERATOR, SECRETARY  
	}
	
	// Annual salaries for each one of the defined job positions. 
	// Order must match the job positions defined in Position enum attribute. 
	private static int[] salaries = {100000, 80000, 85000, 60000, 50000, 30000, 40000};
	
	private static HashMap<String, Integer> positionSalaries = new HashMap<String, Integer>();
	
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false, unique = false)
	private String name;
	
	//@Enumerated(EnumType.STRING)
	private String jobPosition;
	
	@Column(name = "annualSalary") // Puesto para evitar el warning de unused variable
	private int annualSalary;
	
	
	// Constructors
	
	protected Worker() {
		initializeSalaries();
	}
	
	/*
	
	@JsonCreator
	public Worker(@JsonProperty("name") String name, @JsonProperty("position") String position) {

		initializeSalaries();
		
		this.name = name;
		
		
		if( positionIsKnown(position)) {

			this.jobPosition = position.toUpperCase();
			this.annualSalary = (int)positionSalaries.get(position.toUpperCase());
			
		}else {
			throw new JobPositionUnkown("\nJob Position Unkown: Only " + Arrays.toString(Position.values()) + " positions are recognised. You entered an unknown job position (" + position + ").");
		}
	}

	*/

	// Support methods for Constructors
	
	/**
	 * Private method for initialise the match between job positions and their annual salaries 
	 */
	private static void initializeSalaries() {
		if (Position.values().length != salaries.length) {
			throw new MissingSalariesException();
		}
		
		Position[] positionLabels = Position.values();
		for(int idx = 0; idx < positionLabels.length; idx++) {
			positionSalaries.put(positionLabels[idx].name(), salaries[idx]);
		}
	}
	
	
	/**
	 * Support method to check if a given position is defined in the Position Enum attribute.
	 * 
	 * @param position String containing the position to look for.
	 * @return Boolean value true if the given position is recognised. False if the position is not found among the known job positions.
	 */
	private static Boolean positionIsKnown(String position) {
		
		String upperCasePosition = position.toUpperCase();
		
		for(Position posLabel : Position.values()) {
			if( posLabel.name().equals(upperCasePosition)) {
				return true;
			}
		}
		
		return false;
	}
	
	// Getters & Setters
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return jobPosition;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		
		if( positionIsKnown(position)) {
			this.jobPosition = position.toUpperCase();
			// Because We do not know which property will be set first (jobPosition or annualSalary), 
			// the salary is also set once the position is defined.
			this.setAnnualSalary(positionSalaries.get(this.jobPosition));
		}else {
			throw new JobPositionUnkown("\nJob Position Unkown: Only " + Arrays.toString(Position.values()) + " positions are recognised. You entered an unknown job position (" + position + ").");
		}
	}

	/**
	 * @return the annualSalary
	 */
	public int getAnnualSalary() {
		return annualSalary;
	}

	/**
	 * @param annualSalary the annualSalary to set
	 */
	public void setAnnualSalary(int annualSalary) {
		
		// We'll allow to modify the worker salary but never to be higher than defined by Corporate rules.
		int maxSalaryByPosition = positionSalaries.get(this.jobPosition);
		
		if (annualSalary <= maxSalaryByPosition)
			this.annualSalary = annualSalary;
		else
			this.annualSalary = maxSalaryByPosition;
	}
}
