package stack_queue_20170713_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 猫狗队列
 * 
 * 两个队列分别存储猫狗
 * 支持按照放入顺序取出所有的猫狗
 * */
public class CatAndDogStack {

	private Stack<DogWrap> dogStack = new Stack<>();
	private Stack<CatWrap> catStack = new Stack<>();
	
	private static int time;
	
	public CatAndDogStack() {
		super();
		time = 0;
	}

	public void pushDog(Dog dog) {
		DogWrap dogWrap = new DogWrap(dog, time);
		dogStack.push(dogWrap);
		time++;
	}
	
	public void pushCat(Cat cat) {
		CatWrap catWrap = new CatWrap(cat, time);
		catStack.push(catWrap);
		time++;
	}
	
	public List<Pet> popAll() {
		List<Pet> list = new ArrayList<>();
		while((!dogStack.isEmpty()) || (!catStack.isEmpty())) {
			if((!dogStack.isEmpty()) && (!catStack.isEmpty())) {
				DogWrap dog = dogStack.peek();
				CatWrap cat = catStack.peek();
				if(dog.getTime() < cat.getTime()) {
					list.add(dogStack.pop().getDog());
				}else {
					list.add(catStack.pop().getCat());
				}
				
			}else if(!dogStack.isEmpty()) {
				list.add(dogStack.pop().getDog());
				
			}else if(!catStack.isEmpty()) {
				list.add(catStack.pop().getCat());
				
			}
		}
		
		return list;
	}
	
}
