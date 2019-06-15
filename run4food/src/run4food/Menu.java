package run4food;

import java.util.ArrayList;

public interface Menu {
	public void saveDish(Dishes dish) throws Exception;
	public void deleteDish(String name) throws Exception;
	public void writeFile(ArrayList<Dishes> dishlist) throws Exception;
	
	public ArrayList<Dishes> loadCard() throws Exception;
	public ArrayList<Dishes> filterCard(ArrayList<Integer> arr) throws Exception;
	public ArrayList<Dishes> sortCard(ArrayList<Dishes> list, int sortby) throws Exception;
	
}
