package Advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Train {

	

	class TrainNode {
		List<String> car;
		Map<String, Integer> carMap;
		char tail;

		public TrainNode(List<String> car,Map<String, Integer> carMap, char tail) {
			this.car = car;
			this.tail = tail;
			this.carMap=carMap;
		}
	}

	public void getLongestFrieghtCar(List<String> cars) {
		if (cars == null || cars.size() == 0)
			return;
		
		List<String> output = new ArrayList<String>();
		
		Map<Character, List<String>> carMap = new HashMap<Character, List<String>>();
		Map<String, Integer> carCounter = new HashMap<String, Integer>();
		Queue<TrainNode> que = new LinkedList<TrainNode>();
		StringBuilder sb;


		for (String car : cars) {
			
			// reverse car if front char > end char
			if (car.charAt(0) > car.charAt(car.length() - 1)) {
				sb = new StringBuilder(car);
				car =sb.reverse().toString();
			}
			
			if(car.charAt(0) == car.charAt(car.length() - 1)){
				int j = car.length()-1;
				for(int i =0;i<car.length()/2;i++){
					if(car.charAt(i)>car.charAt(j)){
						sb = new StringBuilder(car);
						car =sb.reverse().toString();
						break;
					}
					j--;
				}
			}
			
			// map key with first character head
			if (carMap.containsKey(car.charAt(0))) {
				carMap.get(car.charAt(0)).add(car);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(car);
				carMap.put(car.charAt(0), list);
			}

			// counter map
			if (carCounter.containsKey(car)) {
				carCounter.put(car,carCounter.get(car)+1);
			} else {
				carCounter.put(car,1);
			}
			
			List<String> list = new ArrayList<String>();
			list.add(car);
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put(car, 1);
			TrainNode node = new TrainNode(list,map,car.charAt(car.length() - 1));
			que.offer(node);
			if ((list.size() > output.size())||(list.size()==output.size() && list.get(0).charAt(0)>output.get(0).charAt(0)))
				output = list;
			 
		}

		
		while (!que.isEmpty()) {
			TrainNode currNode = que.poll();
			
			if (carMap.containsKey(currNode.tail)) {
				List<String> carList = carMap.get(currNode.tail);
				for (String s : carList) {
					Map<String, Integer> map = currNode.carMap;
					if (!map.containsKey(s) || map.get(s)<carCounter.get(s)) {
						List<String> newList = new ArrayList<String>(currNode.car);
						Map<String, Integer> newMap = new HashMap<String, Integer>(map);
						if(newMap.containsKey(s)){
							while(newMap.get(s) < carCounter.get(s)){
								newList.add(s);
								newMap.put(s, newMap.get(s)+1);
							}
						}
						else{
							newList.add(s);
							newMap.put(s, 1);
						}
						
						System.out.println(newMap);
						TrainNode node = new TrainNode(newList,newMap, s.charAt(s.length()-1));
						que.offer(node);
						if ((newList.size() > output.size())||(newList.size()==output.size() && newList.get(0).charAt(0)>output.get(0).charAt(0))){
							output = newList;	
						} else if(newList.size()==output.size() && newList.get(0).charAt(0)==output.get(0).charAt(0)){
							for(int i =0;i<newList.get(0).length();i++){
								if(i<output.get(0).length() && newList.get(0).charAt(i)<output.get(0).charAt(i)){
									output = newList;
									break;
								}
							}
						}
						
						
							
					}
				}
			}
		}
		
		// print output
		for(int i=0;i<output.size();i++){
			if(i==0)
				System.out.print(output.get(i));
			else
				System.out.print("-" + output.get(i) );
		}
		

	}

	public static void main(String[] args) {
		Train t = new Train();
		List<String> list = new ArrayList<String>();

		list.add("AAA");
		list.add("BXDA");
		list.add("CCC");
		list.add("CCC");
		list.add("CCC");
		list.add("CCC");
		list.add("CCC");
		list.add("CCC");
		list.add("CBC");
		list.add("CCC");
		list.add("CCC");
		list.add("CCC");
		list.add("CCC");
		
	
		
		t.getLongestFrieghtCar(list);

	}

}
