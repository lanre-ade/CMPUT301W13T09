package com.cmput301w13t09.cmput301project;

import java.io.Serializable;

/**
 * 
 * @author Kyle, Marcus, Lanre Class: InstructionModel simply holds a string
 *         value used for holding an instruction used in InstructionsList.
 *         Includes methods toString and setInstruction.
 * 
 */
public class InstructionModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String instruction;

	public InstructionModel(String instruc) {
		this.instruction = instruc;
	}

	public String toString() {
		return this.instruction;
	}

	public void setInstruction(String instruc) {
		this.instruction = instruc;
	}

}
