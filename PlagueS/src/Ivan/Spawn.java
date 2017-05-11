package Ivan;

import java.util.ArrayList;
import java.util.Iterator;
/*
 *Will spawn virus points in one of the 50 states 
 * There shouldn't be more than one virus point on each state at a time
 * ^ Will require booleans on each state 
 * Will respawn if time runs out on the virus points as there is a timelimit
 */

public class Spawn {
	private ArrayList<String> States = new ArrayList<String>();
	
	public Spawn() {
		//States = 
		//get from other class?
	}
	public void choose(){
		for (int i = 0; i < States.size(); i++) {
			if(States.get(i).contains(null)){
				//spawn virus??
				
			}
		}
	}

}
