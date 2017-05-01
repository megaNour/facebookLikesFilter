package com.mangatengu.helpers.facebook;

import java.util.Comparator;

public class LikesComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		LikesPerPerson lpp1 = (LikesPerPerson) o1;
		LikesPerPerson lpp2 = (LikesPerPerson) o2;
		if(lpp2.getCount() - lpp1.getCount() == 0)
			return lpp1.getName().compareToIgnoreCase(lpp2.getName()); 
		else { 
			return lpp2.getCount() - lpp1.getCount();
		}
	}

}
