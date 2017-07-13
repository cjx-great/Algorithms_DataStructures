package stack_queue_20170713_2;

/**
 * 封装类
 * */
public class CatWrap {
	
	private Cat cat;
	
	//时间戳用于记录插入时间
	private int time;

	public CatWrap(Cat cat, int time) {
		super();
		this.cat = cat;
		this.time = time;
	}

	public Cat getCat() {
		return cat;
	}

	public int getTime() {
		return time;
	}
	
}
