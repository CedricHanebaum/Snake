package main;

import java.util.Comparator;

public class DrawComparator implements Comparator<IDrawable> {

	@Override
	public int compare(IDrawable d1, IDrawable d2) {
		return d1.getPriority() - d2.getPriority();
	}

}
