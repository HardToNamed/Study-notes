package com.csz.btree;

public interface Tree {
	public Object get(Comparable key);   //²éÑ¯
	public boolean remove(Comparable key);    //ÒÆ³ý
	public void insertOrUpdate(Comparable key, Object obj); //²åÈë»òÕß¸üÐÂ£¬Èç¹ûÒÑ¾­´æÔÚ£¬¸üÐÂ£¬·ñÔò²åÈë
}
