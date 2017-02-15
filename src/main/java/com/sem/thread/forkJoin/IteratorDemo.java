/**
 * 
 */
package com.sem.thread.forkJoin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.javassist.expr.NewArray;

/**   
 * @Title: IteratorDemo.java 
 * @Package com.sem.thread.forkJoin 
 * @Description: 
 * @author brook.xu
 * @date 2017年2月7日 上午10:05:52 
 * @version V1.0   
 */
public class IteratorDemo {
	Lock lock=new ReentrantLock();
	public static void main(String[] args) {
		ExecutorService exe=Executors.newFixedThreadPool(60);
		for (int i = 0; i < 100000; i++) {
			Thread thread=new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					IteratorDemo demo = new IteratorDemo();
//			        demo.useListRemove();
			        demo.useIteratorRemove();
//			        demo.useListIteratorAdd();
				}
			});
			thread.setName(i+"-");
			exe.execute(thread);
		}
		exe.shutdown();
		/*IteratorDemo demo = new IteratorDemo();
        demo.useListRemove();
        demo.useIteratorRemove();
        demo.useListIteratorAdd();*/
    }

    private void useListRemove(){
        List<String> list = getList();
        int index = 0;
        for(String temp : list){
            if("aa".equals(temp)){
                // Update
                list.set(index, "dd");
//                list.remove(temp);
            }
            index ++;
        }

        System.out.println("----User List: " + list.toString());
    }

    private void useIteratorRemove(){
        List<String> list = getList();
        lock.tryLock();
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String temp = iterator.next();
            if("aa".equals(temp)){
                // Delete
                iterator.remove();
            }
        }
        lock.unlock();
        System.out.println("----Use Iterator Remove: " + list.toString());
    }

    private void useListIteratorAdd(){
        List<String> list = getList();
        ListIterator<String> listIterator = list.listIterator();

        while(listIterator.hasNext()){
            String temp = listIterator.next();
            if("aa".equals(temp)){
                listIterator.remove();
            }else if("bb".equals(temp)){
                // Add
                listIterator.add("dd");
            }
        }

        System.out.println("----Use ListIterator Add and Remove: " + list.toString());
    }

    private List<String> getList(){
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        return list;
    }
}
