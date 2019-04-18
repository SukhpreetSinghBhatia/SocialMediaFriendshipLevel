import java.util.*;
import java.io.*;
public class Advance {
	static TreeMap<String, Integer> tm=new TreeMap<String, Integer>();
	static TreeMap<String,Integer> eval=new TreeMap<String, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int users=Integer.parseInt(s);
		if (users<2||users>13) {
			return;
		}
		
		String s1=sc.nextLine();
		int msgs=Integer.parseInt(s1);
		if (msgs<0||msgs>100) {
			return;
		}
		
		
		for (int i=0;i<msgs;++i) {
			String s3=sc.nextLine();
			String [] msg_str=s3.split(" ");
			int first=Integer.parseInt(msg_str[1]);
			int second=Integer.parseInt(msg_str[2]);
			int third=Integer.parseInt(msg_str[3]);
			if(first>msgs ||first<0||second>msgs ||second<0||third>msgs ||third<0) {
				continue;
			}
			
			if (msg_str[0].equalsIgnoreCase("+")) {
				
				//int one,two,three;
				String final_check="";
				TreeSet<Integer> ts=new TreeSet<Integer>();
				ts.add(first);
				ts.add(second);
				ts.add(third);
				Iterator i2 = ts.iterator();
				while(i2.hasNext()) {
					final_check=final_check+" "+i2.next();
				}
				//System.out.println("final=="+final_check);
				try {
					eval.get(final_check);
					eval.put(final_check, eval.get(final_check)+1);
				}
				catch(Exception e4) {
					eval.put(final_check, 1);
				}
				
				try {
				tm.get(first+" "+second);
				tm.put(first+" "+second, tm.get(first+" "+second)+1);
				}
				catch(Exception e){
					tm.put(first+" "+second,1);
				}
				
				try {
				tm.get(first+" "+third);
				tm.put(first+" "+third, tm.get(first+" "+third)+1);
				}
				catch(Exception e){
					tm.put(first+" "+third,1);
				}

			}
			else if (msg_str[0].equalsIgnoreCase("-")) {
				String final_check="";
				TreeSet<Integer> ts=new TreeSet<Integer>();
				ts.add(first);
				ts.add(second);
				ts.add(third);
				Iterator i2 = ts.iterator();
				while(i2.hasNext()) {
					final_check=final_check+" "+i2.next();
				}
				//System.out.println("final=="+final_check);
				try {
					eval.get(final_check);
					eval.put(final_check, eval.get(final_check)-1);
					if (eval.get(final_check)==0) {
						eval.remove(final_check);
					}
				}
				catch(Exception e4) {
					
				}

				
				try {
				tm.get(first+" "+second);
				tm.put(first+" "+second, tm.get(first+" "+second)-1);
				if(tm.get(first+" "+second)==0) {
					tm.remove(first+" "+second);
				}
				}
				catch(Exception e){
					
				}
				
				try {
				tm.get(first+" "+third);
				tm.put(first+" "+third, tm.get(first+" "+third)-1);
				if(tm.get(first+" "+third)==0) {
					tm.remove(first+" "+third);
				}

				}
				catch(Exception e){
					
				}

			}
			else {
				continue;
			}

		}
		
		HashMap<String,Integer> spammer=new HashMap<String,Integer>();
		ArrayList<String> acq=new ArrayList<String>();
		ArrayList<String> bestf=new ArrayList<String>();
		ArrayList<String> friend=new ArrayList<String>();
		
		TreeSet<String> spammerlist=new TreeSet<String>();
		
		for (String key:eval.keySet()) {
			if (eval.get(key)>=30) {
				bestf.add(key.substring(1, key.length()));
			}

			else if (eval.get(key)>=15) {
				friend.add(key.substring(1, key.length()));
			}

			else if (eval.get(key)>=6) {
				acq.add(key.substring(1, key.length()));
			}
	
		}
		
		
		for (String key:tm.keySet()) {
			//System.out.println(key+tm.get(key));
			String [] ab=key.split(" ");
			String first=ab[0];
			String second=ab[1];
			try {
				//System.out.println(tm.get(second+" "+first));
			if (tm.get(second+" "+first)==null) {
				if (tm.get(first+" "+second)<=3) {
					spammerlist.add(first);
				}
				try {
					spammer.get(first);
					spammer.put(first, spammer.get(first)+1);
					if (spammer.get(first)>=3) {
						spammerlist.add(first);
					}
				}
				catch(Exception e2) {
					spammer.put(first, 1);
				}

			}
			}
			catch(Exception e1){
				try {
					spammer.get(first);
					spammer.put(first, spammer.get(first)+1);
					if (spammer.get(first)>=3) {
						spammerlist.add(first);
					}
				}
				catch(Exception e2) {
					spammer.put(first, 1);
				}
			}
			
			
			
		}
		String best_friend="";
		String friend2="";
		String acq2="";
		String spamm="";
		if(bestf.isEmpty()) {
			best_friend="none";
		}
		else {
		for(String bf:bestf) {
			best_friend=best_friend+"("+bf+"),";
		}
		}
		
		if(friend.isEmpty()) {
			friend2="none";
		}
		else {
		for(String bf2:friend) {
			friend2=friend2+"("+bf2+"),";
		}
		}

		if(acq.isEmpty()) {
			acq2="none";
		}
		else {
		for(String bf2:acq) {
			acq2=acq2+"("+bf2+"),";
		}
		}

		if(spammerlist.isEmpty()) {
			spamm="none";
		}
		else {
		for(String bf2:spammerlist) {
			spamm=spamm+"("+bf2+"),";
		}
		}
		
		
		
		if(best_friend.equalsIgnoreCase("none")) {
			System.out.println(best_friend);
		}
		else {
			System.out.println(best_friend.substring(0, best_friend.length()-1));
		}
		
		
		if(friend2.equalsIgnoreCase("none")) {
			System.out.println(friend2);
		}
		else {
			System.out.println(friend2.substring(0, friend2.length()-1));
		}
		
		if(acq2.equalsIgnoreCase("none")) {
			System.out.println(acq2);
		}
		else {
			System.out.println(acq2.substring(0, acq2.length()-1));
		}

		if(spamm.equalsIgnoreCase("none")) {
			System.out.print(spamm);
		}
		else {
			System.out.print(spamm.substring(0, spamm.length()-1));
		}


		
	}

}
