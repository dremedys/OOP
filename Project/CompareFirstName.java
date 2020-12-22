package intranet;

import java.util.Comparator;

public class CompareFirstName implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		
		return o1.getFullNameRev().compareTo(o2.getFullNameRev());
	}

}
