/**
 * 
 */
/**
 * @author linjie
 *
 */
package ����ͳ��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class InfectStatistic {
	
	static class Pro {
		String name;
		int ip;
		int sp;
		int cure;
		int dead;
		public Pro() {
			this.name = null;
			this.ip = 0;
			this.sp = 0;
			this.cure = 0;
			this.dead = 0;
		}
		public Pro(String a,int b,int c,int d,int e) {
			this.name = a;
			this.ip =b;
			this.sp= c;
			this.cure =d;
			this.dead =e;
		}
	}
	
		public void GetFilelist(String n) {
			String fname;
			File file  = new File(n);
			File[] Filelist = file.listFiles();
			for(int i = 0; i < Filelist.length; i++) {
				fname = Filelist[i].getName();
				Readtxt(fname);
			}
			
			
		}
		
		public void Readtxt(String m) {
		    try {
		        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File(m)),"UTF-8"));
		        String txt = null;
		                
		        while ((txt = bf.readLine()) != null) { 
		            if(!txt.startsWith("//")) 
		                Dealwith(txt);
		        }
		        bf.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		
		private void Dealwith(String txt) {
			 String type1 = "(\\S+) ���� ��Ⱦ���� (\\d+)��";
			 String type2 = "(\\S+) ���� ���ƻ��� (\\d+)��";
			 String type3 = "(\\S+) ��Ⱦ���� ���� (\\S+) (\\d+)��";
			 String type4 = "(\\S+) ���ƻ��� ���� (\\S+) (\\d+)��";
			 String type5 = "(\\S+) ���� (\\d+)��";
			 String type6 = "(\\S+) ���� (\\d+)��";
			 String type7 = "(\\S+) ���ƻ��� ȷ���Ⱦ (\\d+)��";
			 String type8 = "(\\S+) �ų� ���ƻ���(\\d+)+��";
			 boolean isMatch1 = Pattern.matches(type1,txt);
			 boolean isMatch2 = Pattern.matches(type2,txt);
			 boolean isMatch3 = Pattern.matches(type3,txt);
			 boolean isMatch4 = Pattern.matches(type4,txt);
			 boolean isMatch5 = Pattern.matches(type5,txt);
			 boolean isMatch6 = Pattern.matches(type6,txt);
			 boolean isMatch7 = Pattern.matches(type7,txt);
			 boolean isMatch8 = Pattern.matches(type8,txt);
			 if(isMatch1) Addip();
			 
			
		}

		private void Addip() {
			// TODO �Զ����ɵķ������
			
		}

		public static void main(String[] args) {
			String date;
			String path;
			String outpath;
			int type[]= {0,0,0,0};
			int province[] = new int[32] ;
			String[] provincename = {"ȫ��", "����", "����" ,"����", "����", "����","����","�㶫", "����", 
					"����", "����", "�ӱ�", "����", "������", "����", "����", "����","����", "����", "����", "���ɹ�", 
					"����", "�ຣ", "ɽ��", "ɽ��", "����", "�Ϻ�","�Ĵ�", "̨��", "���", "����", "���", "�½�", "����", "�㽭"};
			String[] typename = {"ip","sp","cure","dead"};
			/*for(int i=0;i<args.length;i++) {
				System.out.println("args["+i+"] = " + args[i]);
			}*/
			if(!args[0].equals("list")){
				 System.out.println("�����������ӦΪlist");
				 return ;
			}
			//������������Ƿ���ȷ
			
			for (int i = 0;i<args.length;i++) {
				if(args[i].equals("-date"))
					date = args[i++];
				//��ȡ����
				if(args[i].equals("-log"))
					path = args[i++];
				//��ȡ��־λ��
				if(args[i].equals("-out"))
					outpath = args[i++];
				//��ȡ���λ��
				if(args[i].equals("-type")) {
					i++;
					for(int x = 0;x<4;x++) {
						for(int y = 0;y<4;y++) {
							if(args[i+x].equals(typename[y]))
								type[y] = 1;
						}
					}
				
				}
				//��ȡtype����
				if(args[i].equals("-province")) {
					i++;
					for(int q = 0;q<province.length;q++) {
						province[q] = 0;
					}
					for(int x = 0;x<args.length;x++) {
						for(int y = 0;y<32;y++) {
							if(args[i+x].equals(provincename[y]))
								province[y] = 1;
						}
					}
				}
				//��ȡʡ��	
			}
			
			
			

	




		}
	
}